package Delegates;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;

public interface ParkingDelegate {
    void createParkingLot(int totalSlots);

    void parkVehicle(Vehicle vehicle);

    void leaveParkingSlot(int parkingSlotNumber);

    void getStatusOfParkingLot();

    void getSlotNumbersForCarsWithColor(String color);

    void getSlotNumberForRegistrationNumber(String registrationNumber);

    void getRegistrationNumbersForCarsWithColor(String color);
}
