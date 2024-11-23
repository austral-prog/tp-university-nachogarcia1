
package com.university.evaluation;

import com.university.cli.Entity;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluation implements Entity {
    protected String student;
    protected String subject;
    protected String evaluationName;
    protected String exerciseName;
    protected double grade;
    protected int id;

    public Evaluation(String student, String subject, String evaluationName, String exerciseName, double grade) {
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

    public double getGrade() {
        return grade;
    }


    public static List<List<Evaluation>> getAssessmentsByType(List<Evaluation> evaluations) {
        List<Evaluation> oralExams = new ArrayList<>();
        List<Evaluation> writtenExams = new ArrayList<>();
        List<Evaluation> practicalWorks = new ArrayList<>();
        List<Evaluation> finalPracticalWorks = new ArrayList<>();

        for (Evaluation evaluation : evaluations) {
            if (evaluation instanceof OralExam) {
                oralExams.add(evaluation);
            } else if (evaluation instanceof WrittenExam) {
                writtenExams.add(evaluation);
            } else if (evaluation instanceof PracticalWork) {
                practicalWorks.add(evaluation);
            } else if (evaluation instanceof FinalPracticalWork) {
                finalPracticalWorks.add(evaluation);
            }
        }

        List<List<Evaluation>> assessmentsByType = new ArrayList<>();
        assessmentsByType.add(oralExams);
        assessmentsByType.add(writtenExams);
        assessmentsByType.add(practicalWorks);
        assessmentsByType.add(finalPracticalWorks);

        return assessmentsByType;
    }



    public abstract String getType();


}