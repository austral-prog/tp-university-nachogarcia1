package com.university.cli.repos;

import com.university.cli.CRUDRepository;
import com.university.mainobjects.Student;
import java.util.HashMap;
import java.util.Map;

public class RepoStudent implements CRUDRepository<Student> {
    private final Map<Integer, Student> students = new HashMap<>();

    public RepoStudent() {

    }

    @Override
    public void create(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student read(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void delete(int id) {
        students.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }
}
