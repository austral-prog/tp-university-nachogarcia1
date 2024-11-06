package com.university.creators;

import com.university.course.Course;
import com.university.csv.CSVreader;
import com.university.student.Student;

import java.util.*;

import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;

public class Creator1 implements Creator<Student> {  // Especificamos el tipo como Student

    private String fileName;

    public Creator1(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void create() {
        try {
            CSVreader csvreader = new CSVreader(fileName);
            csvreader.read(",");
            List<String[]> allData = csvreader.getData();

            for (String[] data : allData) {
                if (data.length != 0) { //si quedan datos por leer

                    String subject = data[1];
                    String studentName = data[2];
                    String studentEmail = data[3];

                    // Verificamos si el estudiante ya existe en el mapa
                    Student student = studentByName.get(studentName);

                    if (student != null) {

                        Student newStudent = new Student(studentName, studentEmail);
                        Course newcourse = new Course(subject);
                        student.addSubject(subject);
                        coursesbystudent.get(newStudent).add(newcourse);
                        // Si ya existe, agregamos la asignatura
                    }
                    else {

                        Student newStudent = new Student(studentName, studentEmail);
                        Course newcourse = new Course(subject);

                        newStudent.addSubject(subject);
                        studentByName.put(studentName, newStudent);
                        coursesbystudent.put(newStudent, new ArrayList<>());
                        coursesbystudent.get(newStudent).add(newcourse);
                        // Si no existe, lo creamos y lo agregamos al mapa
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getData() {
        return new ArrayList<>(studentByName.values());
    }
}
