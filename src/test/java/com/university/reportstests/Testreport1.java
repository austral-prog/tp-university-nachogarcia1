package com.university.reportstests;


import com.university.fileSolutionCreator.Report1;
import com.university.mainobjects.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testreport1 {

    @Test
    public void testCreateReport() {
        List<Student> students = List.of(
                new Student("John", "john@example.com"),
                new Student("Jane", "jane@example.com")
        );
        Report1 report = new Report1(students);

        assertEquals(2, report.getFileData().size());
        assertArrayEquals(new String[]{"John", "3"}, report.getFileData().get(0));
    }
}
