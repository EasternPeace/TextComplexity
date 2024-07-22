package readability.Strategy;

import readability.EvaluationResult;
import readability.Result;
import readability.TextProcessor;
import readability.TextStatistics;

public class AriAlgorithm implements ReadabilityAlgorithm {
    TextProcessor processor = new TextProcessor();

    @Override
    public Result evaluate(TextStatistics statistics) {
        double rowScore = 4.71 * ((double) statistics.getCharacters() / statistics.getWords()) + 0.5 * ((double) statistics.getWords() / statistics.getSentences()) - 21.43;
        int targetAge = getResultByScore((int) Math.ceil(rowScore)).getTargetAge();
        String summary = String.format("%s: %.2f (about %d-year-olds)", getName(), rowScore, targetAge);
        return new Result(summary);
    }

    @Override
    public String getName() {
        return "Automated Readability Index";
    }

}

