package com.university.evaluation.typesOfEvaluations;

import com.university.evaluation.Evaluation;

public class WrittenExam extends Evaluation {

    public WrittenExam(String student, String subject, String evaluationName, String exerciseName, double grade) {
        super(student, subject, evaluationName, exerciseName, grade);
    }

    @Override
    public String getType() {
        return "WRITTEN_EXAM";
    }




}