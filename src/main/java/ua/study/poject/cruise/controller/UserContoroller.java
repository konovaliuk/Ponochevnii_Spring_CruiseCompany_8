package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.study.poject.cruise.persistance.entity.Role;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.service.CruiseService;
import ua.study.poject.cruise.service.UserService;

@Controller
@SessionAttributes({"signinMessage", "registrMessage", "changeuserroleMessage", "editaccountMessage", "currentuser"})
public class UserContoroller {

    @Autowired
    UserService userService;

    @Autowired
    CruiseService cruiseService;


    @GetMapping("/signin")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/signin")
    public String loginPost(User registredUser, Model model) {
        registredUser = userService.findUserByLoginPassword(registredUser.getLogin(), registredUser.getPassword());
        if (registredUser == null) {
            model.addAttribute("signinMessage", "message.loginerror");
        }
        else {
            model.addAttribute("currentuser", registredUser);
            model.addAttribute("allCruises", cruiseService.viewAllCruises());
            return "redirect:/startpage";
        }

        return "redirect:/signin";
    }

    @GetMapping("/myaccount")
    public String myAccountGet(@ModelAttribute("currentuser") User currentuser) {

        switch (currentuser.getRole().getRole()) {
            case Role.ROLE_ADMIN:
                return "myaccountadmin";
            case Role.ROLE_MANAGER:
                return "myaccountmanager";
            case Role.ROLE_CUSTOMER:
                return "myaccountcustomer";
            default:
                return "redirect:/startpage";
        }
    }


    @GetMapping("/signup")
    public String SignUpGet() {
        return "registration";
    }

    @PostMapping("/signup")
    public String SignUpPost(User user, String password2, Model model) {
        if (!user.getPassword().equals(password2)) {
            model.addAttribute("registrMessage", "message.register.errorpass1and2");
            return "redirect:/signup";
        }
        model.addAttribute("registrMessage", userService.addNewUser(user));
        return "redirect:/signup";
    }


    @GetMapping("/changeuserrole")
    public String changeUserRoleGet(Model model) {
        model.addAttribute("allRoles", userService.findAllRoles());
        return "changeuserrole";
    }

    @PostMapping("/changeuserrole")
    public String changeUserRolePost(Model model, @RequestParam String login, @RequestParam String selectedrole) {
        model.addAttribute("changeuserroleMessage", userService.changeUserRole(login, selectedrole));
        return "redirect:/changeuserrole";
    }


    @GetMapping("/editaccount")
    public String editAccountGet() {
        return "editaccount";
    }

    @PostMapping("/editaccount")
    public String editAccountPost(@ModelAttribute("currentuser") User currentuser, User editedUser, String password2, Model model) {
        if (!editedUser.getPassword().equals(password2)) {
            model.addAttribute("editaccountMessage", "message.editaccount.errorpass1and2");
            return "redirect:/editaccount";
        }

        model.addAttribute("editaccountMessage", userService.editAccount(currentuser, editedUser));
        return "redirect:/editaccount";
    }
}
