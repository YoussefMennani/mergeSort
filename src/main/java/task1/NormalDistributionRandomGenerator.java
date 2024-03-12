package task1;

import java.util.Random;

public class NormalDistributionRandomGenerator {

    public static void main(String[] args) {
        // Define parameters
        double[] means = {10.0, 20.0, 30.0}; // Example mean values
        double[] variances = {5.0, 10.0, 15.0}; // Example variance values
        int[] dataSizes = {100, 500, 1000}; // Example data sizes

        // Generate random numbers for each mean-variance combination and data size
        for (double mean : means) {
            for (double variance : variances) {
                for (int dataSize : dataSizes) {
                    double[] randomNumbers = generateRandomNumbers(mean, variance, dataSize);

                    // Print or process the generated random numbers as needed
                    System.out.println("Mean: " + mean + ", Variance: " + variance +
                            ", Data Size: " + dataSize + ", Random Numbers: " +
                            java.util.Arrays.toString(randomNumbers));
                }
            }
        }
    }

    // Function to generate random numbers with specified mean and variance for a normal distribution
    private static double[] generateRandomNumbers(double mean, double variance, int dataSize) {
        Random random = new Random();
        double[] randomNumbers = new double[dataSize];

        for (int i = 0; i < dataSize; i++) {
            // Generate random number with specified mean and variance for a normal distribution
            double randomNumber = mean + random.nextGaussian() * Math.sqrt(variance);
            randomNumbers[i] = randomNumber;
        }

        return randomNumbers;
    }
}
