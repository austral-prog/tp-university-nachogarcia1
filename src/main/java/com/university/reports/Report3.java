package com.university.reports;

import java.util.ArrayList;
import java.util.List;

public class Report3 {

    private List<String[]> fileData = new ArrayList<>();
    private List<String[]> evaluationsData = new ArrayList<>();

    public Report3(List<String[]> gradedStudents, List<String[]> evaluations) {
        for (String[] studentData : gradedStudents) {
            if (studentData.length != 0) {
                String studentName = studentData[0];
                String subjectName = studentData[1];
                String approvalStatus = studentData[2]; // Puede ser "Approved" o "Not Approved"
                fileData.add(new String[]{studentName, subjectName, approvalStatus});
            } else {
                break;
            }
        }

        for (String[] evaluationData : evaluations) {
            if (evaluationData.length != 0) {
                String studentName = evaluationData[0];
                String subjectName = evaluationData[1];
                String approvalStatus = evaluationData[2];
                evaluationsData.add(new String[]{studentName, subjectName, approvalStatus});
            } else {
                break;
            }
        }
    }

    public List<String[]> getFileData() {
        return fileData;
    }

    public List<String[]> getEvaluationsData() {
        return evaluationsData;
    }
}

