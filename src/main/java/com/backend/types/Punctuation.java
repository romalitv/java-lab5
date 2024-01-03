package com.backend.types;

public class Punctuation {

    private static final String PUNCTUATION = ";/?,:";

    public static String removeSecondaryPunctuation(String input) {
        return input.replaceAll("[" + PUNCTUATION + "]", "");
    }
}
