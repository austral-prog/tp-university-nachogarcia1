package com.university.fileSolutionCreator;

import com.university.creators.*;
import com.university.csv.*;
import com.university.course.*;
import com.university.evaluation.*;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.student.*;

import java.util.ArrayList;
import java.util.List;

public class Report2 {

    private List<String[]> fileData = new ArrayList<>();

    public Report2(List<PracticalWork> practicalWorks, List<WrittenExam> writtenExams, List<OralExam> oralExams, List<FinalPracticalWork> finalPracticalWorks) {
        EvaluationSorter evaluationSorter = new EvaluationSorter(practicalWorks, writtenExams, oralExams, finalPracticalWorks);
        List<Evaluation> orderedEvaluations = evaluationSorter.getOrderedEvaluations();
        for ( Evaluation evaluation : orderedEvaluations ) {
            String[] row = {evaluation.getName(), String.valueOf(student.getSubjectsamount())};
            fileData.add(row);
    }

    public List<String[]> getFileData() {
        return fileData;
    } //posible interfaz (cambiar despues)



}
