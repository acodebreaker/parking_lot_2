package com.gojek.Delegates;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.ParkingSlot;
import com.gojek.Model.Vehicle;
import com.gojek.Service.ParkingLotServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingDelegateImpl implements Delegates.ParkingDelegate {

    Service.ParkingLotService parkingLotService = new ParkingLotServiceImpl();

    @Override
    public void createParkingLot(int totalSlots) {
        parkingLotService.createParkingLot(totalSlots);
        System.out.println("Created a parking lot with " + totalSlots + " slots" );
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        try {
            ParkingSlot slot = parkingLotService.parkVehicle(vehicle);
            if (slot == null)
                return;
            System.out.println("Allocated slot number: " + slot.getSlotNumber());
        } catch (SlotNotAvailableException e) {
            System.out.println("Sorry, parking lot is full");
        }
    }

    @Override
    public void leaveParkingSlot(int parkingSlotNumber) {
        try {
            parkingLotService.leaveParkingSlot(parkingSlotNumber);
            System.out.println("Slot number " + parkingSlotNumber + " is free");
        } catch (NoSuchSlotException e) {
            System.out.println("Not found");
        }
    }

    @Override
    public void getStatusOfParkingLot() {
        parkingLotService.getStatusOfParkingLot();
    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {
        List<Integer> slotNumbers = parkingLotService.getSlotNumbersForCarsWithColor(color);

        System.out.println(slotNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registraionNumber) {
        parkingLotService.getSlotNumberForRegistrationNumber(registraionNumber);
    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) {
        List<String> registrationNumbers = parkingLotService.getRegistrationNumbersForCarsWithColor(color);
        System.out.println(registrationNumbers.stream().map(Object::toString).collect(Collectors.joining(",")).toString());
    }
}
