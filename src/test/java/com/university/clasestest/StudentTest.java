package com.university.clasestest;

import com.university.mainobjects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testName() {
        Student student = new Student("Alice", "alice@example.com");
        assertEquals("Alice", student.getName());
    }

    @Test
    public void testAddSubject() {
        Student student = new Student("Bob", "bob@example.com");
        student.addSubject("Math");
        assertEquals(1, student.getSubjectsamount());
    }

    @Test
    public void testAddDuplicateSubject() {
        Student student = new Student("Charlie", "charlie@example.com");
        student.addSubject("Math");
        student.addSubject("Math");  // Try to add the same subject again
        assertEquals(1, student.getSubjectsamount());
    }

    @Test
    public void testEquality() {
        Student student1 = new Student("Alice", "alice@example.com");
        Student student2 = new Student("Alice", "alice@example.com");
        assertEquals(student1, student2);
    }

    @Test
    public void testInequality() {
        Student student1 = new Student("Alice", "alice@example.com");
        Student student2 = new Student("Bob", "bob@example.com");
        assertNotEquals(student1, student2);
    }
}
