package com.university.clasestest.testwritter;

import com.university.csv.CSVwritter;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCSVWritter {

    @Test
    void testWriteMethodExecution() {

        String[] header = {"Student_Name", "Course_Count"};
        String fileOut = "src/main/resources/solutionforTest.csv";
        List<String[]> data = List.of(
                new String[]{"John", "5"},
                new String[]{"Jane", "6"}
        );


        CSVwritter csvWritter = new CSVwritter(header, fileOut, data);
        csvWritter.write(",");


        assertTrue(new java.io.File(fileOut).exists(), "file should exist");
    }
}