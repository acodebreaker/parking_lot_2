package com.gojek.Output;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputGeneratorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testGenerate() {
        OutputGenerator.generate("create_parking_lot 6");
        Assert.assertEquals(outContent.toString(), "Created a parking lot with 6 slots\n");
    }

    @Test
    public void testGenerateWhenSearchRegNoByColor() {
        OutputGenerator.generate("create_parking_lot 6");
        OutputGenerator.generate("park KA-01-HH-1234 White");

        OutputGenerator.generate("registration_numbers_for_cars_with_colour White");

        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 6 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"KA-01-HH-1234");
    }

    @Test
    public void testGenerateWhenLeaveParking() {
        OutputGenerator.generate("create_parking_lot 6");
        OutputGenerator.generate("park KA-01-HH-1234 White");
        OutputGenerator.generate("leave 1");
        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 6 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Slot number 1 is free");
    }


}
