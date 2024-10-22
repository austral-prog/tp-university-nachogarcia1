package com.university;

import com.university.CSV.CSVreader;
import com.university.CSV.CSVwritter;

import com.university.Course.Course;
import com.university.Creators.Creator_1;
import com.university.FileSolutionCreator.SolutionDataCreator;import com.university.Student.Student;

import java.util.List;


public class App {

    public static void main(String[] args) {

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";



        CSVwritter csvWritter1 = new CSVwritter(header1, fileOut1, (new SolutionDataCreator(new Creator_1(fileIn1).getstudentlist())).getFileData());
        csvWritter1.write(",");


    }

}



