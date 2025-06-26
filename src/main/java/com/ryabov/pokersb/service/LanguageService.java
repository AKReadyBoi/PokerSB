package com.ryabov.pokersb.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface LanguageService {
    void changeLanguage(String lang, HttpServletRequest request, HttpServletResponse response, Model model);
    String getLanguage(HttpServletRequest request);
}
