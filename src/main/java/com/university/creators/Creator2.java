package com.university.creators;

import com.university.csv.CSVreader;
import com.university.evaluation.Assessment;
import com.university.student.Student;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;

public class Creator2 {


    public Creator2(String filename) {
        CSVreader reader = new CSVreader(filename);
        reader.read(",");
        List<String[]> allData = reader.getData();

        for (String[] data : allData) {
            if (data.length != 0) {


                String studentname = data[0];
                String subject = data[1];
                String evaluationType = data[2];
                String evaluationName = data[3];
                String exerciseName = data[4];
                String grade = data[5];

                if (coursesbystudent.containsKey(studentname)) {
                    Assessment newAssesment = new Assessment( studentname,  subject,  evaluationName,  exerciseName,  grade) {



                }


            }
        }

    }
}
