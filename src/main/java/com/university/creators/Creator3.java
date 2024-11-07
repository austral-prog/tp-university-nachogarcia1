package com.university.creators;
import com.university.csv.CSVreader;
import com.university.mainobjects.Student;
import com.university.mainobjects.Course;


import static com.university.University.coursesbystudent;

import java.util.*;



public class Creator3 implements Creator {

    private String filename;
    private List<String[]> data = new ArrayList<>();
    private Set<String[]> results = new HashSet<>();
    private List<String[]> evaluations = new ArrayList<>();

    public Creator3(String filename) {
        this.filename = filename;
    }

    @Override
    public void create() {
        CSVreader reader = new CSVreader(filename);
        reader.read(",");
        data = reader.getData();

        for (String[] row : data) {
            if (row.length >= 3) {
                String subjectName = row[0];
                String criteriaType = row[1];
                double criteriaValue;

                try {
                    criteriaValue = Double.parseDouble(row[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido en el valor del criterio: " + Arrays.toString(row));
                    continue;
                }

                for (Student student : coursesbystudent.keySet()) {
                    for (Course course : coursesbystudent.get(student)) {
                        if (subjectName.equals(course.getSubject())) {
                            double finalGrade = course.getFinalGrade();
                            String approvalStatus = getApprovalStatus(finalGrade, criteriaType, criteriaValue);

                            if (approvalStatus != null) {
                                results.add(new String[]{student.getName(), subjectName, approvalStatus});
                                evaluations.add(new String[]{student.getName(), subjectName, approvalStatus});
                            }
                        }
                    }
                }
            } else {
            }
        }
    }

    private String getApprovalStatus(double grade, String criteriaType, double criteriaValue) {
        switch (criteriaType) {
            case "AVERAGE_ABOVE_VALUE":
            case "MAX_ABOVE_VALUE":
            case "MIN_ABOVE_VALUE":
                return grade >= criteriaValue ? "Approved" : "Not Approved";
            default:
                return null;
        }
    }

    @Override
    public List<String[]> getData() {
        return new ArrayList<>(results);
    }

    public List<String[]> getEvaluations() {
        return evaluations;
    }
}
