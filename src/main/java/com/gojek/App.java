package com.gojek;

import com.gojek.Output.OutputGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        if (args.length != 0) {
            readFromFile(args[0]);

        } else {
            readFromConsole();

        }
    }

        static void readFromFile(String filepath) throws FileNotFoundException, IOException {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(filepath));
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                throw new FileNotFoundException();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                OutputGenerator.generate(line);

            }

        }

    public static void readFromConsole(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            if( command==null ||command.isEmpty())
                return;
            OutputGenerator.generate(command);
        }
    }
}
