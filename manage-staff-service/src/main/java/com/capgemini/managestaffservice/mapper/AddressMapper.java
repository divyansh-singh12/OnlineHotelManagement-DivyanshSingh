package com.capgemini.managestaffservice.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.managestaffservice.entity.Address;
import com.capgemini.managestaffservice.model.AddressModel;

@Component
public class AddressMapper {
	public Address mapDtoToEntity(AddressModel address) {
		Address addressentity = new Address();
		addressentity.setId(address.getId());
		addressentity.setStreetName(address.getStreetName());
		addressentity.setHouseNo(address.getHouseNo());
		addressentity.setCity(address.getCity());
		addressentity.setState(address.getState());
		addressentity.setCountry(address.getCountry());
		addressentity.setPincode(address.getPincode());
		return addressentity;
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
