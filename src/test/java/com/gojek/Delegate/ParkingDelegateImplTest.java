package com.gojek.Delegate;

import com.gojek.Delegates.ParkingDelegateImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParkingDelegateImplTest {

    ParkingDelegateImpl parkingDelegate;

    Service.ParkingLotService parkingLotService;

    @Test
    void shouldCreateParkingLot()
    {
        parkingDelegate.createParkingLot(5);
        verify(parkingLotService).createParkingLot(5);
    }

}
