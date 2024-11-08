package com.university.clasestest.testcreators;

import com.university.creators.Creator2;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.evaluation.typesOfEvaluations.OralExam;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreatorTest2 {

    @Test
    public void testCreateEvaluations() {
        Creator2 creator2 = new Creator2("src/main/resources/input_2.csv");
        creator2.create();

        List<Evaluation> evaluations = creator2.getData();
        assertEquals(30240, evaluations.size());


        Evaluation firstEvaluation = evaluations.get(0);
        assertTrue(firstEvaluation instanceof WrittenExam);

        assertEquals("Hank Pink", firstEvaluation.getStudent());


        Evaluation secondEvaluation = evaluations.get(1092);
        assertFalse(secondEvaluation instanceof OralExam);

        assertEquals("Quincy Yellow", secondEvaluation.getStudent());
    }
}
