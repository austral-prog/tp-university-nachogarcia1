//package com.university.creators;
//
//import com.university.csv.CSVreader;
//import com.university.evaluation.Evaluation;
//
//import java.util.List;
//
//public class Creator3 implements Creator {
//
//    private String filename;
//
//    public Creator3(String filename){
//        this.filename = filename;
//
//    }
//    @Override
//    public void create(){
//
//        CSVreader csvreader = new CSVreader(filename);
//        csvreader.read(",");
//        List<String[]> allData = csvreader.getData();
//
//        for (String[] data : allData) {
//            if (data.length != 0) {
//
//
//               String SubjectName = data[0];
//               String CriteriaType = data[1];
//               String CriteriaValue = data[2];
//               String EvaluationName = data[3::];
//
//            for (Course course: coursebystudents)
//
//
//            }
//
//    }
//    @Override
//    public List<Evaluation> getdata(){
//        return null;
//    }
//}
