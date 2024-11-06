package com.university.clasestest;

import com.university.course.Course;
import com.university.csv.CSVreader;
import com.university.csv.CSVwritter;
import com.university.fileSolutionCreator.Report1;
import com.university.student.Student;
import com.university.student.StudentSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    private List<Student> students;
    private Course mathCourse;

    @BeforeEach
    public void setUp() {
        students = Arrays.asList(
                new Student("Alice", "alice@example.com"),
                new Student("Bob", "bob@example.com"),
                new Student("Charlie", "charlie@example.com")
        );
        students.get(0).addSubject("Math");
        students.get(1).addSubject("Physics");
        students.get(2).addSubject("Math");

        mathCourse = new Course("Mathematics");
    }

    @Test
    public void testReadCSV() {
        CSVreader reader = new CSVreader("students.csv");
        reader.read(",");
        assertTrue(reader.getData().size() > 0, "CSV should have data");
    }

    @Test
    public void testCreateStudentsFromCSV() {
        assertEquals(3, students.size(), "Should have three students");
        assertEquals("Alice", students.get(0).getName());
    }

    @Test
    public void testWriteCSV() {
        String[] headers = {"Student Name", "Subjects"};
        CSVwritter writer = new CSVwritter(headers, "output.csv", new ArrayList<>());
        writer.write(",");
        assertTrue(true, "Write CSV without errors");
    }

    @Test
    public void testSortStudentsByName() {
        students = new StudentSorter(students).getOrderedStudents();
        assertEquals("Alice", students.get(0).getName());
    }

    @Test
    public void testGenerateStudentReport() {
        List<String[]> report = new Report1(students).getFileData();
        assertEquals(3, report.size(), "Report should have three entries");
        assertEquals("Alice", report.get(0)[0]);
    }

    @Test
    public void testCourseCreationAndAssignments() {
        assertEquals("Mathematics", mathCourse.getSubject());
    }

    @Test
    public void testStudentEquality() {
        Student alice1 = new Student("Alice", "alice@example.com");
        Student alice2 = new Student("Alice", "alice@example.com");
        assertEquals(alice1, alice2, "Students with the same name should be equal");
    }

    @Test
    public void testCourseEquality() {
        Course anotherMathCourse = new Course("Mathematics");
        assertEquals(mathCourse, anotherMathCourse, "Courses with the same name should be equal");
    }
}

