package com.capgemini.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.addressbookapp.model.Person;

@Repository
public interface IAddressBookRepository extends JpaRepository<Person, Long> {

}
