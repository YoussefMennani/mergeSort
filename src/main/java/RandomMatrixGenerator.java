import java.util.*;

import mergeSort.MergeSort;
import org.apache.commons.math3.distribution.NormalDistribution;

//implement mergeSort


public class RandomMatrixGenerator {

    public static double timeTaken;
    public static double complexity;
    private static Map<String, SortResult> resultsMap = new HashMap<>();

    // Function to generate random data for a given mean and variance
    private static Double[] generateNormalData(int dataSize, double mean, double variance) {
        // Convert variance to standard deviation
        double standardDeviation = Math.sqrt(variance);

        NormalDistribution distribution = new NormalDistribution(mean, standardDeviation);
        Double[] data = new Double[dataSize];

        for (int i = 0; i < dataSize; i++) {
            data[i] = distribution.sample();
        }

        return data;
    }

    // Function to initialize and populate a matrix
    private static Double[][][] initializeAndPopulateMatrix(int dataSize, double[] means, double[] variances) {
        int numRows = means.length;
        int numCols = variances.length;

        Double[][][] matrix = new Double[numRows][numCols][];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // Generate random data for the given mean and variance
                Double[] data = generateNormalData(dataSize, means[i], variances[j]);
                // Store the data in the matrix
                matrix[i][j] = data;
            }
        }
        return matrix;
    }

    public static double mergeSort(Double[] a,double mean,double variance){

        double theoreticalComplexity =(a.length*(Math.log(a.length)/Math.log(2)));

        System.out.println(" _____________________________ Start ________________________________ ");
        System.out.println(" Data Size() : "+a.length);
        System.out.println(" Data Befor : "+ Arrays.toString(a));
        long startTime = System.nanoTime();
        //Merge Sort
        MergeSort.sort(a);
        long endTime = System.nanoTime();
        System.out.println(" After : "+ Arrays.toString(a));
        // Calculate and print the time taken to sort
        double elapsedTimeInSeconds = (endTime - startTime);
        System.out.println(" Time taken to sort: " +   elapsedTimeInSeconds );

        System.out.println(" theoretical Time  Complexity : "+theoreticalComplexity);

        System.out.println(" Réel Time  Complexity : "+ MergeSort.complexity);

        SortResult sortResult = new SortResult(
                elapsedTimeInSeconds,
                theoreticalComplexity,
                MergeSort.complexity,
                "Merge Sort",
                a,
                new Date(),
                0,
                0
        );

        // After sorting, store the result in the map
        String key = "Size:" + a.length + " Mean:" + mean + " Variance:" + variance;
        resultsMap.put(key, sortResult);
        System.out.println("_____________________________ Finish ________________________________");
        return elapsedTimeInSeconds;
    }



    public static void main(String[] args) {
        // Define means, variances, and data sizes
        double[] means = {10, 20};
        double[] variances = {2, 5};
        int[] dataSizes = { 500, 1000,5000};



        // Initialize matrices for each data size
        for (int dataSize : dataSizes) {
            Double[][][] matrix = initializeAndPopulateMatrix(dataSize, means, variances);

            // Display the generated matrix for the current data size
            for(int i = 0;i<means.length;i++){
                for (int j = 0;j<variances.length;j++){
                    System.out.println(" mean : "+means[i]+" varaince : "+variances[j]+"  size() :"+dataSize);
                    //show data
                    System.out.println(Arrays.toString(matrix[i][j]));
                    //taken time
                    Double takenTime = mergeSort(matrix[i][j],means[i],variances[j]);

                }
            }

        }

        for (String key : resultsMap.keySet()) {
            SortResult result = resultsMap.get(key);
            System.out.println("Key: " + key + ", Value: " + result);
        }


    }
}
