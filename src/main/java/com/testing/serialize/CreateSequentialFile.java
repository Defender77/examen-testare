package com.testing.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CreateSequentialFile {
    private static ObjectOutputStream output;

    public static void main(String[] args) {
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients2.ser")));

        } catch (
                IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    public static void addRecords() {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n?", "Enter account number, first name, last name and balance", "Enter end-of-file indicator to end input");
        while (input.hasNext()) {
            try {
                Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
                output.writeObject(record);
            } catch (IOException ioException) {
                System.err.println("Error writing file. Terminating");
                break;
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input");
                input.nextLine();
            }
            System.out.println("?");
        }
    }

    public static void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
        }
    }
}
