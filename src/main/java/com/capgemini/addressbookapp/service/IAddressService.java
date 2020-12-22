package com.capgemini.addressbookapp.service;

import javax.validation.Valid;

import com.capgemini.addressbookapp.execption.AddressBookException;
import com.capgemini.addressbookapp.model.Person;
import com.capgemini.addressbookapp.persondto.AddressBookDTO;

public interface IAddressService {

	public Person getPersonById(Long contactId) throws AddressBookException;

	public Person addPerson(AddressBookDTO addressbookDTO);

}
