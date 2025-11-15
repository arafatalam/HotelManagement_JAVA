package nbcc.hotelmanagement.services;

import nbcc.hotelmanagement.entities.RoomType;

import java.util.List;
import java.util.Optional;

/**
 * RoomTypeService:
 * Metaphor:
 *  - This is the "hotel manager" specifically for room types.
 *  - Controllers (reception) talk to the manager, not directly to the database librarian.
 */
public interface RoomTypeService {


    List<RoomType> getAllRoomTypes();

    RoomType saveRoomType(RoomType roomType);
    RoomType updateRoomType(RoomType roomType);
    Optional<RoomType> getRoomTypeById(Long roomTypeId);
    void deleteRoomType(Long roomTypeId);
}
