package com.university.creators;

import com.university.mainobjects.Course;
import com.university.csv.CSVreader;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEvaluations.FinalPracticalWork;
import com.university.evaluation.typesOfEvaluations.OralExam;
import com.university.evaluation.typesOfEvaluations.PracticalWork;
import com.university.evaluation.typesOfEvaluations.WrittenExam;
import com.university.mainobjects.Student;

import java.util.ArrayList;
import java.util.List;




import static com.university.University.coursesbystudent;
import static com.university.University.studentByName;

public class Creator2 implements Creator<Evaluation> {  // Especificamos el tipo como Evaluation


    private String filename;

    public Creator2(String filename) {
        this.filename = filename;
    }

    @Override
    public void create() {
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

                Student student = studentByName.get(studentName);
                if (student == null) {
                    student = new Student(studentName, "email");
                    studentByName.put(studentName, student);
                }

                List<Course> courses = coursesbystudent.computeIfAbsent(student, k -> new ArrayList<>());

                Course course = null;
                for (Course c : courses) {
                    if (c.getSubject().equals(subject)) {
                        course = c;
                        break;
                    }
                }

                if (course == null) {
                    course = new Course(subject);
                    courses.add(course);
                }

                if (!containsEvaluation(course.getEvaluations(), evaluationName)) {
                    switch (evaluationType) {
                        case "WRITTEN_EXAM" -> course.getEvaluations().add(new WrittenExam(studentName, subject, evaluationName, exerciseName, grade));
                        case "FINAL_PRACTICAL_WORK" -> course.getEvaluations().add(new FinalPracticalWork(studentName, subject, evaluationName, exerciseName, grade));
                        case "PRACTICAL_WORK" -> course.getEvaluations().add(new PracticalWork(studentName, subject, evaluationName, exerciseName, grade));
                        case "ORAL_EXAM" -> course.getEvaluations().add(new OralExam(studentName, subject, evaluationName, exerciseName, grade));
                    }
                }
            }
        }
    }

    @Override
    public List<Evaluation> getData() {
        List<Evaluation> evaluationsByCourse = new ArrayList<>();
        for (List<Course> courses : coursesbystudent.values()) {
            for (Course course : courses) {
                evaluationsByCourse.addAll(course.getEvaluations());
            }
        }
        return evaluationsByCourse;
    }

    private boolean containsEvaluation(List<Evaluation> evaluations, String evaluationName) {
        for (Evaluation eval : evaluations) {
            if (eval.getEvaluationName().equals(evaluationName)) {
                return true;
            }
        }
        return false;
    }




}



