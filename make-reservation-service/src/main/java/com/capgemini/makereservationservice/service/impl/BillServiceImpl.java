package com.capgemini.makereservationservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.capgemini.makereservationservice.entity.Bill;
import com.capgemini.makereservationservice.entity.Reservation;
import com.capgemini.makereservationservice.mapper.BillMapper;
import com.capgemini.makereservationservice.model.BillModel;
import com.capgemini.makereservationservice.model.GuestModel;
import com.capgemini.makereservationservice.model.RoomModel;
import com.capgemini.makereservationservice.repository.BillRepository;
import com.capgemini.makereservationservice.repository.ReservationRepository;
import com.capgemini.makereservationservice.service.BillService;

@Component
public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private RestTemplate resttemplate;
	@Autowired
	private ReservationRepository reservationRepository;
	
	public BillModel issueBill(int roomno) {
		List<Reservation> reservationlist=reservationRepository.findAllByRoomnoAndStatus(roomno,"staying");
		Date presentDate=new Date();
		Reservation reservationdata= new Reservation();
		for(Reservation bookingSearch : reservationlist) {
			if(bookingSearch.getCheckOut().before(presentDate)) {
				reservationdata = bookingSearch;
				break;
			}
		}
		Random rd = new Random();
		BillModel billModel=new BillModel();
		billModel.setBillid(rd.nextInt(Integer.MAX_VALUE));
		
		GuestModel guest = resttemplate.getForEntity("http://localhost:8088/ManageGuest/viewguest/{email}", GuestModel.class,reservationdata.getGuestEmail()).getBody();
		billModel.setGuestName(guest.getFirstName()+" "+guest.getLastName());
		billModel.setGuestEmail(reservationdata.getGuestEmail());
		billModel.setRoomno(roomno);
		
		RoomModel roomDetails = resttemplate.getForEntity("http://localhost:8087/ManageRoom/viewroom/{roomno}", RoomModel.class,reservationdata.getRoomno()).getBody();
		
		billModel.setRoomType(roomDetails.getType());
		billModel.setBillDate(presentDate);
		
		long diffInMillis=Math.abs(reservationdata.getCheckOut().getTime()-reservationdata.getCheckIn().getTime());
		long diff=TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
		billModel.setDays((int)diff);
		
		billModel.setRate(roomDetails.getFirst_night_rate());
		
		long diffInMilli=Math.abs(presentDate.getTime()-reservationdata.getCheckOut().getTime());
		long dif=TimeUnit.HOURS.convert(diffInMilli, TimeUnit.MILLISECONDS);
		if(dif <= roomDetails.getCheck_out_time().getHours()) {
		billModel.setExtensiondays(0);
		}else {
			billModel.setExtensiondays((int)dif/24);
		}
		billModel.setExtensionRate(roomDetails.getExtension_rate());
		billModel.setTax(18);
		
		double bill= (billModel.getDays() * billModel.getRate()) + (billModel.getExtensiondays() * (billModel.getRate() + billModel.getExtensionRate()));
		double totalbill= bill*1.18;
		billModel.setTotalBill(totalbill);
		
		@SuppressWarnings("unused")
		Bill billEntity= billRepository.save(billMapper.mapDtoToEntity(billModel));
		reservationdata.setStatus("checked_out");
		reservationRepository.save(reservationdata);
		return billModel;
	}

}
