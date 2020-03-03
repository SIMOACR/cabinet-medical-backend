package com.cabinet.cabinetmedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.cabinetmedical.entity.User;
import com.cabinet.cabinetmedical.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getPatients(){
		return userRepository.findPatients();
	}
	
	public User getUserByRdvId(Long idRdv) {
		return userRepository.findUserByRdvId(idRdv);
	}
	
	
}
