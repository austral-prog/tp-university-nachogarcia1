package com.university.evaluation;

public class PracticalWork extends Assessment {

    public PracticalWork(String student, String subject, String evaluationName, String exerciseName, String grade) {
        super(student, subject, evaluationName, exerciseName, grade);
    }

    @Override
    public String getType() {
        return "PracticalWork";
    }

    // Métodos específicos para trabajos prácticos (si los necesitas)
}