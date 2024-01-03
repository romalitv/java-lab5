package com.backend;

import com.backend.types.Sentence;
import com.backend.types.Text;
import com.backend.types.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        StringBuffer inputText = new StringBuffer("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        System.out.println(inputText);

        Text text = new Text(inputText);

        List<Sentence> sentences = text.getSentences();

        List<Word> words = extractWords(sentences);

        List<List<Word>> groupedWords = VowelCounter.groupWordsByVowelCount(words);

        for (List<Word> group : groupedWords) {
            int vowelCount = VowelCounter.countVowels(group.getFirst());
            String wordList = group
                    .stream()
                    .map(Word::getProcessedWord)
                    .collect(Collectors.joining(", "));
            System.out.println("Vowel Count: " + vowelCount + ", Words: " + wordList);
        }
    }

    private static List<Word> extractWords(List<Sentence> sentences) {
        List<Word> words = new ArrayList<>();

        for (Sentence sentence : sentences) {
            List<Word> sentenceWords = sentence.getWordsList();
            words.addAll(sentenceWords);
        }

        return words;
    }
}