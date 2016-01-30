package com.yourway.mvc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yourway.mvc.entities.Person;
import com.yourway.mvc.json.JsonPerson;
import com.yourway.mvc.repository.PersonDAO;

@Controller
public class LoginController {
	
	@Autowired
	private PersonDAO dao;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value="/do_signup",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody JsonPerson doSignup(HttpSession session ,@RequestBody JsonPerson json){
		String error = json.getError();
		Person person = new Person();
		person.setUsername(json.getUsername());
		person.setPassword(json.getPassword());
		person.setRegistrationDate(new Date());
		person.setLastLogin(new Date());
		boolean result = dao.addPerson(person);
		if(!result){
			json.setError("ERROR");
			System.out.println(json.toString());
		}else{
			session.setAttribute("username", person.getUsername());
			email(person.getUsername());
		}
		return json;	
	}
	
	public boolean email(String email) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("from", "teymurbey86@gmail.com");						
		model.put("subject", "Congratulation you are logged in!");
		model.put("to", email); //Attention	
		model.put("ccList", new ArrayList<String>());
		model.put("bccList", new ArrayList<String>());
		model.put("urlimmigration", "https://www.google.com"); 
		model.put("username", email);
		
		boolean result = emailService.sendEmail("registered.vm", model);
		if(result == true) {
			return true;			
		}
		return false;	
	}	
	
	@RequestMapping(value="/do_login",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody JsonPerson doLogin(HttpSession session, @RequestBody JsonPerson json){
		Person person = new Person();
		person.setUsername(json.getUsername());
		person.setPassword(json.getPassword());
		person.setLastLogin(new Date());
		List<Person> result = dao.findPersonByUsernameAndPassword(person);
		if(result.size()==0){
			json.setError("ERROR");
		}else{
			session.setAttribute("username", person.getUsername());
		}
		return json;	
	}

	@RequestMapping(value="/logout")
	public String loggedOut(HttpSession session){
		session.invalidate();
		return "index";
	}
	
}
