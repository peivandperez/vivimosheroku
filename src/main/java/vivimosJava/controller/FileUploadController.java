package vivimosJava.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vivimosJava.model.ImagesDTO;
import vivimosJava.service.ImagesService;

@Controller
public class FileUploadController {
	
	@Autowired
	ImagesService imagesService;

	@GetMapping("/fileUpload")
	public String showFormFileUpload(Model model) {
		model.addAttribute("images", new ImagesDTO());
		return "fileUpload";
	}
	
	@PostMapping("fileUpload/save")
	public String saveImage(@ModelAttribute("images") ImagesDTO imagesDTO,
			ModelMap model, @RequestParam("file") MultipartFile file) {
					
			
		
		//store the file
		//store file name entity to class
		//save entity
		
		return "fileUpload";
		
	}
}
