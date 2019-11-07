package com.gojek.Commands;

import Delegates.ParkingDelegate;

interface Command {
    void takeAction(String[] inputValues, ParkingDelegate parkingDelegate);
}
