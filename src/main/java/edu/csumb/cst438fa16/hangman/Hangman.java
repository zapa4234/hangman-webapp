package edu.csumb.cst438fa16.hangman;

public class Hangman {
    private String word;

    static boolean isLowercaseLatin(String str) {
        for (char ch : str.toCharArray()) {
            if (ch < 'a' || 'z' < ch) {
                return false;
            }
        }
        return true;
    }

    public Hangman(String word) {
        if (!isLowercaseLatin(word)) {
            throw new IllegalArgumentException(
		"word must consist of lower case latin letters");
        }
        this.word = word;
    }

    /**
     * Returns a pattern with a dot per letter in the word to guess.
     */
    public String start() {
        return match("");
    }

    /**
     * Returns a pattern with the "guessed" positions in word filled out,
     * namely where the letter in that position is one of the letters in
     * guess, and the remaining positions in word are dots.
     */
    public String match(String guesses) {
        StringBuilder pattern = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guesses.indexOf(c) == -1) {
                pattern.append('.');
            } else {
                pattern.append(c);
            }
        }
        return pattern.toString();
    }
}
