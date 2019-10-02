package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.study.poject.cruise.persistance.entity.Port;
import ua.study.poject.cruise.service.PortExcursionService;

@Controller
@SessionAttributes({"createnewportMessage", "viewportMessage", "allExcursions", "selectedPort"})
public class PortController {
    @Autowired
    PortExcursionService portExcursionService;

    @GetMapping("/createport")
    public String createPortGet() {
        return "createport";
    }

    @PostMapping("/createport")
    public String createPortGet(Port newPort, Model model) {
        model.addAttribute("createnewportMessage", portExcursionService.createPort(newPort));
        return "redirect:/createport";
    }


    @GetMapping("/viewport")
    public String viewPortGet(Model model, @RequestParam Long selectedPortId) {
        model.addAttribute("allExcursions", portExcursionService.ViewExcursionsInPortByPortId(selectedPortId));
        model.addAttribute("selectedPort", portExcursionService.getPortById(selectedPortId));
        return "viewport";
    }
}
