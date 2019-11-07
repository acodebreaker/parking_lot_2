package com.gojek.Commands;

import Delegates.ParkingDelegate;

interface Command {
    public void takeAction(String[] inputValues, ParkingDelegate parkingDelegate);
}
