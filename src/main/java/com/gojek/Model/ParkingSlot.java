package com.gojek.Model;

public class ParkingSlot {
    int slotNumber;

    public ParkingSlot(int slotNumber)
    {
        this.slotNumber=slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }

    Vehicle vehicleParked;

}
