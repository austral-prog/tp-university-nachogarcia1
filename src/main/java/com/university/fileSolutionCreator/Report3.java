package com.university.fileSolutionCreator;

import com.university.creators.Creator3;
import com.university.evaluation.Evaluation;
import com.university.sorters.EvaluationSorter;

import java.util.*;

import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Report3 {

    private List<String[]> fileData = new ArrayList<>();

    public Report3(List<String[]> gradedStudents) {
        // Iterar sobre los estudiantes y agregar los datos de aprobación
        for (String[] studentData : gradedStudents) {
            String studentName = studentData[0];
            String subjectName = studentData[1];
            String approvalStatus = studentData[2]; // Puede ser "Approved" o "Not Approved"
            // Agregar al resultado en formato de arreglo de strings
            fileData.add(new String[]{studentName, subjectName, approvalStatus});
        }
    }

    public List<String[]> getFileData() {
        return fileData;
    }
}
