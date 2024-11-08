package com.university.clasestest.testcreators;

import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.fileSolutionCreator.Report2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatorTest2 {



        private List<Evaluation> evaluations;
        private Report2 report2;


        public void setUp() {
            evaluations = Arrays.asList(
                    new WrittenExam("John Doe", "Computer Engineering", "Midterm", "Exercise 1", 8.0),
                    new WrittenExam("Jane Smith", "Computer Engineering", "Midterm", "Exercise 2", 7.5),
                    new WrittenExam("John Doe", "Computer Engineering", "Midterm", "Exercise 1", 8.0)
            );

            report2 = new Report2(evaluations);
        }

        @Test
        public void testConstructor() {
            List<String[]> fileData = report2.getFileData();
            assertEquals(2, fileData.size());
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "John Doe", "8.0"}, fileData.get(0));
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "Jane Smith", "7.5"}, fileData.get(1));
        }

        @Test
        public void testGetFileData() {
            List<String[]> fileData = report2.getFileData();
            assertNotNull(fileData);
            assertEquals(2, fileData.size());
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "John Doe", "8.0"}, fileData.get(0));
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "Jane Smith", "7.5"}, fileData.get(1));
        }

        @Test
        public void testGetFileDataWithEmptyEvaluations() {
            evaluations = Arrays.asList();
            report2 = new Report2(evaluations);

            List<String[]> fileData = report2.getFileData();
            assertTrue(fileData.isEmpty());
        }

        @Test
        public void testGetFileDataWithNoDuplicates() {
            evaluations = Arrays.asList(
                    new WrittenExam("John Doe", "Computer Engineering", "Midterm", "Exercise 1", 8.0),
                    new WrittenExam("John Doe", "Computer Engineering", "Midterm", "Exercise 1", 8.0),
                    new WrittenExam("Jane Smith", "Computer Engineering", "Midterm", "Exercise 2", 7.5)
            );
            report2 = new Report2(evaluations);

            List<String[]> fileData = report2.getFileData();
            assertEquals(2, fileData.size());
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "John Doe", "8.0"}, fileData.get(0));
            assertArrayEquals(new String[]{"Computer Engineering", "Midterm", "Jane Smith", "7.5"}, fileData.get(1));
        }
    }


