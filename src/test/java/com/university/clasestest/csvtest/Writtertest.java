package com.university.clasestest.csvtest;


import com.university.csv.CSVwritter;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Writtertest {

    @Test
    public void testWriteCSV() {
        String[] headers = {"name", "subject", "email"};
        String fileOut = "test_output.csv";
        List<String[]> data = List.of(
                new String[]{"John Doe", "Math", "john@example.com"},
                new String[]{"Jane Doe", "Science", "jane@example.com"}
        );
        CSVwritter writer = new CSVwritter(headers, fileOut, data);
        writer.write(",");

        File outputFile = new File(fileOut);
        assertTrue(outputFile.exists());

        try {
            List<String> lines = Files.readAllLines(outputFile.toPath());
            assertEquals(3, lines.size());
            assertEquals("name,subject,email", lines.get(0));
        } catch (Exception e) {
            fail("Error reading file");
        }
    }
}

