package com.capgemini.addressbookapp.persondto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;

public @Data class AddressBookDTO {
	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$" , message = "First name should contain atleast 3 characters with first character upper case")
	private String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$" , message = "Last name should contain atleast 3 characters with first character upper case")
	private String lastName;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	@Pattern(regexp = "[0-9]{6}", message = "Invalid Zip Code")
	private String zipCode;
	@NotNull
	@Pattern(regexp = "^[1-9]{1}[0-9]{9}$", message = "Invalid Phone Number")
	private String phoneNumber;
}