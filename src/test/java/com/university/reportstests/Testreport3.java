package com.university.reportstests;


import com.university.fileSolutionCreator.Report3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testreport3 {

    private Report3 report3;
    private List<String[]> gradedStudents;
    private List<String[]> evaluations;


    public void setUp() {
        gradedStudents = Arrays.asList(
                new String[]{"John Doe", "Computer Engineering", "Approved"},
                new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}
        );

        evaluations = Arrays.asList(
                new String[]{"John Doe", "Computer Engineering", "Approved"},
                new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}
        );

        report3 = new Report3(gradedStudents, evaluations);
    }

    @Test
    public void testConstructor() {
        List<String[]> fileData = report3.getFileData();
        List<String[]> evaluationsData = report3.getEvaluationsData();

        assertEquals(2, fileData.size());
        assertEquals(2, evaluationsData.size());

        assertArrayEquals(new String[]{"John Doe", "Computer Engineering", "Approved"}, fileData.get(0));
        assertArrayEquals(new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}, fileData.get(1));

        assertArrayEquals(new String[]{"John Doe", "Computer Engineering", "Approved"}, evaluationsData.get(0));
        assertArrayEquals(new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}, evaluationsData.get(1));
    }

    @Test
    public void testGetFileData() {
        List<String[]> fileData = report3.getFileData();

        assertEquals(2, fileData.size());

        assertArrayEquals(new String[]{"John Doe", "Computer Engineering", "Approved"}, fileData.get(0));
        assertArrayEquals(new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}, fileData.get(1));
    }

    @Test
    public void testGetEvaluationsData() {
        List<String[]> evaluationsData = report3.getEvaluationsData();
        assertNotNull(evaluationsData);
        assertEquals(2, evaluationsData.size());

        assertArrayEquals(new String[]{"John Doe", "Computer Engineering", "Approved"}, evaluationsData.get(0));
        assertArrayEquals(new String[]{"Jane Smith", "Computer Engineering", "Not Approved"}, evaluationsData.get(1));
    }

    @Test
    public void testConstructorWithEmptyData() {
        gradedStudents = Arrays.asList();
        evaluations = Arrays.asList();

        report3 = new Report3(gradedStudents, evaluations);

        assertTrue(report3.getFileData().isEmpty());
        assertTrue(report3.getEvaluationsData().isEmpty());
    }


}
