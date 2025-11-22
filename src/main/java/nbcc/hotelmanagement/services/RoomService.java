package nbcc.hotelmanagement.services;

import nbcc.hotelmanagement.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRoomsService();
    Optional<Room> getRoomService(Long roomId);
    Room addRoomService(Room room);
    Room updateRoomService(Room room);
    void deleteRoomService(Long roomId);

}
