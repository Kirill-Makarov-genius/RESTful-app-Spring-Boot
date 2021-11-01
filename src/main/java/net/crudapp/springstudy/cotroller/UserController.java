package net.crudapp.springstudy.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.crudapp.springstudy.model.User;
import net.crudapp.springstudy.service.UserService;

@Controller
public class UserController {

	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public String showAllUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "showAllUsers";
	}
	
	@GetMapping("/user-create")
	public String createUserForm(User user) {
		return "user-create";
	}
	
	@PostMapping("/user-create")
	public String createUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@DeleteMapping("/user{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
	
	@GetMapping("/user-edit/{id}")
	public String editUserForm(@PathVariable("id") long id, Model model) {
		User oldUser = userService.findById(id);
		model.addAttribute("user", oldUser);
		return "user-edit";
	}
	
	@PatchMapping("/user-edit/{id}")
	public String editUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	

	
}

















