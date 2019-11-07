package com.gojek.Delegates;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.ParkingSlot;
import com.gojek.Model.Vehicle;

public class ParkingDelegateImpl implements Delegates.ParkingDelegate {

    Service.ParkingLotService parkingLotService;

    @Override
    public void createParkingLot(int totalSlots) {
        parkingLotService.createParkingLot(totalSlots);
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
    public void leaveParkingSlot(int parkingSlotNumber) throws NoSuchSlotException {
        parkingLotService.leaveParkingSlot(parkingSlotNumber);
    }

    @Override
    public void getStatusOfParkingLot() {
        parkingLotService.getStatusOfParkingLot();
    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {
        parkingLotService.getSlotNumbersForCarsWithColor(color);
    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registraionNumber) {
        parkingLotService.getSlotNumberForRegistrationNumber(registraionNumber);
    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) {
        parkingLotService.getRegistrationNumbersForCarsWithColor(color);
    }
}
