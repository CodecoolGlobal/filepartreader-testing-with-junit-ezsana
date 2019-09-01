package com.codecool.filepartreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FilePartReader {

    private String filePath; // "/home/zsana/Codecool/OOP/fifthSIWeek/filepartreader-testing-with-junit-ezsana/src/main/resources/stabat_mater.txt"
    private Integer fromLine;
    private Integer toLine;

    FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = -1;
    }

    void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if ((toLine < fromLine) || (fromLine < 1)) throw new IllegalArgumentException();
    }

    String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    String readLines() throws IOException {
        String[] linesInList = read().split("\n");
        String fromToString = "";
        for (int i = fromLine - 1; i < toLine; i++) {
            fromToString += linesInList[i] + "\n";
        }
        return fromToString.trim();
    }
}
