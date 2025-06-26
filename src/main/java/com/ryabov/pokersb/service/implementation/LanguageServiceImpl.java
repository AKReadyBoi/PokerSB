package com.ryabov.pokersb.services.implementations;

import com.ryabov.pokersb.services.LanguageService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    @Override
    public void changeLanguage(String lang, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("currentLang", lang);
        response.addCookie(new Cookie("currentLang", lang));
    }

    @Override
    public String getLanguage(HttpServletRequest request) {
        return Arrays.stream(Optional.ofNullable(request.getCookies()).orElse(new Cookie[0]))
                .filter(cookie -> "currentLang".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst()
                .orElse("usa");
    }

}
