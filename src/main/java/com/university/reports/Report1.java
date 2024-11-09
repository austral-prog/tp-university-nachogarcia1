package com.university.reports;

import com.university.mainobjects.Student;
import com.university.sorters.StudentSorter;

import java.util.ArrayList;
import java.util.List;



public class Report1 {

    private static List<String[]> fileData = new ArrayList<>();

    public Report1(List<Student> students) {
        StudentSorter studentSorter = new StudentSorter(students);
        List<Student> orderedStudents = studentSorter.getOrderedStudents();
        for (Student student : orderedStudents) {
            String[] row = {student.getName(), String.valueOf(student.getSubjectsamount())};
            fileData.add(row);
        }
    }
    public  List<String[]> getFileData() {
        return fileData;
    }

    public static List<String> getStudent() {
        List<String> students = new ArrayList<>();
        for (String[] row : fileData) {
            students.add(row[0]);
        }
        return students;
    }

    public static List<Integer> getCoursecountofstudent() {
        List<Integer> coursecountofstudent = new ArrayList<>();
        for (String[] row : fileData) {
            coursecountofstudent.add(Integer.parseInt(row[1]));
        }
        return coursecountofstudent;
    }


}


