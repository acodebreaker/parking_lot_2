package Service;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.ParkingSlot;
import com.gojek.Model.Vehicle;

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
