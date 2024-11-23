package com.university.clasestest.testcreators;

import com.university.creators.Creator2;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.reports.Report2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreatorTest2 {

    Creator2 creator2 = new Creator2("src/main/resources/input_2.csv");


    @Test
    public void testCreateEvaluations() {
        creator2.create();

        List<Evaluation> evaluations = creator2.getData();
        assertEquals(30240, evaluations.size());


        Evaluation firstEvaluation = evaluations.get(0);


        assertEquals("Hank Pink", firstEvaluation.getStudent());


        Evaluation secondEvaluation = evaluations.get(1092);


        assertEquals("Jack Orange", secondEvaluation.getStudent());
    }
    @Test
    public void testFileData(){
        Report2 report2 = new Report2(creator2.getData());
        assertTrue(report2.getFileData().size() > 0);
    }
}
