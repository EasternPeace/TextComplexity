package readability;

public class TextStatistics {
    private final int words;
    private final int characters;
    private final int sentences;
    private final int syllables;
    private final int polysyllables;


    public TextStatistics(int words, int characters, int sentences, int syllables, int solysyllables) {
        this.words = words;
        this.characters = characters;
        this.sentences = sentences;
        this.syllables = syllables;
        this.polysyllables = solysyllables;
    }

    public int getWords() {
        return words;
    }

    public int getCharacters() {
        return characters;
    }

    public int getSentences() {
        return sentences;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}
