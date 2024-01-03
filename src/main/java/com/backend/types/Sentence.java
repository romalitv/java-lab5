package com.backend.types;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> wordsList;

    public Sentence(StringBuffer sentence) {
        this.wordsList = new ArrayList<>();
        parseSentence(sentence);
    }

    private void parseSentence(StringBuffer sentence) {
        String cleanedSentence = Punctuation.removeSecondaryPunctuation(sentence.toString());

        String[] wordArray = cleanedSentence.split("\\s+");

        if (wordArray.length > 0) {
            for (String word : wordArray) {
                wordsList.add(new Word(new StringBuffer(word)));
            }
        }
    }

    public List<Word> getWordsList() {
        return wordsList;
    }
}