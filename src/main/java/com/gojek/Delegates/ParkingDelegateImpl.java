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

        List<ParkingSlot> slots = parkingLotService.getStatusOfParkingLot();

        printParkingStatus(slots);

    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {
        List<Integer> slotNumbers = parkingLotService.getSlotNumbersForCarsWithColor(color);

        System.out.println(slotNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registrationNumber) {
        int slotNumber = parkingLotService.getSlotNumberForRegistrationNumber(registrationNumber);
        if (slotNumber == -1)
            System.out.println("Not found");
        else
            System.out.println(slotNumber);
    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) {
        List<String> registrationNumbers = parkingLotService.getRegistrationNumbersForCarsWithColor(color);
        System.out.println(registrationNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")).toString());
    }

    void printParkingStatus(List<ParkingSlot> slots) {
        System.out.println("Slot No.  Registration No  Colour");
        for(ParkingSlot parkingSlot: slots) {
            if(parkingSlot.getVehicleParked()!=null){
                String column1 = String.valueOf(parkingSlot.getSlotNumber());
                String column2 = parkingSlot.getVehicleParked().getRegistrationNumber();
                String column3 = parkingSlot.getVehicleParked().getColor();

                int col1Length = 10;
                int col2Length = 17;

                System.out.print(column1);
                for (int i = 0; i < col1Length -column1.length(); i++)
                    System.out.print(" ");


                System.out.print(column2);
                for (int i = 0; i < col2Length -column2.length(); i++)
                    System.out.print(" ");

                System.out.print(column3);
                System.out.println();
            }
        }
    }
}
