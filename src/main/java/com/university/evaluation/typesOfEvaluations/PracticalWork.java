package com.university.evaluation.typesOfEvaluations;

import com.university.evaluation.Evaluation;

public class PracticalWork extends Evaluation {

    public PracticalWork(String student, String subject, String evaluationName, String exerciseName, double grade) {

        super(student, subject, evaluationName, exerciseName, grade);
    }



    @Override
    public String getType() {
        return "PRACTICAL_WORK";
    }

}