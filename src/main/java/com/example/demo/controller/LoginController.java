package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.exception.AccountException;
import com.example.demo.model.Person;
import com.example.demo.service.AccountService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/login", produces = "application/json")
	public String login(@RequestBody LoginDTO acc, HttpSession session, BindingResult result) {
		if(result.hasErrors()) {
			return "Error!!!";
		}
		Person p;
		try {
			p = accountService.login(acc.getUsername(), acc.getPassword());
			session.setAttribute("user", p);
			return "Successful!!!";
		}
		catch (AccountException ex) {
			System.out.println(ex);
			switch(ex.getMessage()) {
				case "Email is not found!!!":
					result.addError(new FieldError("loginRequest", "username", "Email does not exist"));
					break;
				case "Password is incorrect!!!":
					result.addError(new FieldError("loginRequest", "password", "Password is incorrect!!!"));
					break;			
			}
			return "Error!!!";
		}
	}
}
