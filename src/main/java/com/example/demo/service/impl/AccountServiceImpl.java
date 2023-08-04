package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	PersonRepository personRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Person login(String email, String password) {
		Optional<Person> person = personRepository.findByEmail(email);
		if (!person.isPresent()) {
			throw new AccountException("Email is not found!!!");
		}
		if(!bCryptPasswordEncoder.matches(password, person.get().getPassword())) {
			throw new AccountException("Password is incorrect!!!");
		}
		return person.get();
	}

	@Override
	public boolean logout(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		Optional<Person> person = personRepository.findByEmail(email);
		if (!person.isPresent()) {
			throw new AccountException("Email is not found!!!");
		}
		Person p = person.get();
		p.setPassword(bCryptPasswordEncoder.encode(password));
		personRepository.save(p);
		return true;
	}

	@Override
	public Optional<Person> findByEmail(String email) {
		return Optional.empty();
	}

	@Override
	public Person findById(Integer id) {
		return personRepository.getById(id);
	}

}
