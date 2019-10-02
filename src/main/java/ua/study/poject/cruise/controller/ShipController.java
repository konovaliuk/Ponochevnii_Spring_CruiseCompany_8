package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.service.ShipService;

@Controller
@SessionAttributes("createshipMessage")
public class ShipController {
    @Autowired
    ShipService shipService;

    @GetMapping("/createship")
    public String createShip() {
        return "createship";
    }

    @PostMapping("/createship")
    public String createShip(Ship newShip, Model model) {
        model.addAttribute("createshipMessage", shipService.createShip(newShip));
        return "redirect:/createship";
    }

}
