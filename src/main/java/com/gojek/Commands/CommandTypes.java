package com.gojek.Commands;

import Delegates.ParkingDelegate;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;

public enum CommandTypes implements Command {



    PARK {
        @Override
        public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate) {
            parkingDelegate.parkVehicle(new Vehicle(inputValues[1],inputValues[2]));
        }
    }
}



