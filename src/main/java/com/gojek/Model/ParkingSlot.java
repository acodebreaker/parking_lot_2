package com.gojek.Model;

public class ParkingSlot {
    int slotNumber;

    public void setVehicleParked(Vehicle vehicleParked) {
        this.vehicleParked = vehicleParked;
    }

    Vehicle vehicleParked;

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



}
