package com.capgemini.makereservationservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.capgemini.makereservationservice.entity.Bill;
import com.capgemini.makereservationservice.model.BillModel;

@Component
public class BillMapper {
	public Bill mapDtoToEntity(BillModel model) {
		Bill bill = new Bill();
		bill.setBillid(model.getBillid());
		bill.setGuestName(model.getGuestName());
		bill.setGuestEmail(model.getGuestEmail());
		bill.setRoomno(model.getRoomno());
		bill.setRoomType(model.getRoomType());
		bill.setBillDate(model.getBillDate());
		bill.setDays(model.getDays());
		bill.setRate(model.getRate());
		bill.setExtensiondays(model.getExtensiondays());
		bill.setExtensionMoney(model.getExtensionRate());
		bill.setTax(model.getTax());
		bill.setTotalBill(model.getTotalBill());
		return bill;
	}
	
	public BillModel mapEntityToDto(Bill bill) {
		BillModel model=new BillModel();
		BeanUtils.copyProperties(bill, model);
		return model;
	}
}
