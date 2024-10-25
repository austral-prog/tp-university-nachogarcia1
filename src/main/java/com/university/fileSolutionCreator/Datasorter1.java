package com.university.fileSolutionCreator;


import com.university.student.Student;
import com.university.student.StudentSorter;

import java.util.ArrayList;
import java.util.List;



public class Datasorter1 {

    private List<String[]> fileData = new ArrayList<>();

    public Datasorter1(List<Student> students) {
        StudentSorter studentSorter = new StudentSorter(students);
        List<Student> orderedStudents = studentSorter.getOrderedStudents();
        for (Student student : orderedStudents) {
            String[] row = {student.getName(), String.valueOf(student.getSubjectsamount())};
            fileData.add(row);
        }
    }
    public List<String[]> getFileData() {
        return fileData;
    }

}


