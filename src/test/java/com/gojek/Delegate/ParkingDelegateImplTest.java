package com.gojek.Delegate;

import com.gojek.Delegates.ParkingDelegateImpl;
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


}
