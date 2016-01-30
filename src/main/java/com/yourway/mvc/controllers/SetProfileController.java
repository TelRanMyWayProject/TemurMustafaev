package com.yourway.mvc.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yourway.mvc.entities.Address;
import com.yourway.mvc.entities.Country;
import com.yourway.mvc.entities.Person;
import com.yourway.mvc.entities.PersonData;
import com.yourway.mvc.json.JsonPersonData;
import com.yourway.mvc.repository.PersonDAO;

@Controller
public class SetProfileController {

	@Autowired
	private PersonDAO dao;
	
	@RequestMapping(value="/do_setprofile",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody JsonPersonData doSignup(HttpSession session ,@RequestBody JsonPersonData json){
		List<Person> prs = dao.findPersonByUsername((String) session.getAttribute("username"));
		PersonData personData = new PersonData();
		personData.setFirstName(json.getFirstName());
		personData.setLastName(json.getLastName());
		personData.setGender(json.getGender());
		personData.setBirthplace(new Country(json.getBirthPlace(),"http://www"));
		personData.setBirthday(new Date());
		personData.setCitizenship(new Country(json.getCitizenship(),"http://www"));
		personData.setFamilyStatus(json.getFamilyStatus());
		personData.setHomePhone(json.getHomePhone());
		personData.setWorkPhone(json.getWorkPhone());
		personData.setMobilePhone(json.getMobilePhone());
//		personData.setAddress(new Address(json.getAddresses(), json.getAddresses(), json.getAddresses()
//				, json.getAddresses(), json.getAddresses(),true));
//		Person person = prs.get(0);
//		dao.setPersonData(person, personData);
		
		return json;	
	}
	
}
