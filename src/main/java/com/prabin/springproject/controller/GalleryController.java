package com.prabin.springproject.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GalleryController {
	
	@RequestMapping(value="/gallery")
	public String gallery(Model model){
		
		File  dir = new File("E:\\Spring\\springproject\\src\\main\\webapp\\resources\\imgs");
		 String[] nameList =dir.list();
		 
		 model.addAttribute("nameList", nameList);
		
		return "gallery";
	}

}
