package com.gojek.Service;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.ParkingSlot;
import com.gojek.Model.Vehicle;

import java.util.List;

public class ParkingLotServiceImpl implements Service.ParkingLotService {



    @Override
    public void createParkingLot(int totalSlots) {

    }

    @Override
    public ParkingSlot parkVehicle(Vehicle vehicle) throws SlotNotAvailableException {
        return null;
    }

    @Override
    public void leaveParkingSlot(int parkingSlotNumber) throws NoSuchSlotException {

    }

    @Override
    public List<ParkingSlot> getStatusOfParkingLot() {
        return null;
    }

    @Override
    public List<Integer> getSlotNumbersForCarsWithColor(String color) {
        return null;
    }

    @Override
    public int getSlotNumberForRegistrationNumber(String registrationNumber) {
        return 0;
    }

    @Override
    public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        return null;
    }

}
