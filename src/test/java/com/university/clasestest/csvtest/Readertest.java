package com.university.clasestest.csvtest;


import com.university.csv.CSVreader;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Readertest {

    private CSVreader csvReader;


    public void setUp() {
        // Create a temporary CSV file for testing
        try {
            File tempFile = new File("test.csv");
            if (tempFile.createNewFile()) {
                FileWriter writer = new FileWriter(tempFile);
                writer.append("name,subject,email\n");
                writer.append("John Doe,Math,john@example.com\n");
                writer.append("Jane Doe,Science,jane@example.com\n");
                writer.close();
                csvReader = new CSVreader("test.csv");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadCSV() {
        csvReader.read(",");
        assertNotNull(csvReader.getData());
        assertEquals(3, csvReader.getData().size());
    }

    @Test
    public void testGetData() {
        csvReader.read(",");
        List<String[]> data = csvReader.getData();
        assertEquals(3, data.size());
        assertArrayEquals(new String[]{"John Doe", "Math", "john@example.com"}, data.get(1));
    }

    @Test
    public void testFileNotFound() {
        CSVreader invalidReader = new CSVreader("nonexistent.csv");
        Exception exception = assertThrows(RuntimeException.class, () -> invalidReader.read(","));
        assertTrue(exception.getMessage().contains("FileNotFoundException"));
    }
}
