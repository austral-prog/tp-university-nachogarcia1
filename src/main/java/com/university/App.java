package com.university;

import com.university.csv.CSVwritter;
import com.university.creators.Creator;
import com.university.fileSolutionCreator.Report1;


public class App {

    public static void main(String[] args) {

        /*ENTREGA 1*/

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";



        CSVwritter csvWritter1 = new CSVwritter(header1, fileOut1, (new Report1(new Creator(fileIn1).getStudentList())).getFileData());
        csvWritter1.write(",");




    }
    public static void main_2(String[] args) {

        /*ENTREGA 2*/

    }



}



