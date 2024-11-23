package com.university.evaluation.typesOfEvaluations;

import com.university.evaluation.Evaluation;

public class OralExam extends Evaluation {

    public OralExam(String student, String subject, String evaluationName, String exerciseName, double grade) {
        super(student, subject, evaluationName, exerciseName, grade);
    }



    @Override
    public String getType() {
        return "ORAL_EXAM";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}