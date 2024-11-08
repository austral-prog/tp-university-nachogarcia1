package com.university.creators;

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

        // Verificar el primer WrittenExam
        Evaluation firstEvaluation = evaluations.get(0);
        assertTrue(firstEvaluation instanceof WrittenExam);
        // Ahora simplemente accede al método común sin hacer cast
        assertEquals("Hank Pink", firstEvaluation.getStudent());

        // Verificar el segundo OralExam
        Evaluation secondEvaluation = evaluations.get(1092);
        assertFalse(secondEvaluation instanceof OralExam);
        // Accede a los métodos comunes de la interfaz Evaluation
        assertEquals("Quincy Yellow", secondEvaluation.getStudent());
    }
}
