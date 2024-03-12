import java.util.Arrays;
import java.util.Date;

public class SortResult {
    private double executionTime; // Time taken to sort
    private double theoreticalComplexity;
    private double realTimeComplexity;

    private String algorithm;

    private Double[] distribution;

    private Date timestamps;

    private double experiments_number;

    private int jvm_warm_up_rounds;

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public void setTheoreticalComplexity(double theoreticalComplexity) {
        this.theoreticalComplexity = theoreticalComplexity;
    }

    public void setRealTimeComplexity(double realTimeComplexity) {
        this.realTimeComplexity = realTimeComplexity;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Double[] getDistribution() {
        return distribution;
    }

    public void setDistribution(Double[] distribution) {
        this.distribution = distribution;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public double getExperiments_number() {
        return experiments_number;
    }

    public void setExperiments_number(double experiments_number) {
        this.experiments_number = experiments_number;
    }

    public int getJvm_warm_up_rounds() {
        return jvm_warm_up_rounds;
    }

    public void setJvm_warm_up_rounds(int jvm_warm_up_rounds) {
        this.jvm_warm_up_rounds = jvm_warm_up_rounds;
    }

    // Constructor


    public SortResult(
            double executionTime,
            double theoreticalComplexity,
            double realTimeComplexity,
            String algorithm,
            Double[] distribution,
            Date timestamps,
            double experiments_number,
            int jvm_warm_up_rounds) {

        this.executionTime = executionTime;
        this.theoreticalComplexity = theoreticalComplexity;
        this.realTimeComplexity = realTimeComplexity;
        this.algorithm = algorithm;
        this.distribution = distribution;
        this.timestamps = timestamps;
        this.experiments_number = experiments_number;
        this.jvm_warm_up_rounds = jvm_warm_up_rounds;
    }

    // Getters and setters
    public double getExecutionTime() {
        return executionTime;
    }

    public double getTheoreticalComplexity() {
        return theoreticalComplexity;
    }

    public double getRealTimeComplexity() {
        return realTimeComplexity;
    }

    // toString method for easy printing

    @Override
    public String toString() {
        return "SortResult{" +
                "executionTime=" + executionTime +
                ", theoreticalComplexity=" + theoreticalComplexity +
                ", realTimeComplexity=" + realTimeComplexity +
                ", algorithm='" + algorithm + '\'' +
                ", distribution=" + Arrays.toString(distribution) +
                ", timestamps=" + timestamps +
                ", experiments_number=" + experiments_number +
                ", jvm_warm_up_rounds=" + jvm_warm_up_rounds +
                '}';
    }
}
