package com.iao.fsr;

import org.Implementations.Sorting.Sort.Merge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Read normal distribution data from a text file
        List<Double> dataList = readDataFromFile("normal_distribution_data.txt");

        // Convert List to array
        Double[] data = dataList.toArray(new Double[0]);

        // Measure the time taken to sort the data
        long startTime = System.currentTimeMillis();
        Merge.sort(data);
        long endTime = System.currentTimeMillis();

        // Display the sorted data
        Merge.show(data);

        // Display the time taken to sort
        System.out.println("Time taken to sort: " + (endTime - startTime) + " milliseconds");
    }

    private static List<Double> readDataFromFile(String fileName) {
        List<Double> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    double value = Double.parseDouble(line);
                    dataList.add(value);
                } catch (NumberFormatException e) {
                    // Handle if the line doesn't contain a valid double
                    System.err.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
