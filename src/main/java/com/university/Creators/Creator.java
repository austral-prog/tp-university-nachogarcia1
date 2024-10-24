package com.university.Creators;

import com.university.CSV.CSVreader;
import com.university.Student.Student;

import java.util.*;

public class Creator {
    private Map<String, Student> studentMap = new HashMap<>();

    public Creator(String fileName) {
        try {
            CSVreader csvreader = new CSVreader(fileName);
            csvreader.read(",");
            List<String[]> allData = csvreader.getData();

            for (String[] data : allData) {
                if (data.length >= 4) {
                    String subject = data[1];
                    String studentName = data[2];
                    String studentEmail = data[3];

                    // Verificamos si el estudiante ya existe en el mapa
                    Student student = studentMap.get(studentName);

                    if (student != null) {
                        student.addSubject(subject); // Si ya existe, agregamos la asignatura
                    } else {
                        // Si no existe, lo creamos y lo agregamos al mapa
                        Student newStudent = new Student(studentName, studentEmail);
                        newStudent.addSubject(subject);
                        studentMap.put(studentName, newStudent);
                    }
                } else {
                    System.out.println("Fila inválida en CSV: " + Arrays.toString(data));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentList() {
        return new ArrayList<>(studentMap.values());
    }
}
