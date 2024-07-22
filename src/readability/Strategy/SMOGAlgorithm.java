package readability.Strategy;

import readability.Result;
import readability.TextStatistics;

public class SMOGAlgorithm implements ReadabilityAlgorithm {
    @Override
    public Result evaluate(TextStatistics statistics) {
        double rowScore = 1.043 * Math.sqrt(statistics.getPolysyllables() * 30.0/statistics.getSentences()) + 3.1291;
        int targetAge = getResultByScore((int) Math.ceil(rowScore)).getTargetAge();
        String summary = String.format("%s: %.2f (about %d-year-olds)", getName(), rowScore, targetAge);
        return new Result(summary);
    }

    @Override
    public String getName() {
        return "Simple Measure of Gobbledygook";
    }
}
