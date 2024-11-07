package com.university.evaluation.passingcriteria;

import com.university.evaluation.passingcriteria.ApprovalCriteria;

import java.util.ArrayList;
import java.util.List;

public class AverageAboveValue extends ApprovalCriteria {
    private List<String> Status;

    public AverageAboveValue(List<Double> Notes, Double criteriaValue) {
        this.Status = new ArrayList<>();
        calculateStatus(Notes, criteriaValue);
    }

    @Override
    void calculateStatus(List<Double> Notes, Double criteriaValue) {
        int sum = 0;
        for (Double note : Notes) {
            sum += note;
        }
        if (sum > criteriaValue) {
            Status.add("Approved");
        } else{
            Status.add("Failed");
        }

    }

    @Override
    public List<String> getStatus() {
        return Status;
    }
}