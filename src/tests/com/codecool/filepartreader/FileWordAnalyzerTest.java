package com.codecool.filepartreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileWordAnalyzerTest {

    FilePartReader callTheFilepartReaderClass() {
        FilePartReader reader = new FilePartReader();
        reader.setup("/home/zsana/Codecool/OOP/fifthSIWeek/filepartreader-testing-with-junit-ezsana/src/main/resources/stabat_mater_short_version_for_tests.txt",1,2);
        return reader;
    }

    @Test
    void Should_PutWordsInAlphabeticalOrder() throws IOException {
        FilePartReader reader = callTheFilepartReaderClass();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> wordsInOrder = new ArrayList<>();
        wordsInOrder.add("condolere");
        wordsInOrder.add("crucifixo");
        wordsInOrder.add("fac");
        wordsInOrder.add("flere");
        wordsInOrder.add("me");
        wordsInOrder.add("pie");
        wordsInOrder.add("tecum");
        Assertions.assertEquals(wordsInOrder, analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void Should_Get_WordsContainingSubstring() throws IOException{
        FilePartReader reader = callTheFilepartReaderClass();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        String substring = "ler";
        List<String> wordsContainingSubstring = new ArrayList<>();
        wordsContainingSubstring.add("flere");
        wordsContainingSubstring.add("condolere");
        Assertions.assertEquals(wordsContainingSubstring, analyzer.getWordsContainingSubstring(substring));
    }

    @Test
    void Should_Get_WordsWhichArePalindromes() throws IOException {
        FilePartReader reader = callTheFilepartReaderClass();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> palindromes = new ArrayList<>();
        Assertions.assertEquals(palindromes, analyzer.getStringsWhichPalindromes());
    }

    @Test
    void Should_Get_ListOfStringsFromText() throws IOException {
        FilePartReader reader = callTheFilepartReaderClass();
        List<String> allWordsInText = new ArrayList<>();
        allWordsInText.add("fac");
        allWordsInText.add("me");
        allWordsInText.add("tecum");
        allWordsInText.add("pie");
        allWordsInText.add("flere");
        allWordsInText.add("crucifixo");
        allWordsInText.add("condolere");
        Assertions.assertEquals(allWordsInText, FileWordAnalyzer.getStringOfArrayFromText(reader));
    }
}