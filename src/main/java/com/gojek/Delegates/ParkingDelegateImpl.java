package com.gojek.Delegates;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;

public class ParkingDelegateImpl implements Delegates.ParkingDelegate {

    Service.ParkingLotService parkingLotService;

    @Override
    public void createParkingLot(int totalSlots) {
        parkingLotService.createParkingLot(totalSlots);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) throws SlotNotAvailableException {
        parkingLotService.parkVehicle(vehicle);
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
