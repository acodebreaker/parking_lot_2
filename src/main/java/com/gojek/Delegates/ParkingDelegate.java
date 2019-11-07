package Delegates;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;

public interface ParkingDelegate {
    void createParkingLot(int totalSlots);

    void parkVehicle(Vehicle vehicle) throws SlotNotAvailableException;

    void leaveParkingSlot(int parkingSlotNumber) throws NoSuchSlotException;

    void getStatusOfParkingLot();

    void getSlotNumbersForCarsWithColor(String color);

    void getSlotNumberForRegistrationNumber(String registraionNumber);

    void getRegistrationNumbersForCarsWithColor(String color);
}
