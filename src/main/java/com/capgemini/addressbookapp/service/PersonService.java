package com.capgemini.addressbookapp.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.addressbookapp.execption.AddressBookException;
import com.capgemini.addressbookapp.model.Person;
import com.capgemini.addressbookapp.persondto.AddressBookDTO;
import com.capgemini.addressbookapp.repository.IAddressBookRepository;

@Service
public class PersonService implements IAddressService {
	@Autowired
	private IAddressBookRepository personRepository;
	@Autowired
	private ModelMapper mapper;

	/**
	 *
	 *@param
	 *@return
	 */
	@Override
	public Person addPerson(AddressBookDTO addressbookDTO) {
			Person person = mapper.map(addressbookDTO, Person.class);
			return personRepository.save(person);
	}

	@Override
	public Person getPersonById(Long contactId) throws AddressBookException {
		return personRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Invalid Person id"));
	}

}	