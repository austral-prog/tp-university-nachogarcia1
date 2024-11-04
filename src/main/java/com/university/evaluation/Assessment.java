
package com.university.evaluation;

public abstract class Assessment {
    protected String student;
    protected String subject;
    protected String evaluationName;
    protected String exerciseName;
    protected String grade;
    protected Boolean passed = false;

    public Assessment(String student, String subject, String evaluationName, String exerciseName, String grade) {
        this.student = student;
        this.subject = subject;
        this.evaluationName = evaluationName;
        this.exerciseName = exerciseName;
        this.grade = grade;
    }

    public String getStudent() {
        return student;
    }

    public String getSubject() {
        return subject;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getGrade() {
        return grade;
    }

    public Boolean getApproval() {
        return passed;
    }

    public void ApproveStudent() {
        passed = true;
    }

    // Método abstracto que las subclases pueden sobreescribir si es necesario
    public abstract String getType();
}