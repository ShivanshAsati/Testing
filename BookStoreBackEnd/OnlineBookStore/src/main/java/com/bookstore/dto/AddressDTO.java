package com.bookstore.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddressDTO 
{
	private String street;
	private String landmark;	
	private String city;	
	private String state;	
	private String country;	
	private String zipcode;
}
