package com.codecool.filepartreader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FilePartReaderTest {

    @Test
    void Should_Throw_IllegalArgumentException_When_ToOrFromLineIsUnderZero() {
        FilePartReader reader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> reader.setup("/home/zsana/Codecool/OOP/fifthSIWeek/filepartreader-testing-with-junit-ezsana/src/main/resources/stabat_mater.txt", -1, -1));
    }

    @Test
    void Should_Print_TheWholeOpenedTextFile() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/home/zsana/Codecool/OOP/fifthSIWeek/filepartreader-testing-with-junit-ezsana/src/main/resources/stabat_mater_short_version_for_tests.txt", 1, 1);
        String string = reader.read();
        Assertions.assertEquals("Fac me tecum pie flere,\n" +
                "crucifixo condolere,\n" +
                "donec ego vixero.", string);
    }

    @Test
    void Should_Print_OpenedTextFileWithinTheGivenRange() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/home/zsana/Codecool/OOP/fifthSIWeek/filepartreader-testing-with-junit-ezsana/src/main/resources/stabat_mater_short_version_for_tests.txt", 2, 3);
        String string = reader.readLines();
        Assertions.assertEquals("crucifixo condolere,\n" +
                "donec ego vixero.", string);
    }
}