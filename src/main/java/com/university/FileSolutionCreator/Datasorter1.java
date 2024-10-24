package com.university.FileSolutionCreator;


import com.university.Creators.Creator;
import com.university.Student.Student;
import com.university.Student.StudentSorter;

import java.util.ArrayList;
import java.util.List;



public class Datasorter1 {

    private List<String[]> fileData = new ArrayList<>();

    public Datasorter1(List<Student> students) {
        StudentSorter studentSorter = new StudentSorter(students);
        List<Student> orderedStudents = studentSorter.getOrderedStudents();
        for (Student student : orderedStudents) {
            String[] row = {student.getName(), String.valueOf(student.getSubjects())};
            fileData.add(row);
        }
    }
    public List<String[]> getFileData() {
        return fileData;
    }

}


