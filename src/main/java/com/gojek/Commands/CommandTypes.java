package com.gojek.Commands;

import Delegates.ParkingDelegate;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;

public enum CommandTypes implements Command {



    PARK {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            parkingDelegate.parkVehicle(new Vehicle(inputValues[2],inputValues[1]));
        }
    },
    CREATE_PARKING_LOT {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            if (inputValues.length > 1) {
                int numberOfParkingSlots = Integer.parseInt(inputValues[1]);
                parkingDelegate.createParkingLot(numberOfParkingSlots);
            }
        }
    },
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            parkingDelegate.getRegistrationNumbersForCarsWithColor(inputValues[1]);
        }
    }
}



