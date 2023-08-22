package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.AddressDTO;
import com.bookstore.dto.ApiResponse;
import com.bookstore.dto.DetachedAddressDTO;
import com.bookstore.entities.Address;

public interface AddressService 
{
	public ApiResponse addressDetails(Long userId, AddressDTO addressDTO);
//	public List<AddressDTO> getAddress(Long userId);
	public List<DetachedAddressDTO> getAddress(Long userId);
	public ApiResponse deleteAddress(Long userId, Long addressId);
}
