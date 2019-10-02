package ua.study.poject.cruise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logoutGet(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/startpage";
    }
}
