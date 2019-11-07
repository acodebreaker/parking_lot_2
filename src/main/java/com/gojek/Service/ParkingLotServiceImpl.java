package com.gojek.Service;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.ParkingLot;
import com.gojek.Model.ParkingSlot;
import com.gojek.Model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ParkingLotServiceImpl implements Service.ParkingLotService {

    ParkingLot parkingLot = new ParkingLot();

    private PriorityQueue<ParkingSlot> availableSlots;

    public PriorityQueue<ParkingSlot> getAvailableSlots() {
        return availableSlots;
    }


    public void createParkingLot(int totalSlots) {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        availableSlots = new PriorityQueue<ParkingSlot>(Comparator.comparingInt(ParkingSlot::getSlotNumber));
        for (int i = 0; i < totalSlots; i++) {
            ParkingSlot slot = new ParkingSlot(i+1);
            parkingSlots.add(slot);
            availableSlots.add(slot);
        }
        parkingLot.setParkingSlots(parkingSlots);
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
            return parkingLot.getParkingSlots();

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
