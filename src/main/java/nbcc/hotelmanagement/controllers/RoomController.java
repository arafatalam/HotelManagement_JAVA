package nbcc.hotelmanagement.controllers;

import nbcc.hotelmanagement.entities.Room;
import nbcc.hotelmanagement.entities.enums.BedType;
import nbcc.hotelmanagement.entities.enums.RoomStatus;
import nbcc.hotelmanagement.services.RoomService;
import nbcc.hotelmanagement.services.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomTypeService roomTypeService;

    public RoomController(RoomService roomService, RoomTypeService roomTypeService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public String getAllRooms(Model model) {

        model.addAttribute("pageTitle", "Rooms");
        model.addAttribute("rooms", roomService.getAllRoomsService());
        model.addAttribute("roomStatus", RoomStatus.values());

        return "rooms/list";

    }

    @GetMapping("/create")
    public String showCreateRoomForm(Model model) {

        Room room = new Room();

        model.addAttribute("pagetitle", "Create Room" );
        model.addAttribute("room", room);

        //Room Types
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());

        //Enums
        model.addAttribute("bedTypes", BedType.values());
        model.addAttribute("roomStatuses", RoomStatus.values());

        return "rooms/create";
    }

    @PostMapping("/create")
    public String createRoom(Model model,Room room) {

        roomService.addRoomService(room);

        return "redirect:/rooms";

    }

    @GetMapping("/edit/{id}")
    public String showEditRoomForm(Model model, @PathVariable Long id) {

        Optional<Room> roomOptional = roomService.getRoomService(id);

        if(roomOptional.isEmpty()) {
            return "redirect:/rooms";
        }

        Room room = roomOptional.get();

        model.addAttribute("pagetitle", "Edit Room" );
        model.addAttribute("room", room);

        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
        model.addAttribute("bedTypes", BedType.values());
        model.addAttribute("roomStatuses", RoomStatus.values());

        return "rooms/edit";

    }

    @PostMapping("/edit/{id}")
    public String editRoom(@PathVariable Long id, Room updatedRoom) {
        updatedRoom.setRoomId(id);

        roomService.updateRoomService(updatedRoom);
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomService(id);
        return "redirect:/rooms";
    }
}
