package nbcc.hotelmanagement.controllers;

import nbcc.hotelmanagement.entities.User;
import nbcc.hotelmanagement.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Login");

        return "auth/login";

    }

    @PostMapping("login")
    public String login(Model model, User user){

        if(loginService.login(user)){
            return "redirect:/rooms";
        }
        else {
            model.addAttribute("pageTitle", "Login");
            model.addAttribute("user", new User());
            model.addAttribute("errorMessage", "Invalid Username or Password");
            return "auth/login";
        }

    }

    @GetMapping("/logout")
    public String logout(){
        loginService.logout();
        return "redirect:/login";
    }


    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("pageTitle", "Register");
        model.addAttribute("user", new User());

        return "auth/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("user") User user){

        if(loginService.register(user)){
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", "User Name or Email already in use");
            return "auth/register";
        }
    }

}
