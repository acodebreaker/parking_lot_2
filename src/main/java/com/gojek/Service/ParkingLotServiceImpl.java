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
        if (availableSlots.isEmpty()) {
            throw new SlotNotAvailableException("slots are not available");
        }
        ParkingSlot slot = availableSlots.poll();
        slot.setVehicleParked(vehicle);
        parkingLot.getParkingSlots().get(slot.getSlotNumber() - 1).setVehicleParked(vehicle);
        availableSlots.remove(vehicle);
        return slot;
    }

    @Override
    public void leaveParkingSlot(int parkingSlotNumber) throws NoSuchSlotException {
        try {
            parkingLot.getParkingSlots().get(parkingSlotNumber - 1).setVehicleParked(null);
            availableSlots.add(parkingLot.getParkingSlots().get(parkingSlotNumber - 1));
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchSlotException("There is no such parking lot with slot number" + parkingSlotNumber);

        }
    }

    @Override
    public List<ParkingSlot> getStatusOfParkingLot() {
            return parkingLot.getParkingSlots();

    }

    @Override
    public List<Integer> getSlotNumbersForCarsWithColor(String color) {
        List<ParkingSlot> slots = parkingLot.getParkingSlots();
        List<Integer> cars = new ArrayList<>();
        for (int i = 0; i < slots.size(); i++) {
            ParkingSlot parkingSlot = slots.get(i);
            Vehicle vehicle = parkingSlot.getVehicleParked();
            if (vehicle != null && vehicle.getColor().equals(color)) {
                cars.add(i + 1);
            }

        }
        return cars;
    }

    @Override
    public int getSlotNumberForRegistrationNumber(String registrationNumber) {
        List<ParkingSlot> slots = parkingLot.getParkingSlots();

        for (ParkingSlot slot : slots) {
            if(slot.getVehicleParked()==null)
                continue;
            if (slot.getVehicleParked().getRegistrationNumber().equals(registrationNumber))
                return slot.getSlotNumber();

        }
        return -1;
    }

    @Override
    public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        List<ParkingSlot> slots = parkingLot.getParkingSlots();
        List<String> registrationNumbers = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.getVehicleParked() == null)
                continue;
            if (slot.getVehicleParked().getColor().equals(color))
                registrationNumbers.add(slot.getVehicleParked().getRegistrationNumber());

        }
        if (registrationNumbers.size() == 0)
            return null;
        else
            return registrationNumbers;

    }

}
