package com.prabin.springproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload")
	public String upload(){
		
		return "upload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model) throws IOException{
		
		 if(!file.isEmpty()){
			// file.getName().split("\\.")[1];
			 FileOutputStream out = new FileOutputStream("E:\\Spring\\springproject\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
			 out.write(file.getBytes());
			 out.close();
			 
			 model.addAttribute("msg", "upload success");
			 return "upload";
		 }
		
		 model.addAttribute("msg", "upload failed");
		return "upload";
	}
	

}
