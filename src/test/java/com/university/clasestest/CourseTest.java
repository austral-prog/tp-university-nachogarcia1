package com.university.clasestest;

import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.mainobjects.Course;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course createCourseWithEvaluations() {
        Course course = new Course("Computer Engineering");
        course.addEvaluation(new WrittenExam("John Doe", "Computer Engineering", "Written Exam 1", "Exercise 1", 9.0));
        course.addEvaluation(new OralExam("John Doe", "Computer Engineering", "Oral Exam 1", "Exercise 1", 8.0));
        course.addEvaluation(new PracticalWork("John Doe", "Computer Engineering", "Practical Work 1", "Exercise 1", 8.0));
        course.addEvaluation(new FinalPracticalWork("John Doe", "Computer Engineering", "Final Practical Work 1", "Exercise 1", 8.0));
        return course;
    }

    @Test
    public void testGetSubject() {
        Course course = new Course("Computer Engineering");
        assertEquals("Computer Engineering", course.getSubject());
    }

    @Test
    public void testAddEvaluationAndRetrieve() {
        Course course = createCourseWithEvaluations();
        assertEquals(4, course.getEvaluations().size());
    }



    @Test
    public void testGetGrades() {
        Course course = createCourseWithEvaluations();
        List<Double> grades = course.getGrades();
        assertTrue(grades.contains(9.0));
        assertTrue(grades.contains(8.0));
        assertTrue(grades.contains(8.0));
        assertTrue(grades.contains(8.0));
    }



    @Test
    public void testGetFinalGrade() {
        Course course = createCourseWithEvaluations();
        double finalGrade = course.getFinalGrade();
        assertTrue(finalGrade > 0.0);
    }

    @Test
    public void testEqualsAndHashCode() {
        Course course1 = new Course("Computer Engineering");
        Course course2 = new Course("Computer Engineering");
        assertEquals(course1, course2);
        assertEquals(course1.hashCode(), course2.hashCode());
    }

    @Test
    public void testInequality() {
        Course course1 = new Course("Computer Engineering");
        Course course2 = new Course("Mechanical Engineering");
        assertNotEquals(course1, course2);
    }
}
