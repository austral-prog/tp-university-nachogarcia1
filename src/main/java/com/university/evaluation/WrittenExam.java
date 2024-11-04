package com.university.evaluation;

public class WrittenExam extends Assessment {

    public WrittenExam(String student, String subject, String evaluationName, String exerciseName, String grade) {
        super(student, subject, evaluationName, exerciseName, grade);
    }

    @Override
    public String getType() {
        return "WrittenExam";
    }

    // Métodos específicos para exámenes escritos (si los necesitas)
}