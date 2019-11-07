package Service;

import java.util.List;

public interface ParkingLotService {

    void createParkingLot(int totalSlots);

    ParkingSlot parkVehicle(Vehicle vehicle) throws SlotNotAvailableException;

    void leaveParkingSlot(int parkingSlotNumber) throws NoSuchSlotException;

    List<ParkingSlot> getStatusOfParkingLot();

    List<Integer> getSlotNumbersForCarsWithColor(String color);

    int getSlotNumberForRegistrationNumber(String registrationNumber);

    List<String> getRegistrationNumbersForCarsWithColor(String color);
}
