package com.university.evaluation.typesOfEvaluations;

import com.university.evaluation.Evaluation;

public class FinalPracticalWork extends Evaluation {

    public FinalPracticalWork(String student, String subject, String evaluationName, String exerciseName, double grade) {

        super(student, subject, evaluationName, exerciseName, grade);
    }



    @Override
    public String getType() {
        return "FINAL_PRACTICAL_WORK";
    }

}

