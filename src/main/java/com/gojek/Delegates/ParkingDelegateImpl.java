package com.gojek.Delegates;

import com.gojek.Model.Vehicle;

public class ParkingDelegateImpl implements Delegates.ParkingDelegate {

    Service.ParkingLotService parkingLotService;

    @Override
    public void createParkingLot(int totalSlots) {
        parkingLotService.createParkingLot(totalSlots);
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {

    }

    @Override
    public void leaveParkingSlot(int parkingSlotNumber) {

    }

    @Override
    public void getStatusOfParkingLot() {

    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {

    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registraionNumber) {

    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) {

    }
}
