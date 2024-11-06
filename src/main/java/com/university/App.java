package com.university;

import com.university.creators.Creator2;
import com.university.csv.CSVwritter;
import com.university.creators.Creator1;
import com.university.evaluation.Evaluation;
import com.university.fileSolutionCreator.Report1;
import com.university.fileSolutionCreator.Report2;

import java.util.List;

public class App {

    public static void main(String[] args) {

        // ENTREGA 1 //

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";

        Creator1 creator1 = new Creator1(fileIn1);
        creator1.create();
        CSVwritter csvWritter1 = new CSVwritter(header1, fileOut1, (new Report1(creator1.getData())).getFileData());
        csvWritter1.write(",");

        // ENTREGA 2 //

        String[] header2 = {"Subject_Name", "Evaluation_Name", "Student_Name", "Grade"};
        String fileIn2 = "src/main/resources/input_2.csv";
        String fileOut2 = "src/main/resources/solution_2.csv";

        Creator2 creator2 = new Creator2(fileIn2);
        creator2.create();
        List<Evaluation> evaluations = creator2.getData(); // Se obtiene la lista de evaluaciones
        Report2 report = new Report2(evaluations);
        CSVwritter csvWritter2 = new CSVwritter(header2, fileOut2, report.getFileData());
        csvWritter2.write(",");


        // ENTREGA 3 //

        String[] header3 = {"Subject_Name","Criteria_Type","Criteria_Value","Evaluation_Name"};
        String fileIn3 = "src/main/resources/input_3.csv";
        String fileOut3 = "src/main/resources/solution_3.csv";





    }
}
