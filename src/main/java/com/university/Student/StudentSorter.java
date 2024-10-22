package com.university.Student;

import java.util.Comparator;
import java.util.List;

public class StudentSorter {

    private List<Student> orderedStudents;

    public StudentSorter(List<Student> students) {

            students.sort(Comparator.comparing(Student::getName));
            this.orderedStudents = students;
        }
        public List<Student> getOrderedStudents() {
            return orderedStudents;
        }
    }