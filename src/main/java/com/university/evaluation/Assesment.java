package com.university.evaluation;

public class Assesment {
private String subjectName;
private String AssesmentType;
private String Assesmentname;
private String grade;

public Assesment(String studentName, String subjectName, String assesmentName, String grade, String assesmentType) {
    this.subjectName = subjectName;
    this.AssesmentType = assesmentType;
    this.Assesmentname = assesmentName;
    this.grade = grade;

}

// getters



    public String getAssesmentType() {
    return AssesmentType;
    }

    public String getGrade() {
    return grade;
    }

    public String getAssesmentname() {
    return Assesmentname;
    }


}