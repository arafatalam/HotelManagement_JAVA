package nbcc.hotelmanagement.services;

import nbcc.hotelmanagement.entities.RoomType;
import nbcc.hotelmanagement.repositories.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * RoomTypeServiceImpl:
 * - Actual implementation of RoomTypeService.
 * - Talks to the RoomTypeRepository (DB librarian).
 */
@Service // Tells Spring: "Create an object (bean) of this class and manage it."
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    /**
     * Constructor injection:
     * Spring will automatically pass an instance of RoomTypeRepository here.
     */
    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        // Ask the repository: "Give me all the room types."
        return roomTypeRepository.getAllRoomTypes();
    }

    @Override
    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.saveRoomType(roomType);
    }

    @Override
    public RoomType updateRoomType(RoomType roomType) {
        return roomTypeRepository.updateRoomType(roomType);
    }

    @Override
    public Optional<RoomType> getRoomTypeById(Long roomTypeId) {
        return roomTypeRepository.findById(roomTypeId);

    }

    @Override
    public void deleteRoomType(Long roomTypeId) {

        roomTypeRepository.deleteRoomType(roomTypeId);

    }
}
