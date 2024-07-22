package readability.Strategy;

import readability.EvaluationResult;
import readability.Result;
import readability.TextStatistics;

public interface ReadabilityAlgorithm {
    Result evaluate(TextStatistics statistics);

    String getName();

    default EvaluationResult getResultByScore(int score) {
        if (score < 1 || score > 14) {
            throw new IllegalArgumentException("Score should be within 1-14");
        }
        return EvaluationResult.fromScore(score);
    }
}
