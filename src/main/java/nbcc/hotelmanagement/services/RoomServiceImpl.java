package nbcc.hotelmanagement.services;

import nbcc.hotelmanagement.entities.Room;
import nbcc.hotelmanagement.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRoomsService() {
        return roomRepository.getAllRooms();
    }

    @Override
    public Optional<Room> getRoomService(Long roomId) {
        //return roomRepository.findById(roomId);
        return Optional.ofNullable(roomRepository.getRoom(roomId));
    }

    @Override
    public Room addRoomService(Room room) {
        return roomRepository.addRoom(room);
    }

    @Override
    public Room updateRoomService(Room room) {
        return roomRepository.updateRoom(room);
    }

    @Override
    public void deleteRoomService(Long roomId) {
        roomRepository.deleteRoom(roomId);
    }
}
