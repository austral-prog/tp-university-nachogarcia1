package com.university.Creators;
import com.university.Course.Course;
import com.university.Student.Student;
import com.university.CSV.CSVreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Creator_1 {

    private static HashMap<String, Student> studentMap = new HashMap<>();
    private static HashMap<String, Course> courseMap = new HashMap<>();

    public Creator_1(String fileName) {
        CSVreader csvReader = new CSVreader(fileName);
        csvReader.read(",");
        List<String[]> allData = csvReader.getData();
        for (String[] data : allData) {
            String classroom = data[0];
            String subject = data[1];
            String studentName = data[2];
            String studentEmail = data[3];

            Course course = courseMap.computeIfAbsent(subject, k -> new Course(subject));
            course.addClassroom(classroom);

            Student student = studentMap.computeIfAbsent(studentName, k -> new Student(studentName, studentEmail));
            student.addCourse(course.getSubject(), classroom);
        }
    }
    public List<Student> getstudentlist(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.addAll(studentMap.values());
        return studentsList;
    }
    public List<Course> getCoursesList(){
        List<Course> courseList = new ArrayList<>();
        courseList.addAll(courseMap.values());
        return courseList;
    }

}