package com.university.sorters;

import com.university.evaluation.Evaluation;

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
