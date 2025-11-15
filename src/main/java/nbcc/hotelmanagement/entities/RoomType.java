package nbcc.hotelmanagement.entities;

import jakarta.persistence.*;

/**
 * RoomType entity:
 * - Think of this as the "blueprint" for the room_types table in the database.
 */
@Entity                     // Tells JPA: "This class maps to a table in the DB"
@Table(name = "room_types") // Table name in MySQL will be room_types
public class RoomType {

    @Id // This field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Database will auto-generate the id (1, 2, 3, ...)
    private Long roomTypeId;

    @Column(nullable = false, length = 100)
    // Cannot be null, max length 100 characters
    private String roomTypeName;

    @Column(length = 500)
    // Optional text explaining the room type
    private String roomTypeDescription;

    // ===== Constructors =====

    /**
     * Empty constructor is required by JPA.
     * Metaphor: a "default blank form" that JPA can fill in.
     */
    public RoomType() {
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    /**
     * Convenience constructor we can use in code.
     */
    public RoomType(String roomTypeName, String roomTypeDescription) {
        this.roomTypeName = roomTypeName;
        this.roomTypeDescription = roomTypeDescription;
    }

    // ===== Getters and setters =====

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    // No setId() usually needed – DB controls the ID, but we could add one if needed.

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String name) {
        this.roomTypeName = name;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public void setRoomTypeDescription(String description) {
        this.roomTypeDescription = description;
    }

    // ===== toString (useful for logging / debugging) =====

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", roomTypeDescription='" + roomTypeDescription + '\'' +
                '}';
    }
}
