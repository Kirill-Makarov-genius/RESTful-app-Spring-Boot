package net.crudapp.springstudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.crudapp.springstudy.model.User;
import net.crudapp.springstudy.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findById(long id) {
		
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public void  saveUser(User user) {
		
		userRepository.save(user);
	}
	
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	
}



















