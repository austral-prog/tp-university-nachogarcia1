package com.university.clasestest.testcreators;


import com.university.creators.*;
import com.university.mainobjects.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;


import com.university.mainobjects.Student;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class CreatorTest1 {

    private Creator1 creator;

    @BeforeEach
    public void setUp() {
        creator = new Creator1("test.csv");
    }

    @Test
    public void testCreateWithExistingStudent() {
        Student existingStudent = new Student("John Doe", "john@example.com");
        studentByName.put("John Doe", existingStudent);

        creator.create();

        Course course = coursesbystudent.get(existingStudent).get(0);
        assertEquals("Math", course.getSubject());
        assertTrue(studentByName.containsKey("John Doe"));
    }

    @Test
    public void testCreateWithNewStudent() {
        creator.create();

        Student newStudent = studentByName.get("Jane Doe");
        assertNotNull(newStudent);
        assertEquals("Jane Doe", newStudent.getName());
        assertFalse(coursesbystudent.get(newStudent).isEmpty());
    }

    @Test
    public void testGetData() {
        Student student = new Student("John Doe", "john@example.com");
        studentByName.put("John Doe", student);

        List<Student> students = creator.getData();
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
    }
}
