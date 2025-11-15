package nbcc.hotelmanagement.repositories;

import nbcc.hotelmanagement.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * RoomTypeRepository:
 * Metaphor:
 * - This is the "database librarian" for RoomType.
 * - It knows how to fetch/save/delete RoomType records from the room_types table.
 * <p>
 * JpaRepository<RoomType, Long>:
 * - RoomType = which entity/table
 * - Long = type of the ID field
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {


    // JpaRepository already gives us:
    // - findAll()
    default List<RoomType> getAllRoomTypes() {
        return findAll();
    }

    // - findById()
    default RoomType getRoomTypeById(Long roomTypeId) {
        return findById(roomTypeId).orElse(null);
    }

    // - save()
    default RoomType saveRoomType(RoomType roomType) {
        return save(roomType);
    }

    default RoomType updateRoomType(RoomType roomType) {
        return save(roomType);
    }
    // - deleteById()
    default void deleteRoomType(Long roomTypeId) {
        deleteById(roomTypeId);
    }

    // etc.
}
