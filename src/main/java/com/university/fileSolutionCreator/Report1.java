package com.university.fileSolutionCreator;


import com.university.student.Student;
import com.university.sorters.StudentSorter;

import java.util.ArrayList;
import java.util.List;



public class Report1 {

    private List<String[]> fileData = new ArrayList<>();

    public Report1(List<Student> students) {
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


