package com.spring.data.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.practice.dao.PersonDao;
import com.spring.data.practice.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonContoller {

	@Autowired
	private PersonDao personDao;

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String addPersonDetails(@RequestBody Person person) {
		String status = personDao.savePerson(person);
		return status;
	}
}
