package com.gojek.Output;

import com.gojek.Commands.CommandTypes;
import com.gojek.Delegates.ParkingDelegateImpl;

public class OutputGenerator {

    static Delegates.ParkingDelegate parkingDelegate = new ParkingDelegateImpl();

    public static void generate(String inputCommand) {
        String[] inputs = inputCommand.split(" ");

        CommandTypes.valueOf(inputs[0].toUpperCase()).takeAction(inputs, parkingDelegate);


    }

}
