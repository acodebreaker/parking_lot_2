package com.gojek.Delegate;

import com.gojek.Delegates.ParkingDelegateImpl;
import com.gojek.Exceptions.NoSuchSlotException;
import com.gojek.Exceptions.SlotNotAvailableException;
import com.gojek.Model.Vehicle;
import com.gojek.Service.ParkingLotServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParkingDelegateImplTest {

    @InjectMocks
    ParkingDelegateImpl parkingDelegate ;

    @Mock
    ParkingLotServiceImpl parkingLotService;

    @Test
    public void shouldCreateParkingLot()
    {
        parkingDelegate.createParkingLot(5);
        verify(parkingLotService).createParkingLot(5);
    }

    @Test
    public void testParkVehicle() throws SlotNotAvailableException {
        Vehicle mockVehicle = new Vehicle("red","MH 12 RH 6501");
        parkingDelegate.parkVehicle(mockVehicle);
        verify(parkingLotService).parkVehicle(mockVehicle);

    }

    @Test
    public void testLeave() throws NoSuchSlotException {
        parkingDelegate.leaveParkingSlot(1);
        verify(parkingLotService).leaveParkingSlot(1);

    }

    @Test
    public void testGetStatusOfParkingLot() {
        parkingDelegate.getStatusOfParkingLot();
        verify(parkingLotService).getStatusOfParkingLot();

    }

    @Test
    public void testGetRegistrationNumbersForCarsWithColor() {
        parkingDelegate.getRegistrationNumbersForCarsWithColor("red");
        verify(parkingLotService).getRegistrationNumbersForCarsWithColor("red");
    }

    @Test
    public void testGetSlotNumbersForCarsWithColor() {
        parkingDelegate.getSlotNumbersForCarsWithColor("red");
        verify(parkingLotService).getSlotNumbersForCarsWithColor("red");

    }

    @Test
    public void testGetSlotNumberForRegistrationNumber() {
        parkingDelegate.getSlotNumberForRegistrationNumber("MH 12 4567");
        verify(parkingLotService).getSlotNumberForRegistrationNumber("MH 12 4567");

    }


}
