package ua.study.poject.cruise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LanguageController {

    @PostMapping("/changelanguage")
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String language = request.getParameter("language");
        Locale.setDefault(new Locale(language));
        response.addCookie(new Cookie("language", request.getParameter("language")));

        return "redirect:/startpage";
    }
}
