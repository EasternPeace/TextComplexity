package readability.Strategy;

public class AlgorithmFactory {
    public static ReadabilityAlgorithm createStrategy(AlgorithmCode code) {
        switch (code) {
            case ARI:
                return new AriAlgorithm();
            case FK:
                return new FleschKincaidAlgorithm();
            case SMOG:
                return new SMOGAlgorithm();
            case CL:
                return new ColemanLiauAlgorithm();
            case ALL:
                return new AverageAlgorithm();
            default:
                throw new IllegalArgumentException("Unknown algorithm code: " + code);
        }
    }
}
