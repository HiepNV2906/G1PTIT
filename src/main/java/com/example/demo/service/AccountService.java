package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Person;

public interface AccountService {
	public Person login(String email, String password);
	public boolean logout(String username);
	public boolean updatePassword(String email, String password);
	public Optional<Person> findByEmail(String email);
	public Person findById(Integer id);
}
