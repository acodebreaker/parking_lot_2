package com.gojek.Command;

import com.gojek.Commands.CommandTypes;
import com.gojek.Delegates.ParkingDelegateImpl;
import com.gojek.Model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandTypesTest {

    @Mock
    ParkingDelegateImpl parkingDelegate;

    @Test
    public void shouldCallParkVehicleMethodForPARKCommand() {

        CommandTypes.PARK.takeAction(new String[]{"park", "MH-12-1234", "yellow"}, parkingDelegate);
        verify(parkingDelegate).parkVehicle(Matchers.refEq(new Vehicle("yellow", "MH-12-1234")));
    }

    @Test
    public void shouldCallCreateMethodForCREATECommand() {

        CommandTypes.CREATE_PARKING_LOT.takeAction(new String[]{"create", "5"}, parkingDelegate);
        verify(parkingDelegate).createParkingLot(5);
    }

    @Test
    public void shouldCallLeaveMethodForLEAVECommand() {
        CommandTypes.LEAVE.takeAction(new String[]{"leave", "5"}, parkingDelegate);
        verify(parkingDelegate).leaveParkingSlot(5);
    }

    @Test
    public void shouldCallStatusMethodForSTATUSCommand() {
        CommandTypes.STATUS.takeAction(new String[]{"leave", "2"}, parkingDelegate);
        verify(parkingDelegate).getStatusOfParkingLot();
    }

    @Test
    public void shouldCallSlotNumberWithColor() {
        CommandTypes.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR.takeAction(new String[]{"status_with_color", "red"}, parkingDelegate);
        verify(parkingDelegate).getSlotNumbersForCarsWithColor("red");
    }

    @Test
    public void shouldCallRegistrationNumberWithColor() {
        CommandTypes.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR.takeAction(new String[]{"registration_with_color", "red"}, parkingDelegate);
        verify(parkingDelegate).getRegistrationNumbersForCarsWithColor("red");
    }


    @Test
    public void shouldCallSlotNumberWithRegistrationNumber() {
        CommandTypes.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.takeAction(new String[]{"slot_number_for_registration", "MH 12 1234"}, parkingDelegate);
        verify(parkingDelegate).getSlotNumberForRegistrationNumber("MH 12 1234");
    }

}

