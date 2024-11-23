package com.university.mainobjects;

import com.university.cli.Entity;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course implements Entity {

    private int id;


    private String name;
    private List<String> classrooms;
    private List<Evaluation> evaluations;
    private List<WrittenExam> writtenExams;
    private List<OralExam> oralExams;
    private List<PracticalWork> practicalWorks;
    private List<FinalPracticalWork> finalPracticalWorks;

    public Course() {}
    public Course(String name) {
        this.name = name;
        this.classrooms = new ArrayList<>();
        this.evaluations = new ArrayList<>();
        this.writtenExams = new ArrayList<>();
        this.oralExams = new ArrayList<>();
        this.practicalWorks = new ArrayList<>();
        this.finalPracticalWorks = new ArrayList<>();
    }

    public String getSubject() {
        return name;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public List<String> getEvaluationNames() {
        List<String> names = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            names.add(evaluation.getSubject());
        }
        return names;
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
        if (evaluation instanceof WrittenExam) {
            writtenExams.add((WrittenExam) evaluation);
        } else if (evaluation instanceof OralExam) {
            oralExams.add((OralExam) evaluation);
        } else if (evaluation instanceof PracticalWork) {
            practicalWorks.add((PracticalWork) evaluation);
        } else if (evaluation instanceof FinalPracticalWork) {
            finalPracticalWorks.add((FinalPracticalWork) evaluation);
        }
    }

    public double getFinalGrade() {
        divideEvaluationsByType(evaluations);

        double totalGrade = 0.0;
        int count = 0;

        if (!writtenExams.isEmpty()) {
            double sum = 0.0;
            for (WrittenExam exam : writtenExams) {
                sum += exam.getGrade();
            }
            totalGrade += sum / writtenExams.size();
            count++;
        }

        if (!oralExams.isEmpty()) {
            totalGrade += oralExams.get(0).getGrade();
            count++;
        }

        if (!practicalWorks.isEmpty()) {
            totalGrade += practicalWorks.get(practicalWorks.size() - 1).getGrade();
            count++;
        }

        if (!finalPracticalWorks.isEmpty()) {
            totalGrade += finalPracticalWorks.get(finalPracticalWorks.size() - 1).getGrade();
            count++;
        }

        if (count > 0) {
            return totalGrade / count;
        } else {
            return 0.0;
        }
    }

    public void divideEvaluationsByType(List<Evaluation> allEvaluations) {
        for (Evaluation evaluation : allEvaluations) {
            if (evaluation instanceof WrittenExam) {
                writtenExams.add((WrittenExam) evaluation);
            } else if (evaluation instanceof OralExam) {
                oralExams.add((OralExam) evaluation);
            } else if (evaluation instanceof PracticalWork) {
                practicalWorks.add((PracticalWork) evaluation);
            } else if (evaluation instanceof FinalPracticalWork) {
                finalPracticalWorks.add((FinalPracticalWork) evaluation);
            }
        }
    }

    public List<Double> getGrades() {
        List<Double> grades = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            grades.add(evaluation.getGrade());
        }
        return grades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course subject = (Course) obj;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;

    }
}
