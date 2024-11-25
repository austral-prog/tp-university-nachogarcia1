package com.university.cli.repos;

import com.university.cli.CRUDRepository;
import com.university.mainobjects.Course;

import java.util.HashMap;
import java.util.Map;




public class RepoCourse implements CRUDRepository<Course> {

    private final Map<Integer, Course> courses = new HashMap<>();

    public RepoCourse() {

    }

    @Override
    public void create(Course course) {
        if (courses.containsKey(course.getId())) {
            throw new IllegalArgumentException("Course ID " + course.getId() + " already exists.");
        }
        courses.put(course.getId(), course);
    }

    @Override
    public Course read(int id) {
        Course course = courses.get(id);
        if (course == null) {
            throw new RuntimeException("Course with ID1 " + id + " not found.");
        }
        return course;
    }

    @Override
    public void update(int id, Course course) {
        if (!courses.containsKey(id)) {
            throw new RuntimeException("Course with ID " + id + " not found.");
        }
        courses.put(id, course);

    }

    @Override
    public void delete(int id) {
        if (!courses.containsKey(id)) {
            throw new RuntimeException("Course with ID " + id + " not found.");
        }
        courses.remove(id);

    }

    @Override
    public String getIdentifier() {
        return "Course";
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
