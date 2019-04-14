package com.phong.mvc.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phong.mvc.models.Language;
import com.phong.mvc.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
	// HOME PAGE THAT SHOWS ALL LANGUAGES
    @RequestMapping("/")
    public String index() {
    	return "index.jsp";
    }
    
	// HOME PAGE THAT SHOWS ALL LANGUAGES
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index.jsp";
    }
    
}
