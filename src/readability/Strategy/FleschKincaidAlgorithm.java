package readability.Strategy;

import readability.Result;
import readability.TextStatistics;

public class FleschKincaidAlgorithm implements ReadabilityAlgorithm{
    @Override
    public Result evaluate(TextStatistics statistics) {
        double rowScore = 0.39 * statistics.getWords() / statistics.getSentences() + 11.8 * statistics.getSyllables() / statistics.getWords() - 15.59;
        int targetAge = getResultByScore((int) Math.ceil(rowScore)).getTargetAge();
        String summary = String.format("%s: %.2f (about %d-year-olds)", getName(), rowScore, targetAge);
        return new Result(summary);
    }

    @Override
    public String  getName() {
        return "Flesch–Kincaid readability tests";
    }
}
