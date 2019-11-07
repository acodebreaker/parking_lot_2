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
    },
    LEAVE {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            int slotNumber = Integer.parseInt(inputValues[1]);
            parkingDelegate.leaveParkingSlot(slotNumber);
        }
    },
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            parkingDelegate.getSlotNumbersForCarsWithColor(inputValues[1]);
        }
    },
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {

            parkingDelegate.getSlotNumberForRegistrationNumber(inputValues[1]);
        }
    },
    STATUS {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            parkingDelegate.getStatusOfParkingLot();
        }
    },
    EXIT {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            System.exit(0);
        }
    }
}



