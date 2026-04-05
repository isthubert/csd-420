/* Isaac St Hubert 04/05/2026 Module 2.2
   This program reads and displays integers and doubles from a data file*/

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.EOFException;


public class ReadDataFile {

    /**
     * Main method that starts the program
     * and calls the method to read the data file.
     */
    public static void main(String[] args) {
        readDataFromFile();
    }

    /**
     * Reads integers and doubles from the data file and displays them
     */
    public static void readDataFromFile() {

        try (DataInputStream input =
                     new DataInputStream(new FileInputStream("sthubert_datafile.dat"))) {


            while (true) {

                // Attempt to read first integer before printing anything
                int firstInt = input.readInt();

                System.out.println("Integers:");
                System.out.println(firstInt);

                // Read five integers
                for (int i = 0; i < 5; i++) {
                    int value = input.readInt();
                    System.out.println(value);
                }

                System.out.println("\nDoubles:");

                // Read five doubles
                for (int i = 0; i < 5; i++) {
                    double value = input.readDouble();
                    System.out.println(value);
                }

                System.out.println("----------------------");
            }

        } catch (EOFException ex) {
            System.out.println("\nFinished reading file.");  

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}