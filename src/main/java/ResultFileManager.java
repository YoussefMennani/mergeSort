import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultFileManager {

    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    public static void writeResultsToFile(
            String algorithm,
            String distribution,
            int dataSize,
            double mean,
            double variance,
            double timeTaken)
    {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);

        String fileName = String.format("csvFiles/results_datasize_%d_mean_%.2f_variance_%.2f_%s.csv", dataSize, mean, variance, timestamp);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write metadata to the file
            writer.write("Algorithm: " + algorithm);
            writer.newLine();
            writer.write("Distribution: " + distribution);
            writer.newLine();
            writer.write("Data Size: " + dataSize);
            writer.newLine();
            writer.write("Mean: " + mean);
            writer.newLine();
            writer.write("Variance: " + variance);
            writer.newLine();
            writer.write("Experiments Number: " + 0);
            writer.newLine();
            writer.write("Warm Up Rounds: " + 0);
            writer.newLine();
            writer.write("TimeTaken: " + timeTaken);
            writer.newLine();
            writer.write("Timestamp: " + timestamp);
            writer.newLine();
            writer.newLine(); // Add an empty line before the data

            // Write results to the file
     /*       groupedBySize.forEach((size, models) -> {

                try {
                    writer.write("Size: " + size);
                    writer.newLine();
                    writer.write("Min Time Taken: " + calculateMinTimeTaken(models));
                    writer.newLine();
                    writer.write("Avg Time Taken: " + calculateAvgTimeTaken(models));
                    writer.newLine();
                    writer.write("Max Time Taken: " + calculateMaxTimeTaken(models));
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                // Write individual StatistiqueModel details
                models.forEach(model -> {
                    try {
                        writer.write(model.toString());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                try {
                    writer.newLine(); // Add an empty line between groups
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });*/

            System.out.println("Results written to file: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculateMinTimeTaken(List<StatistiqueModel> models) {
        return models.stream()
                .mapToDouble(StatistiqueModel::getTimeTaken)
                .min()
                .orElse(Double.NaN);
    }

    private static double calculateAvgTimeTaken(List<StatistiqueModel> models) {
        return models.stream()
                .mapToDouble(StatistiqueModel::getTimeTaken)
                .average()
                .orElse(Double.NaN);
    }

    private static double calculateMaxTimeTaken(List<StatistiqueModel> models) {
        return models.stream()
                .mapToDouble(StatistiqueModel::getTimeTaken)
                .max()
                .orElse(Double.NaN);
    }

    public static void main(String[] args) {
        // Example usage
        //Map<Integer, List<StatistiqueModel>> groupedBySize = // Your grouped data here
/*        String algorithm = "ExampleAlgorithm";
        String distribution = "Normal";
        int dataSize = 1000;
        double mean = 5.0;
        double variance = 2.0;
        int experimentsNumber = 5;
        int warmUpRounds = 3;

        writeResultsToFile(groupedBySize, algorithm, distribution, dataSize, mean, variance, experimentsNumber, warmUpRounds);*/
    }
}
