package com.university.clasestest.evaluationstests;

import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAllTypesofEvaluation {

    private PracticalWork practicalWork;
    private WrittenExam writtenExam;
    private OralExam oralExam;
    private FinalPracticalWork finalPracticalWork;

    @BeforeEach
    public void setUp() {
        // Inicializamos las evaluaciones con los parámetros adecuados
        practicalWork = new PracticalWork("John Doe", "Computer Engineering", "Practical Work 1", "Exercise 1", 85.0);
        writtenExam = new WrittenExam("John Doe", "Computer Engineering", "Written Exam 1", "Exercise 1", 90.0);
        oralExam = new OralExam("John Doe", "Computer Engineering", "Oral Exam 1", "Exercise 1", 80.0);
        finalPracticalWork = new FinalPracticalWork("John Doe", "Computer Engineering", "Final Practical Work 1", "Exercise 1", 88.0);
    }

    @Test
    public void testPracticalWorkConstructor() {
        assertNotNull(practicalWork);
        assertEquals("John Doe", practicalWork.getStudent());
        assertEquals("Computer Engineering", practicalWork.getSubject());
        assertEquals("Practical Work 1", practicalWork.getEvaluationName());
        assertEquals("Exercise 1", practicalWork.getExerciseName());
        assertEquals(85.0, practicalWork.getGrade());
        assertEquals("PRACTICAL_WORK", practicalWork.getType());
    }

    @Test
    public void testWrittenExamConstructor() {
        assertNotNull(writtenExam);
        assertEquals("John Doe", writtenExam.getStudent());
        assertEquals("Computer Engineering", writtenExam.getSubject());
        assertEquals("Written Exam 1", writtenExam.getEvaluationName());
        assertEquals("Exercise 1", writtenExam.getExerciseName());
        assertEquals(90.0, writtenExam.getGrade());
        assertEquals("WRITTEN_EXAM", writtenExam.getType());
    }

    @Test
    public void testOralExamConstructor() {
        assertNotNull(oralExam);
        assertEquals("John Doe", oralExam.getStudent());
        assertEquals("Computer Engineering", oralExam.getSubject());
        assertEquals("Oral Exam 1", oralExam.getEvaluationName());
        assertEquals("Exercise 1", oralExam.getExerciseName());
        assertEquals(80.0, oralExam.getGrade());
        assertEquals("ORAL_EXAM", oralExam.getType());
    }

    @Test
    public void testFinalPracticalWorkConstructor() {
        assertNotNull(finalPracticalWork);
        assertEquals("John Doe", finalPracticalWork.getStudent());
        assertEquals("Computer Engineering", finalPracticalWork.getSubject());
        assertEquals("Final Practical Work 1", finalPracticalWork.getEvaluationName());
        assertEquals("Exercise 1", finalPracticalWork.getExerciseName());
        assertEquals(88.0, finalPracticalWork.getGrade());
        assertEquals("FINAL_PRACTICAL_WORK", finalPracticalWork.getType());
    }


}