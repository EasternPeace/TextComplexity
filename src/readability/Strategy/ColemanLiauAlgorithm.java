package readability.Strategy;

import readability.Result;
import readability.TextStatistics;

public class ColemanLiauAlgorithm implements ReadabilityAlgorithm {
    double avgCharactersPerHundredWords;
    double avgSentencesPerHundredWords;

    @Override
    public Result evaluate(TextStatistics statistics) {
        prepareData(statistics);
        double rowScore = 0.0588 * avgCharactersPerHundredWords - 0.296 * avgSentencesPerHundredWords - 15.8;
        int targetAge = getResultByScore((int) Math.ceil(rowScore)).getTargetAge();
        String summary = String.format("%s: %.2f (about %d-year-olds)", getName(), rowScore, targetAge);
        return new Result(summary);
    }

    @Override
    public String getName() {
        return "Coleman–Liau index";
    }

    private void prepareData(TextStatistics statistics) {
        avgCharactersPerHundredWords = (double) (statistics.getCharacters() / statistics.getWords()) * 100;
        avgSentencesPerHundredWords = (double) (statistics.getSentences() / statistics.getWords()) * 100;
    }
}
