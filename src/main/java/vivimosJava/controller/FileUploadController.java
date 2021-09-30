package vivimosJava.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@PostMapping("/fileUpload/Save")
	public String saveImage(ImagesDTO imagesDTO,
			RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		
		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		System.out.println(fileName);
		
		
		imagesDTO.setIdpropiedad(1);
		imagesDTO.setName("test01");
		imagesDTO.setFilepath(fileName);
		System.out.println(imagesDTO.toString());
		
		imagesService.insert(imagesDTO);
		
		String uploadDir="./src/main/resources/static/imgs/propiedades/imageTesting/" + imagesDTO.getName();
		System.out.println("Upload Dir :" + uploadDir);
		Path uploadPath= Paths.get(uploadDir);
		
		
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println("file Path :" + filePath.toString());
            System.out.println("File Path absolute :" + filePath.toFile().getAbsolutePath());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
          
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
		
		ra.addFlashAttribute("message","La imagen se ha subido");
		
		
		return "redirect:/fileUpload";
				//new RedirectView("/fileUpload",true);
		
	}
}
