package com.capgemini.manageguestservice.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.manageguestservice.entity.Address;
import com.capgemini.manageguestservice.model.AddressModel;

@Component
public class AddressMapper {
	public Address mapDtoToEntity(AddressModel address) {
		Address addressEntity = new Address();
		addressEntity.setId(address.getId());
		addressEntity.setStreetName(address.getStreetName());
		addressEntity.setHouseNo(address.getHouseNo());
		addressEntity.setCity(address.getCity());
		addressEntity.setState(address.getState());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setPincode(address.getPincode());
		return addressEntity;
	}
	public AddressModel mapEntityToDto(Address address) {
		AddressModel addressModel= new AddressModel();
		addressModel.setId(address.getId());
		addressModel.setStreetName(address.getStreetName());
		addressModel.setHouseNo(address.getHouseNo());
		addressModel.setCity(address.getCity());
		addressModel.setState(address.getState());
		addressModel.setCountry(address.getCountry());
		addressModel.setPincode(address.getPincode());
		return addressModel;
	}
}
