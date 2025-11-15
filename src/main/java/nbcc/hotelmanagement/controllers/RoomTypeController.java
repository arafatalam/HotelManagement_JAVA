package nbcc.hotelmanagement.controllers;

import nbcc.hotelmanagement.entities.RoomType;
import nbcc.hotelmanagement.services.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * RoomTypeController:
 * - Handles URLs related to room types.
 * - Metaphor: receptionist who answers "room type" questions from the browser.
 */
@Controller
@RequestMapping("/roomtypes") // All routes in this controller start with /roomtypes
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    /**
     * Spring gives us an instance of RoomTypeServiceImpl here.
     */
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }


    @GetMapping
    public String listRoomTypes(Model model) {

        // Page title for <title> tag in the browser
        model.addAttribute("pageTitle", "Room Types");

        // Ask the service for all room types and put them into the model
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());

        // Return templates/roomtypes/list.html
        return "roomtypes/list";
    }


    @GetMapping("/create")
    public String showCreateRoomTypeForm(Model model) {
        model.addAttribute("pageTitle", "Create Room Type");

        // Create an empty RoomType object to bind the form fields to
        RoomType roomType = new RoomType();
        model.addAttribute("roomType", roomType);

        // Show templates/roomtypes/create.html
        return "roomtypes/create";
    }


    @PostMapping("/create")
    public String createRoomType(Model model, RoomType roomType) {
        // Save the new room type using the service
        roomTypeService.saveRoomType(roomType);

        // After saving, redirect to the list page (avoid resubmission on refresh)
        return "redirect:/roomtypes";

    }

    @GetMapping("/edit/{id}")
    public String showEditRoomTypeForm(Model model, @PathVariable("id") Long id) {

        Optional<RoomType> roomTypeOptional = roomTypeService.getRoomTypeById(id);

        if (roomTypeOptional.isPresent()) {
            model.addAttribute("roomType", roomTypeOptional.get());
        }

        return "roomtypes/edit";
    }

    @PostMapping("/edit")
    public String updateRoomType(Model model, RoomType roomType) {
//        RoomType roomType = roomTypeService.getRoomTypeById(id);
        roomTypeService.updateRoomType(roomType);
        return "redirect:/roomtypes";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoomType(@PathVariable("id") Long id) {
        roomTypeService.deleteRoomType(id);
        return "redirect:/roomtypes";
    }
}
