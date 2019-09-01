package com.codecool.filepartreader;

import java.io.IOException;
import java.util.*;

class FileWordAnalyzer {

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader reader) {
        this.filePartReader = reader;
    }

    /** returns the words ordered by alphabetically as an ArrayList */
    List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> list = new ArrayList<>(new HashSet<>(getStringOfArrayFromText(filePartReader)));
        Collections.sort(list);
        return list;
    }

    /** returns the words which contains the subString */
    List<String> getWordsContainingSubstring(String substring) throws IOException {
        List<String> stringList = getStringOfArrayFromText(filePartReader);
        List<String> list = new ArrayList<>();
        for (String str : stringList) {
            if (str.toLowerCase().contains(substring.toLowerCase())) {
                list.add(str);
            }
        }
        return list;
    }


    /** returns the words from the String which are palindrome */
    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> stringList = getStringOfArrayFromText(filePartReader);
        List<String> list = new ArrayList<>();
        for (String str : stringList) {
            String reverseString = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reverseString += str.charAt(i);
            }
            if (str.equals(reverseString)) {
                list.add(str);
            }
        }
        return list;
    }

    public static List<String> getStringOfArrayFromText(FilePartReader reader) throws IOException{
        String string = reader.readLines();
        String[] stringList = string.split("\\s+");
        List<String> list = new ArrayList<>();
        for (String str : stringList) {
            str = str.toLowerCase();
            str = str.replace(',', ' ');
            str = str.replace('.', ' ');
            str = str.replace('?', ' ');
            str = str.trim();
            list.add(str);
        }
        return list;
    }
}
