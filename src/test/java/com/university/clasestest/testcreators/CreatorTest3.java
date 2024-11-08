package com.university.clasestest.testcreators;


import com.university.creators.Creator3;
import com.university.csv.CSVreader;
import com.university.mainobjects.Student;
import com.university.mainobjects.Course;
import java.util.List;
import static com.university.University.coursesbystudent;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatorTest3 {

    private Creator3 creator;

    @BeforeEach
    public void setUp() {
        creator = new Creator3("test.csv");
    }

    @Test
    public void testCreateWithValidData() {
        Student student = new Student("John Doe", "john@example.com");
        Course course = new Course("Math");
        coursesbystudent.put(student, List.of(course));

        creator.create();

        List<String[]> results = creator.getData();
        assertEquals(1, results.size());
        assertEquals("Approved", results.get(0)[2]);
    }

    @Test
    public void testCreateWithInvalidData() {
        creator = new Creator3("invalid.csv");
        creator.create();

        List<String[]> results = creator.getData();
        assertTrue(results.isEmpty());
    }

    @Test
    public void testGetEvaluations() {
        Student student = new Student("Jane Doe", "jane@example.com");
        Course course = new Course("Science");
        coursesbystudent.put(student, List.of(course));

        creator.create();

        List<String[]> evaluations = creator.getEvaluations();
        assertEquals(1, evaluations.size());
        assertEquals("Approved", evaluations.get(0)[2]);
    }


}
