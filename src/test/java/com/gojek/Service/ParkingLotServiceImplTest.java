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
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotServiceImplTest {

    ParkingLotServiceImpl parkingLotService;

    @Before
    public void setUp() throws Exception {
        parkingLotService = new ParkingLotServiceImpl();
        parkingLotService.createParkingLot(5);
    }


    @Test
    public void testCreateParkingLot() {

        Assert.assertEquals(5, parkingLotService.getAvailableSlots().size());
        Assert.assertEquals(5, parkingLotService.getStatusOfParkingLot().size());

    }

    @Test
    public void testParkVehicle() throws SlotNotAvailableException {
        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 1);
        Vehicle mockVehicle= new Vehicle("red","MH 12 RS 1234");
        parkingLotService.parkVehicle(mockVehicle);

        Assert.assertEquals(parkingLotService.getAvailableSlots().peek().getSlotNumber(), 2);


    }

    @Test
    public void testLeaveSpot() throws SlotNotAvailableException, NoSuchSlotException {



    }

    @Test
    public void testGetSlotNumberByColor() throws SlotNotAvailableException {


    }

    @Test
    public void testGetSlotNumberForRegistrationNumber() throws SlotNotAvailableException {


    }

    @Test
    public void testGetRegistrationNumbersForCarsWithColor() throws SlotNotAvailableException {


    }






}
