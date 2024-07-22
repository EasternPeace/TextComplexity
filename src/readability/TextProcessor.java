package readability;

public class TextProcessor {

    public TextStatistics getStatistics(String text) {
        int words = calculateWords(text);
        int characters = calculateCharacters(text);
        int sentences = calculateSentences(text);
        int syllables = calculateSyllables(text);
        int polysyllables = calculatePolysyllables(text);
        return new TextStatistics(words, characters, sentences, syllables, polysyllables);
    }

    private int calculateWords(String text) {
        return text.split("\\s+").length;
    }

    private int calculateCharacters(String text) {
        return text.replaceAll("\\s", "").length();
    }

    private int calculateSentences(String text) {
        String regex = "[!?.] ";
        return text.split(regex).length;
    }

    private int calculateSyllables(String text) {
        String[] words = text.split("[\\s!?.]+");
        int syllables = 0;
        for (String word : words) {
            syllables += calculateSyllablesInWord(word);
        }
        return syllables;
    }

    private int calculatePolysyllables(String text) {
        String[] words = text.split("[\\s!?.]+");
        int polysyllables = 0;
        for (String word : words) {
            int syllables = calculateSyllablesInWord(word);
            if (syllables > 2) {
                polysyllables ++;
            }
        }
        return polysyllables;
    }

    private static boolean isVowel(char letter) {
        return String.valueOf(letter).toLowerCase().matches("[aeiouy]");
    }

    private int calculateSyllablesInWord(String word) {
        boolean isPreviousCharVowel = false;
        int syllables = 0;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (isVowel(current)) {
                if (!isPreviousCharVowel) {
                    syllables++;
                    isPreviousCharVowel = true;
                }
            } else {
                isPreviousCharVowel = false;
            }
        }

        if (word.endsWith("e")) {
            syllables--;
        }
        return Math.max(syllables, 1);
    }
}
