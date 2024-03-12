public class StatistiqueModel {

    private Double mean;
    private Double variance;
    private int size;

    private Double timeTaken;

    public StatistiqueModel(Double mean, Double variance, int size, Double timeTaken) {
        this.mean = mean;
        this.variance = variance;
        this.size = size;
        this.timeTaken = timeTaken;
    }


    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "StatistiqueModel{" +
                "mean=" + mean +
                ", variance=" + variance +
                ", size=" + size +
                ", timeTaken=" + timeTaken +
                '}';
    }
}
