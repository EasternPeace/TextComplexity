package readability;

import readability.Strategy.AlgorithmCode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        StringBuilder builder = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                builder.append(fileScanner.nextLine());
            }
        }

        TextProcessor processor = new TextProcessor();
        TextStatistics statistics = processor.getStatistics(builder.toString());
        System.out.printf("Words: %d\n", statistics.getWords());
        System.out.printf("Sentences: %d\n", statistics.getSentences());
        System.out.printf("Characters: %d\n", statistics.getCharacters());
        System.out.printf("Syllables: %d\n", statistics.getSyllables());
        System.out.printf("Polysyllables: %d\n", statistics.getPolysyllables());
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        String usersChoice = new Scanner(System.in).nextLine().toUpperCase();
        AlgorithmCode code = AlgorithmCode.valueOf(usersChoice);
        TextEvaluator textEvaluator = new TextEvaluator(code, processor);
        Result result = textEvaluator.evaluateText(builder.toString());
        System.out.println(result.getSummary());
    }
}
