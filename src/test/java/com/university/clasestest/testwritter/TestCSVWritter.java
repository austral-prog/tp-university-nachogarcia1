package com.university.clasestest.testwritter;

import com.university.csv.CSVwritter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.delete;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCSVWritter {

    String[] header = {"Student_Name", "Course_Count"};
    String fileOut = "src/main/resources/solutionforTest.csv";

    @AfterEach

    void cleanUp() {
        try {
            Files.deleteIfExists(Path.of(fileOut));
        } catch (IOException e) {
            System.err.println("Failed to delete test file: " + e.getMessage());
        }
    }

    @Test
    void testWriteMethodExecution() {


        List<String[]> data = List.of(
                new String[]{"John", "5"},
                new String[]{"Jane", "6"}
        );


        CSVwritter csvWritter = new CSVwritter(header, fileOut, data);
        csvWritter.write(",");


        assertTrue(new java.io.File(fileOut).exists(), "file should exist");

    }
}