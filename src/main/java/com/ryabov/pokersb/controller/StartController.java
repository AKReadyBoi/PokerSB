package com.ryabov.pokersb.controller;

import com.ryabov.pokersb.service.LanguageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StartPageController {
    private final LanguageService languageService;
    public StartPageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, HttpServletRequest request, HttpServletResponse response, Model model) {
        languageService.changeLanguage(lang, request, response, model);
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/");
    }

    @GetMapping
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("currentLang", languageService.getLanguage(request));
        return "index";
    }
}
