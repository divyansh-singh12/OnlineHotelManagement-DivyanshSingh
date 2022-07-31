package com.capgemini.retrievereportservice.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.retrievereportservice.model.IncomeList;
import com.capgemini.retrievereportservice.model.IncomeReportModel;
import com.capgemini.retrievereportservice.repository.StaffReportRepository;
import com.capgemini.retrievereportservice.service.IncomeReportService;
@Component
public class IncomeReportServiceImpl implements IncomeReportService {
	
	@Autowired
	private StaffReportRepository staffReportRepository;
	
	public File generateIncomeReport(IncomeList incomelist) {
		StringBuilder filecontent= new StringBuilder("Bill_id,Room_No,Guest_Name,Bill_Date,Total_Bill\n");
		double totalIncome = 0;
		List<IncomeReportModel> list= incomelist.getIncomeReportList();
		for(IncomeReportModel model:list) {
			filecontent.append(model.getBillid()).append(",").append(model.getRoomno()).append(",").append(model.getGuestname()).append(",").append(model.getBilldate()).append(",").append(model.getTotalbill()).append("\n");
			totalIncome+=model.getTotalbill();
		}
		filecontent.append("\n");
		filecontent.append("Total_Income").append(",").append("Salaries_Paid").append(",").append("Profit").append("\n");
		double salaries= staffReportRepository.sumSalary();
		double profit=totalIncome-salaries;
		filecontent.append(totalIncome).append(",").append(salaries).append(",").append(profit).append("\n");
		
		String filename="D:\\\\Online Hotel Management System\\\\Incomereport.csv";
		
		try {
			
			FileWriter filewriter = new FileWriter(filename);
			filewriter.write(filecontent.toString());
			filewriter.flush();
			filewriter.close();
			
			}catch(IOException e) {
				
				System.out.println(e);
			}
			
			File file= new File(filename);		
			return file;
		
	}

}
