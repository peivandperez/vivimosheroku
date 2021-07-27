package vivimosJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vivimosJava.model.ImagesDTO;

@Controller
public class FileUploadController {

	@RequestMapping("/fileUpload")
	public String getFileUpload() {
		return "fileUpload";
	}
	
	@PostMapping("fileUpload/save")
	public String saveImage(ImagesDTO imagesDTO,
			@RequestParam("file") MultipartFile file) {
		
		//store the file
		//store file name entity to class
		//save entity
		
		return "fileUpload";
		
	}
}
