package readability.Strategy;

import readability.Result;
import readability.TextStatistics;

import java.util.ArrayList;

public class AverageAlgorithm implements ReadabilityAlgorithm {
    ArrayList<ReadabilityAlgorithm> algorithms = new ArrayList<>();

    public AverageAlgorithm() {
        algorithms.add(new AriAlgorithm());
        algorithms.add(new FleschKincaidAlgorithm());
        algorithms.add(new SMOGAlgorithm());
        algorithms.add(new ColemanLiauAlgorithm());
    }

    @Override
    public Result evaluate(TextStatistics statistics) {
        StringBuilder builder = new StringBuilder();
        for (ReadabilityAlgorithm algorithm : algorithms) {
            builder.append(algorithm.evaluate(statistics).getSummary());
            builder.append("\n");
        }

        return new Result(builder.toString());
    }

    @Override
    public String getName() {
        return "all based";
    }
}