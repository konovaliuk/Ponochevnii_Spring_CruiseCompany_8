package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.entity.Port;
import ua.study.poject.cruise.service.PortExcursionService;

@Controller
@SessionAttributes({"createexcursionMessage", "excursion"})
public class ExcursionController {
    @Autowired
    PortExcursionService portExcursionService;


    @GetMapping("/createexcursion")
    public String createExcursionGet(Model model) {
        model.addAttribute("allPorts", portExcursionService.getAllPorts());
        return "createexcursion";
    }

    @PostMapping("/createexcursion")
    public String createExcursionPost(Excursion newExcursion, Port port, Model model) {
        newExcursion.setPort(port);
        model.addAttribute("createexcursionMessage", portExcursionService.createExcursion(newExcursion));
        return "redirect:/createexcursion";
    }

    @GetMapping("/viewexcursion")
    public String viewExcursionGet(Model model, @RequestParam Long viewExcursionId) {
        model.addAttribute("excursion", portExcursionService.ViewExcursionsInPortById(viewExcursionId));
        return "viewexcursion";
    }

}
