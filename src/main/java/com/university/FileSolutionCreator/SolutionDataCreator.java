package com.university.FileSolutionCreator;

import com.university.Student.Student;
import com.university.Student.StudentSorter;

import java.util.ArrayList;
import java.util.List;

public class SolutionDataCreator {

    private List<String[]> fileData = new ArrayList<>();

    public SolutionDataCreator(List<Student> students) {
        StudentSorter sorter = new StudentSorter(students);
        List<Student> orderedStudents = sorter.getOrderedStudents();
        for (Student student : orderedStudents) {
            String[] row = {student.getName(), String.valueOf(student.getCoursesAmount())};
            fileData.add(row);
        }
    }
    public List<String[]> getFileData() {
        return fileData;
    }
}