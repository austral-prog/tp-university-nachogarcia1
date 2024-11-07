package com.university.evaluation.passingcriteria;

import java.util.ArrayList;
import java.util.List;

public class MaxAboveValue extends ApprovalCriteria {
    private List<String> Status;

    public MaxAboveValue(List<Double> Notes, Double criteriaValue) {
        this.Status = new ArrayList<String>();
        calculateStatus(Notes, criteriaValue);
    }

    @Override
    void calculateStatus(List<Double> Notes, Double criteriaValue) {
        for (Double note : Notes){
            if (note >= criteriaValue){
                Status.add("Approved");
            } else {
                Status.add("Failed");
            }
        }
    }


    @Override
    public List<String> getStatus() {
        return Status;
    }
}