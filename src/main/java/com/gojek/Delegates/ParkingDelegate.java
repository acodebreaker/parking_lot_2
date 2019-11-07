package Delegates;

public interface ParkingDelegate {
    void createParkingLot(int totalSlots);

    void parkVehicle(Vehicle vehicle);

    void leaveParkingSlot(int parkingSlotNumber);

    void getStatusOfParkingLot();

    void getSlotNumbersForCarsWithColor(String color);

    void getSlotNumberForRegistrationNumber(String registraionNumber);

    void getRegistrationNumbersForCarsWithColor(String color);
}
