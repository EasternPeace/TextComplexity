package readability;

import readability.Strategy.AlgorithmCode;
import readability.Strategy.AlgorithmFactory;
import readability.Strategy.ReadabilityAlgorithm;

public class TextEvaluator {
    private ReadabilityAlgorithm strategy;
    private TextProcessor textProcessor;


    public TextEvaluator(ReadabilityAlgorithm strategy, TextProcessor textProcessor) {
        this.strategy = strategy;
        this.textProcessor = textProcessor;
    }

    public TextEvaluator(AlgorithmCode code, TextProcessor textProcessor) {
        strategy = AlgorithmFactory.createStrategy(code);
        this.textProcessor = textProcessor;
    }

    public Result evaluateText(String text) {
        return strategy.evaluate(textProcessor.getStatistics(text));
    }
}
