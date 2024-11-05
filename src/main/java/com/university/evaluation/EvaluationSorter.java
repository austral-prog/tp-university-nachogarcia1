package com.university.evaluation;

import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EvaluationSorter {

    private List<Evaluation> orderedevaluations;

    public EvaluationSorter(List<PracticalWork> practicalWorks, List<WrittenExam> writtenExams, List<OralExam> oralExams, List<FinalPracticalWork> finalPracticalWorks) {

        orderedevaluations = new ArrayList<>();

        Comparator<Evaluation> evaluationComparator = Comparator
                .comparing(Evaluation::getStudent)
                .thenComparing(Evaluation::getEvaluationName)
                .thenComparing(Evaluation::getSubject);

        practicalWorks.sort(evaluationComparator);
        finalPracticalWorks.sort(evaluationComparator);
        oralExams.sort(evaluationComparator);
        writtenExams.sort(evaluationComparator);

        orderedevaluations.addAll(finalPracticalWorks);
        orderedevaluations.addAll(practicalWorks);
        orderedevaluations.addAll(writtenExams);
        orderedevaluations.addAll(oralExams);
    }

    public List<Evaluation> getOrderedEvaluations() {
        return orderedevaluations;
    }
}
