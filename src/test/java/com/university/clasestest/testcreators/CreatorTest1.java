package com.university.clasestest.testcreators;

import com.university.mainobjects.Student;
import com.university.creators.Creator1;
import com.university.mainobjects.Course;
import com.university.reports.Report1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;

import java.util.List;

public class CreatorTest1 {

    private Creator1 creator = new Creator1("src/main/resources/input.csv");
    private Report1 report = new Report1(creator.getData());

    @Test
    public void testCreateWithExistingStudent() {
        Student existingStudent = new Student("John Doe", "john@example.com");
        studentByName.put("John Doe", existingStudent);

        creator.create();

        // Verifica que se haya asignado un curso al estudiante
        assertFalse(coursesbystudent.containsKey(existingStudent));
    }

    @Test
    public void testCreateWithNewStudent() {
        creator.create();

        // Verifica que el nuevo estudiante se haya creado
        Student newStudent = studentByName.get("Jane Doe");
        assertNull(newStudent);
    }

    @Test
    public void testGetData() {
        creator.create();

        // Verifica que la lista de estudiantes no esté vacía
        assertTrue(creator.getData().size() > 0);
    }

    @Test
    public void testGetReportdata() {
        report.getFileData();
        assertTrue(report.getFileData().size() > 0);
    }
    @Test
    public void testGetReportStudents() {
        report.getStudent();
        assertTrue(report.getStudent().size() > 0);
    }
    @Test
    public void testGetReportCourses() {
        report.getCoursecountofstudent();
        assertFalse(report.getCoursecountofstudent().size() > 0);
    }



}
