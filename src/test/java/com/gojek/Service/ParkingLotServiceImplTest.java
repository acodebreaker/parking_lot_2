package com.gojek.Service;

import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotServiceImplTest {

    ParkingLotServiceImpl parkingLotService;

    Vehicle mockVehicle;
    String mockRegistrationNumber;
    String mockColor;


    @Before
    public void setUp() throws Exception {
        parkingLotService = new ParkingLotServiceImpl();
        parkingLotService.createParkingLot(5);
        mockRegistrationNumber="MH 12 RS 1234";
        mockColor="red";
        mockVehicle=new Vehicle(mockColor,mockRegistrationNumber);
    }


    @Test
    public void testCreateParkingLot() {

        Assert.assertEquals(5, parkingLotService.getAvailableSlots().size());
        Assert.assertEquals(5, parkingLotService.getStatusOfParkingLot().size());

    }

    @Test
    public void testParkVehicle() throws SlotNotAvailableException {
        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 1);
        parkingLotService.parkVehicle(mockVehicle);

        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 2);


    }

    @Test
    public void testLeaveSpot() throws SlotNotAvailableException, NoSuchSlotException {

        parkingLotService.parkVehicle(mockVehicle);
        parkingLotService.parkVehicle(mockVehicle);
        parkingLotService.leaveParkingSlot(2);
        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 2);
        parkingLotService.leaveParkingSlot(1);
        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 1);

    }

    @Test
    public void testGetSlotNumberByColor() throws SlotNotAvailableException {
        parkingLotService.parkVehicle(mockVehicle);
        parkingLotService.parkVehicle(mockVehicle);
        List<Integer> actualSlotNumbers = parkingLotService.getSlotNumbersForCarsWithColor("red");
        List<Integer> expectedSlotNumbers = new ArrayList<Integer>(Arrays.asList(1, 2));
        Assert.assertEquals(expectedSlotNumbers, actualSlotNumbers);
    }

    @Test
    public void testGetSlotNumberForRegistrationNumber() throws SlotNotAvailableException {
        parkingLotService.parkVehicle(mockVehicle);
        int slotNumber = parkingLotService.getSlotNumberForRegistrationNumber(mockRegistrationNumber);
        Assert.assertEquals(1, slotNumber);
    }

    @Test
    public void testGetRegistrationNumbersForCarsWithColor() throws SlotNotAvailableException {


    }






}
