/* Isaac St Hubert 04/05/2026 Module 2.2
   This program generates arrays of random integers and doubles and writes them to a data file*/


import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class WriteDataFile {

    /**
     * Main method that generates random data and writes it to a file.
     */
    public static void main(String[] args) {

        int[] intArray = generateRandomIntegers();
        double[] doubleArray = generateRandomDoubles();

        writeDataToFile(intArray, doubleArray);
    }

    /**
     * Generates an array containing five random integers.
     * @return an array of random integers
     */
    public static int[] generateRandomIntegers() {

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 100);
        }

        return numbers;
    }

    /**
     * Generates an array containing five random double values.
     * @return an array of random doubles
     */
    public static double[] generateRandomDoubles() {

        double[] numbers = new double[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random() * 100;
        }

        return numbers;
    }

    /**
     * Writes integer and double arrays to a data file.
     * If the file exists, the data will be appended.
     * @param intArray array of integers to write
     * @param doubleArray array of doubles to write
     */
    public static void writeDataToFile(int[] intArray, double[] doubleArray) {

        try (DataOutputStream output =
                     new DataOutputStream(new FileOutputStream("sthubert_datafile.dat", true))) {

            for (int num : intArray) {
                output.writeInt(num);
            }

            for (double num : doubleArray) {
                output.writeDouble(num);
            }

            System.out.println("Data successfully written.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
