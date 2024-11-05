package com.university.course;

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

    List<PracticalWork> practicalWorks;
    List<WrittenExam> writtenExams;
    List<OralExam> oralExams;
    List<FinalPracticalWork> finalPracticalWorks;



    public Course(String name) {
        this.name = name;
        this.classrooms = new ArrayList<>();
        this.practicalWorks = new ArrayList<>();
        this.writtenExams = new ArrayList<>();
        this.oralExams = new ArrayList<>();
        this.finalPracticalWorks = new ArrayList<>();

    }

    //getter

    public String getSubject() {
        return name;
    }

    public List<String> getClassrooms() {
        return classrooms;
    }
    public List<PracticalWork> getPracticalWorks() {
        return practicalWorks;
    }
    public List<WrittenExam> getWrittenExams() {
        return writtenExams;
    }
    public List<FinalPracticalWork> getFinalPracticalWorks() {
        return finalPracticalWorks;
    }
    public List<OralExam> getOralExams(){
        return oralExams;
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