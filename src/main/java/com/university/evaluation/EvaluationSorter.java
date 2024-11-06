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

    public EvaluationSorter(List<Evaluation> evaluations) {

        orderedevaluations = new ArrayList<>();

        Comparator<Evaluation> evaluationComparator = Comparator
                .comparing(Evaluation::getSubject)
                .thenComparing(Evaluation::getEvaluationName)
                .thenComparing(Evaluation::getStudent);

        evaluations.sort(evaluationComparator);


        orderedevaluations.addAll(evaluations);

    }

    public List<Evaluation> getOrderedEvaluations() {
        return orderedevaluations;
    }
}
