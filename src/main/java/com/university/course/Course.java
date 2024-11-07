package com.university.course;

import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    String name;
    List<String> classrooms;
    List<Evaluation> evaluations;




    public Course(String name) {
        this.name = name;
        this.classrooms = new ArrayList<>();
        this.evaluations = new ArrayList<>();

    }

    //getter

    public String getSubject() {
        return name;
    }

    public List<String> getClassrooms() {
        return classrooms;
    }



    public List<Evaluation> getEvaluations(){
        return evaluations;

    }

    public List<String> getEvaluationNames() {
        List<String> names = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            names.add(evaluation.getSubject());
        }
        return names;
    }

    public double getFinalGrade() {
        List<Double> grades = this.getGrades(); // Asegúrate de que el método getGrades() esté en Evaluation

        if (this.getEvaluations() instanceof WrittenExam) {
            double sum = 0.0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        } else if (this.getEvaluations() instanceof OralExam) {
            return grades.get(0);  // Solo usa la primera calificación en caso de OralExam
        } else if (this.getEvaluations() instanceof PracticalWork || this.getEvaluations() instanceof FinalPracticalWork) {
            return grades.get(grades.size() - 1);  // Última calificación para trabajos prácticos
        }

        return 0.0; // Valor por defecto si no coincide con ningún tipo de evaluación
    }



    public List<Double> getGrades() {
        List<Double> grades = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            grades.add(evaluation.getGrade());

        }
        return grades;
    }

    //identity


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


}