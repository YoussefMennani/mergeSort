package com.iao.fsr;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NormalDistributionGenerator {

    public static void main(String[] args) {
        // Parameters for the normal distribution
        double mean = 5.0;       // Change this to your desired mean
        double standardDeviation = 2.0;  // Change this to your desired standard deviation
        int dataSize = 10000;     // Change this to the desired number of data points

        // Generate normal distribution
        double[] data = generateNormalDistribution(mean, standardDeviation, dataSize);

        // Save data to a text file
        saveDataToFile(data, "normal_distribution_data.txt");

        System.out.println("Normal distribution data saved to normal_distribution_data.txt");
    }

    private static double[] generateNormalDistribution(double mean, double stdDev, int size) {
        NormalDistribution normalDistribution = new NormalDistribution(mean, stdDev);
        double[] data = new double[size];

        for (int i = 0; i < size; i++) {
            data[i] = normalDistribution.sample();
        }

        return data;
    }

    private static void saveDataToFile(double[] data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double value : data) {
                writer.write(String.valueOf(value));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
