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
    public void testGenerateCreateParkingLot() {
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
        OutputGenerator.generate("leave 2");

        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 6 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Slot number 1 is free");
        Assert.assertEquals(expected[3],"Not found");
    }

    @Test
    public void testGenerateWhenSlotNumbersByColor() {
        OutputGenerator.generate("create_parking_lot 6");
        OutputGenerator.generate("park KA-01-HH-1234 White");
        OutputGenerator.generate("park KA-01-HH-3678 White");
        OutputGenerator.generate("slot_numbers_for_cars_with_colour White");
        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 6 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Allocated slot number: 2");
        Assert.assertEquals(expected[3],"1, 2");
    }

    @Test
    public void testGenerateWhenSlotNumbersByRegNo() {
        OutputGenerator.generate("create_parking_lot 6");
        OutputGenerator.generate("park KA-01-HH-1234 White");
        OutputGenerator.generate("park KA-01-HH-3678 White");
        OutputGenerator.generate("slot_number_for_registration_number KA-01-HH-3678");
        OutputGenerator.generate("slot_number_for_registration_number KA-01-HH-5678");
        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 6 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Allocated slot number: 2");
        Assert.assertEquals(expected[3],"2");
        Assert.assertEquals(expected[4],"Not found");
    }

    @Test
    public void testGenerateWhenParking() {
        OutputGenerator.generate("create_parking_lot 2");
        OutputGenerator.generate("park KA-01-HH-1234 White");
        OutputGenerator.generate("park KA-01-HH-9876 White");
        OutputGenerator.generate("park KA-01-HH-9861 Red");



        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 2 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Allocated slot number: 2");
        Assert.assertEquals(expected[3],"Sorry, parking lot is full");

    }

    @Test
    public void testGenerateWhenGetStatus() {
        OutputGenerator.generate("create_parking_lot 3");
        OutputGenerator.generate("park KA-01-HH-1234 White");
        OutputGenerator.generate("park KA-01-HH-9876 White");
        OutputGenerator.generate("status");

        String []expected= outContent.toString().split("\n");
        Assert.assertEquals(expected[0], "Created a parking lot with 3 slots");
        Assert.assertEquals(expected[1],"Allocated slot number: 1");
        Assert.assertEquals(expected[2],"Allocated slot number: 2");
        Assert.assertEquals(expected[3], "Slot No.  Registration No  Colour");
        Assert.assertEquals(expected[4],"1         KA-01-HH-1234    White");

    }

}
