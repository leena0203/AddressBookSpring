package com.capgemini.addressbookapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.addressbookapp.execption.AddressBookException;
import com.capgemini.addressbookapp.model.Person;
import com.capgemini.addressbookapp.persondto.AddressBookDTO;
import com.capgemini.addressbookapp.persondto.ResponseDTO;
import com.capgemini.addressbookapp.service.IAddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
	private IAddressService addressService;

	@ApiOperation(value = "this is used for demo thing")
	@GetMapping("/")
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get call success", HttpStatus.OK);
	}

	/**
	 * This API fetch the person present in address book with the given id
	 * 
	 * @param contactId
	 * @return
	 * @throws AddressBookException
	 */
	@ApiOperation(value = "This api is used to fetch details by person", notes = "Enter ContactId in long form", response = Person.class)
	@GetMapping("/{contactId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable("contactId") Long contactId)
			throws AddressBookException {
		Person person = addressService.getPersonById(contactId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Got Person with given id", person), HttpStatus.OK);
	}

	/**
	 * This API is creating new entry in database
	 * 
	 * @param employeeDTO
	 * @return
	 */
	@ApiOperation(value = "This api is used to create")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody AddressBookDTO addressbookDTO) {
		Person person = addressService.addPerson(addressbookDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added a new person in address book", person),
				HttpStatus.CREATED);
	}
}