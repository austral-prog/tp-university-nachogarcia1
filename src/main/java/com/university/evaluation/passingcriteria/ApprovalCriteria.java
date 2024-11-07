package com.university.evaluation.passingcriteria;

import java.util.List;

public abstract class ApprovalCriteria {

    public abstract List<String> getStatus();

    abstract void calculateStatus(List<Double> Notes, Double criteriaValue);
}