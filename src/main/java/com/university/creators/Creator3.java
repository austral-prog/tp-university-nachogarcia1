package com.university.creators;

import com.university.csv.CSVreader;
import com.university.student.Student;
import com.university.course.Course;

import static com.university.University.coursesbystudent;

import java.util.*;

public class Creator3 implements Creator {

    private String filename;
    private List<String[]> data = new ArrayList<>();
    private List<String[]> results = new ArrayList<>(); // Para almacenar los resultados del reporte

    public Creator3(String filename) {
        this.filename = filename;
    }

    @Override
    public void create() {
        CSVreader reader = new CSVreader(filename);
        reader.read(",");
        data = reader.getData();

        // Procesamos los datos del CSV y obtenemos las calificaciones y el estado
        for (String[] row : data) {
            String subjectName = row[0];
            String[] evaluationNames = Arrays.copyOfRange(row, 3, row.length); // Evaluaciones

            for (Student student : coursesbystudent.keySet()) {
                for (Course course : coursesbystudent.get(student)) {
                    if (subjectName.equals(course.getSubject())) {
                        // Obtener la calificación final del curso
                        double finalGrade = course.getFinalGrade();
                        String approvalStatus = getApprovalStatus(finalGrade, row[1], Double.parseDouble(row[2]));

                        // Agregar al resultado con nombre de estudiante, materia y estado de aprobación
                        results.add(new String[]{student.getName(), subjectName, approvalStatus});
                    }
                }
            }
        }
    }

    // Método para determinar si el estudiante aprueba o no
    private String getApprovalStatus(double grade, String criteriaType, double criteriaValue) {
        switch (criteriaType) {
            case "AVERAGE_ABOVE_VALUE":
                return grade >= criteriaValue ? "Approved" : "Not Approved";
            case "MAX_ABOVE_VALUE":
                return grade >= criteriaValue ? "Approved" : "Not Approved";
            case "MIN_ABOVE_VALUE":
                return grade >= criteriaValue ? "Approved" : "Not Approved";
            default:
                return "Not Calculated";
        }
    }

    @Override
    public List<String[]> getData() {
        return results; // Devuelve los resultados generados
    }
}
