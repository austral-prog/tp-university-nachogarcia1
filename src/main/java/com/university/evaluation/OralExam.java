package com.university.evaluation;

public class OralExam extends Assessment {

    public OralExam(String student, String subject, String evaluationName, String exerciseName, String grade) {
        super(student, subject, evaluationName, exerciseName, grade);
    }

    @Override
    public String getType() {
        return "OralExam";
    }

    // Métodos específicos para exámenes orales (si los necesitas)
}