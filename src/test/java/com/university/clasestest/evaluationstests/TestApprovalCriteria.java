package com.university.clasestest.evaluationstests;

import static org.junit.jupiter.api.Assertions.*;

import com.university.evaluation.passingcriteria.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestApprovalCriteria {

    // Tests para la clase AverageAboveValue
    @Test
    public void testAverageAboveValueApproval() {

        List<Double> notes = List.of(10.0, 9.0, 8.0);
        double criteriaValue = 25.0;


        AverageAboveValue averageAboveValue = new AverageAboveValue(notes, criteriaValue);


        List<String> status = averageAboveValue.getStatus();
        assertEquals(1, status.size());
        assertEquals("Approved", status.get(0));
    }

    @Test
    public void testAverageAboveValueFail() {

        List<Double> notes = List.of(5.0, 4.0, 3.0);
        double criteriaValue = 20.0;


        AverageAboveValue averageAboveValue = new AverageAboveValue(notes, criteriaValue);


        List<String> status = averageAboveValue.getStatus();
        assertEquals(1, status.size());
        assertEquals("Failed", status.get(0));
    }

    // Tests para la clase MaxAboveValue
    @Test
    public void testMaxAboveValueApproval() {

        List<Double> notes = List.of(5.0, 9.0, 7.0);
        double criteriaValue = 8.0;


        MaxAboveValue maxAboveValue = new MaxAboveValue(notes, criteriaValue);


        List<String> status = maxAboveValue.getStatus();
        assertEquals(3, status.size());
        assertEquals("Approved", status.get(1));
    }

    @Test
    public void testMaxAboveValueFail() {

        List<Double> notes = List.of(5.0, 4.0, 3.0);
        double criteriaValue = 8.0;


        MaxAboveValue maxAboveValue = new MaxAboveValue(notes, criteriaValue);


        List<String> status = maxAboveValue.getStatus();
        assertEquals(3, status.size());
        assertEquals("Failed", status.get(0));
    }

    // Tests para la clase MinAboveValue


    @Test
    public void testMinAboveValueApproval() {

        List<Double> notes = List.of(10.0, 9.0, 8.0);
        double criteriaValue = 8.0;


        MinAboveValue minAboveValue = new MinAboveValue(notes, criteriaValue);


        List<String> status = minAboveValue.getStatus();
        assertEquals(3, status.size());
        assertEquals("Approved", status.get(0));
    }

    @Test
    public void testMinAboveValueFail() {

        List<Double> notes = List.of(10.0, 4.0, 8.0);
        double criteriaValue = 8.0;


        MinAboveValue minAboveValue = new MinAboveValue(notes, criteriaValue);


        List<String> status = minAboveValue.getStatus();
        assertEquals(3, status.size());
        assertEquals("Failed", status.get(1));
    }
}
