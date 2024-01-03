package com.backend;

import com.backend.types.Letter;
import com.backend.types.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VowelCounter {
    public static int countVowels(Word word) {
        int count = 0;
        List<Letter> letters = word.getLetters();
        String vowels = "aeiouAEIOU";

        for (Letter letter : letters) {
            if (vowels.indexOf(letter.getLetter()) != -1) {
                count++;
            }
        }

        return count;
    }

    public static List<List<Word>> groupWordsByVowelCount(List<Word> words) {
        Map<Integer, List<Word>> groupedWords = new HashMap<>();

        for (Word word : words) {
            int vowelCount = countVowels(word);

            if (groupedWords.containsKey(vowelCount)) {
                groupedWords.get(vowelCount).add(word);
            } else {
                List<Word> newGroup = new ArrayList<>();
                newGroup.add(word);
                groupedWords.put(vowelCount, newGroup);
            }
        }

        return new ArrayList<>(groupedWords.values());
    }
}
