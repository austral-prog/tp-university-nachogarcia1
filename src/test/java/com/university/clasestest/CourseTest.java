package com.university.clasestest;

import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.mainobjects.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class CourseTest {

    private Course course;
    private WrittenExam writtenExam;
    private OralExam oralExam;
    private PracticalWork practicalWork;
    private FinalPracticalWork finalPracticalWork;

    public void setUp() {
        course = new Course("Computer Engineering");

        writtenExam = new WrittenExam("John Doe", "Computer Engineering", "Written Exam 1", "Exercise 1", 90.0);
        oralExam = new OralExam("John Doe", "Computer Engineering", "Oral Exam 1", "Exercise 1", 80.0);
        practicalWork = new PracticalWork("John Doe", "Computer Engineering", "Practical Work 1", "Exercise 1", 85.0);
        finalPracticalWork = new FinalPracticalWork("John Doe", "Computer Engineering", "Final Practical Work 1", "Exercise 1", 88.0);
    }

    @Test
    public void testGetSubject() {
        assertEquals("Computer Engineering", course.getSubject());
    }

    @Test
    public void testAddEvaluation() {
        course.addEvaluation(writtenExam);
        assertTrue(course.getEvaluations().contains(writtenExam));

        course.addEvaluation(oralExam);
        assertTrue(course.getEvaluations().contains(oralExam));
    }

    @Test
    public void testGetEvaluationNames() {
        course.addEvaluation(writtenExam);
        course.addEvaluation(oralExam);
        List<String> names = course.getEvaluationNames();
        assertTrue(names.contains("Written Exam 1"));
        assertTrue(names.contains("Oral Exam 1"));
    }

    @Test
    public void testGetGrades() {
        course.addEvaluation(writtenExam);
        course.addEvaluation(oralExam);
        List<Double> grades = course.getGrades();
        assertTrue(grades.contains(90.0));
        assertTrue(grades.contains(80.0));
    }

    @Test
    public void testDivideEvaluationsByType() {
        course.addEvaluation(writtenExam);
        course.addEvaluation(oralExam);
        course.addEvaluation(practicalWork);
        course.addEvaluation(finalPracticalWork);

        course.divideEvaluationsByType(course.getEvaluations());

        assertTrue(course.getEvaluations().contains(writtenExam));
        assertTrue(course.getEvaluations().contains(oralExam));
        assertTrue(course.getEvaluations().contains(practicalWork));
        assertTrue(course.getEvaluations().contains(finalPracticalWork));
    }

    @Test
    public void testGetFinalGrade() {
        course.addEvaluation(writtenExam);
        course.addEvaluation(oralExam);
        course.addEvaluation(practicalWork);
        course.addEvaluation(finalPracticalWork);

        double finalGrade = course.getFinalGrade();
        assertTrue(finalGrade > 0.0);
    }

    @Test
    public void testEqualsAndHashCode() {
        Course course2 = new Course("Computer Engineering");
        assertTrue(course.equals(course2));
        assertEquals(course.hashCode(), course2.hashCode());
    }
}
