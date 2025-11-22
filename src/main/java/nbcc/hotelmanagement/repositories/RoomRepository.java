package nbcc.hotelmanagement.repositories;

import nbcc.hotelmanagement.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    default List<Room> getAllRooms() {
        return findAll();
    }

    default Room getRoom(Long id) {
        return findById(id).orElse(null);
    }

    default Room addRoom(Room room) {
        return save(room);
    }

    default Room updateRoom(Room room) {
        return save(room);
    }

    default void deleteRoom(Long id) {
        deleteById(id);
    }

}
