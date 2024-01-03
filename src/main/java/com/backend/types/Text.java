package com.backend.types;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text(StringBuffer inputBuffer) {
        this.sentences = new ArrayList<>();
        parseText(inputBuffer);
    }

    private void parseText(StringBuffer inputBuffer) {

        String cleanedText = inputBuffer.toString().replaceAll("\\s+", " ");

        String[] sentenceArray = cleanedText.split("[.!?]");

        for (String sentence : sentenceArray) {
            sentences.add(new Sentence(new StringBuffer(sentence.trim())));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
