package com.university.creators;

import com.university.evaluation.Evaluation;

import java.util.List;

public class Creator3 implements Creator {

    private String filename;

    public Creator3(String filename){
        this.filename = filename;

    }
    @Override
    public void create(){

    }
    @Override
    public List<Evaluation> getdata(){
        return null;
    }
}
