package vivimosJava.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.UsersSimpleService;

@Controller
public class UsersSimpleController {
	@Autowired
	UsersSimpleService usersSimpleService;
	
	@GetMapping("/invierte")
	public String showForm(Model model) {
		model.addAttribute("user", new UsersSimpleDTO());
		return "invierte";
	}
	
	 @PostMapping("/invierteForm")
	   public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person) {
		 	usersSimpleService.insert(person);
	        return "gracias-invertir-propiedades";
	    }
	
}
