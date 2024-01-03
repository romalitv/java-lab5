package com.backend.types;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters;

    public Word(StringBuffer word) {
        this.letters = new ArrayList<>();
        processWord(word);
    }

    private void processWord(StringBuffer word) {
        String processedWord = word.toString().toLowerCase();

        char[] charArray = processedWord.toCharArray();

        for (char character : charArray) {
            letters.add(new Letter(character));
        }
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public String getProcessedWord() {
        StringBuffer processedWord = new StringBuffer();
        for (Letter letter : letters) {
            processedWord.append(letter.getLetter());
        }
        return processedWord.toString();
    }
}