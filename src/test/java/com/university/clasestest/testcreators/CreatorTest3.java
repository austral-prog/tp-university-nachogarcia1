package com.university.clasestest.testcreators;



import com.university.University;
import com.university.creators.Creator3;
import com.university.mainobjects.Course;
import com.university.mainobjects.Student;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.reports.Report3;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreatorTest3 {
    Creator3 creator = new Creator3("src/main/resources/input_3.csv");
    List<String[]> gradedStudents = creator.getData();
    List<String[]> evaluations2 = creator.getEvaluations();
    Report3 report3 = new Report3(gradedStudents, evaluations2);
    @Test
    public void testCreateWithValidData() {
        creator.create();


        Student student = new Student("Alice", "alice@example.com");
        Course course = new Course("Math");
        course.addEvaluation(new WrittenExam("Alice", "Math", "Exam 1", "Exercise 1", 8.0));

        Map<Student, List<Course>> courses = new HashMap<>();
        courses.put(student, List.of(course));
        University.coursesbystudent = courses;

        creator.create();

        List<String[]> results = creator.getData();
        assertFalse(results.isEmpty());
    }




    @Test
    public void testApprovalStatus() {
        Creator3 creator = new Creator3("mockFile.csv");

        assertEquals("Approved", creator.getApprovalStatus(85, "AVERAGE_ABOVE_VALUE", 80));
        assertEquals("Not Approved", creator.getApprovalStatus(75, "AVERAGE_ABOVE_VALUE", 80));
        assertNull(creator.getApprovalStatus(85, "INVALID_TYPE", 80));
    }

    @Test
    public void testgetters(){
        assertFalse(report3.getFileData().size()>0);
        assertFalse(report3.getEvaluationsData().size()>0);
    }



}
