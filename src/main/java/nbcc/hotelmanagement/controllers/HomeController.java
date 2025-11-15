package nbcc.hotelmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController is like the reception desk of the hotel website.
 * It decides what happens when the user visits the root URL "/".
 */
@Controller
public class HomeController {

    /**
     * This method handles GET requests to "/".
     *
     * Metaphor:
     * - When a guest walks in the front door ("/"),
     *   we send them to the "home/index" view (home/index.html).
     */
    @GetMapping("/")
    public String index(Model model) {
        // Add a simple welcome message that Thymeleaf can show
        model.addAttribute("pageTitle", "Hotel Management - Home");
        model.addAttribute("welcomeMessage", "Welcome to NBCC Hotel Management");

        // Return the name of the Thymeleaf view: templates/home/index.html
        return "home/index";
    }
}
