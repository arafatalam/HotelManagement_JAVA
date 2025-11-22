package nbcc.hotelmanagement.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import nbcc.hotelmanagement.entities.enums.BedType;
import nbcc.hotelmanagement.entities.enums.RoomStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rooms")
public class Room {

    // =======================
    // ID & BASIC INFO
    // =======================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(unique = true)
    private String roomNumber;


    private int roomFloor;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    // =======================
    // PRICING & GUEST INFO
    // =======================

    private BigDecimal roomPricePerNight;
    private int roomCapacity;
    private int roomBedCount;

    @Enumerated(EnumType.STRING)
    private BedType roomBedType;

    // =======================
    // FEATURES
    // =======================

    @Column(name = "room_has_ac")
    private boolean roomHasAC;
    @Column(name = "room_has_wifi")
    private boolean roomHasWifi;
    @Column(name = "room_has_tv")
    private boolean roomHasTV;
    @Column(name = "room_smoking_allowed")
    private boolean roomSmokingAllowed;

    // =======================
    // STATUS
    // =======================
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    // =======================
    // OPERATIONAL DETAILS
    // =======================

    @Column(name = "room_last_cleaned_date")
    private LocalDate roomLastCleanedDate;
    @Column(name = "room_next_maintenance_date")
    private LocalDate roomNextMaintenanceDate;
    @Column(name = "room_notes")
    private String roomNotes;

    // =======================
    // CONSTRUCTORS
    // =======================

    public Room() {

    }

    public Room(String roomNumber,
                int roomFloor,
                RoomType roomType,
                BigDecimal roomPricePerNight,
                int roomCapacity,
                int roomBedCount,
                BedType roomBedType,
                boolean roomHasAC,
                boolean roomHasWifi,
                boolean roomHasTV,
                boolean roomSmokingAllowed,
                RoomStatus roomStatus,
                LocalDate roomLastCleanedDate,
                LocalDate roomNextMaintenanceDate,
                String roomNotes) {
        this.roomNumber = roomNumber;
        this.roomFloor = roomFloor;
        this.roomType = roomType;
        this.roomPricePerNight = roomPricePerNight;
        this.roomCapacity = roomCapacity;
        this.roomBedCount = roomBedCount;
        this.roomBedType = roomBedType;
        this.roomHasAC = roomHasAC;
        this.roomHasWifi = roomHasWifi;
        this.roomHasTV = roomHasTV;
        this.roomSmokingAllowed = roomSmokingAllowed;
        this.roomStatus = roomStatus;
        this.roomLastCleanedDate = roomLastCleanedDate;
        this.roomNextMaintenanceDate = roomNextMaintenanceDate;
        this.roomNotes = roomNotes;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public void setRoomPricePerNight(BigDecimal roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    public int getRoomBedCount() {
        return roomBedCount;
    }

    public void setRoomBedCount(int roomBedCount) {
        this.roomBedCount = roomBedCount;
    }

    public BedType getRoomBedType() {
        return roomBedType;
    }

    public void setRoomBedType(BedType roomBedType) {
        this.roomBedType = roomBedType;
    }

    public boolean isRoomHasAC() {
        return roomHasAC;
    }

    public void setRoomHasAC(boolean roomHasAC) {
        this.roomHasAC = roomHasAC;
    }

    public boolean isRoomHasWifi() {
        return roomHasWifi;
    }

    public void setRoomHasWifi(boolean roomHasWifi) {
        this.roomHasWifi = roomHasWifi;
    }

    public boolean isRoomHasTV() {
        return roomHasTV;
    }

    public void setRoomHasTV(boolean roomHasTV) {
        this.roomHasTV = roomHasTV;
    }

    public boolean isRoomSmokingAllowed() {
        return roomSmokingAllowed;
    }

    public void setRoomSmokingAllowed(boolean roomSmokingAllowed) {
        this.roomSmokingAllowed = roomSmokingAllowed;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public LocalDate getRoomLastCleanedDate() {
        return roomLastCleanedDate;
    }

    public void setRoomLastCleanedDate(LocalDate roomLastCleanedDate) {
        this.roomLastCleanedDate = roomLastCleanedDate;
    }

    public LocalDate getRoomNextMaintenanceDate() {
        return roomNextMaintenanceDate;
    }

    public void setRoomNextMaintenanceDate(LocalDate roomNextMaintenanceDate) {
        this.roomNextMaintenanceDate = roomNextMaintenanceDate;
    }

    public String getRoomNotes() {
        return roomNotes;
    }

    public void setRoomNotes(String roomNotes) {
        this.roomNotes = roomNotes;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomFloor=" + roomFloor +
                ", roomType=" + roomType +
                ", roomPricePerNight=" + roomPricePerNight +
                ", roomCapacity=" + roomCapacity +
                ", roomBedCount=" + roomBedCount +
                ", roomBedType=" + roomBedType +
                ", roomHasAC=" + roomHasAC +
                ", roomHasWifi=" + roomHasWifi +
                ", roomHasTV=" + roomHasTV +
                ", roomSmokingAllowed=" + roomSmokingAllowed +
                ", roomStatus=" + roomStatus +
                ", roomLastCleanedDate=" + roomLastCleanedDate +
                ", roomNextMaintenanceDate=" + roomNextMaintenanceDate +
                ", roomNotes='" + roomNotes + '\'' +
                '}';
    }
}
