package com.university.creators;

import com.university.course.Course;
import com.university.csv.CSVreader;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.student.Student;


import java.util.List;

import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;

public class Creator2 {


    public Creator2(String filename) {
        CSVreader reader = new CSVreader(filename);
        reader.read(",");
        List<String[]> allData = reader.getData();

        for (String[] data : allData) {
            if (data.length != 0) {


                String studentName = data[0];
                String subject = data[1];
                String evaluationType = data[2];
                String evaluationName = data[3];
                String exerciseName = data[4];
                double grade = Double.parseDouble(data[5]);


                // Verificar si el estudiante existe en el mapa

                Student student = studentByName.get(studentName);
                if (student != null) {

                    // Obtener el curso del estudiante

                    List<Course> courses = coursesbystudent.get(student);
                    if (courses != null) {

                        // Verificar si el curso existe
                        Course course = null;
                        for (Course c : courses) {
                            if (c.getSubject().equals(subject)) {
                                course = c;
                                break; // Sale del bucle tan pronto como encuentra el curso
                            }
                        }


                        // Si el curso existe, crea la evaluación correspondiente
                        if (course != null) {
                            switch (evaluationType) {
                                case "WRITTEN_EXAM" -> {
                                    WrittenExam writtenExam = new WrittenExam(studentName, subject, evaluationName, exerciseName, grade);
                                    course.getWrittenExams().add(writtenExam);
                                }
                                case "FINAL_PRACTICAL_WORK" -> {
                                    FinalPracticalWork finalPracticalWork = new FinalPracticalWork(studentName, subject, evaluationName, exerciseName, grade);
                                    course.getFinalPracticalWorks().add(finalPracticalWork);
                                }
                                case "PRACTICAL_WORK" -> {
                                    PracticalWork practicalWork = new PracticalWork(studentName, subject, evaluationName, exerciseName, grade);
                                    course.getPracticalWorks().add(practicalWork);
                                }
                                case "ORAL_EXAM" -> {
                                    OralExam oralExam = new OralExam(studentName, subject, evaluationName, exerciseName, grade);
                                    course.getOralExams().add(oralExam);
                                }

                            }
                        }
                    }
                }
            }
        }
    }



}