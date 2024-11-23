package com.university;

import com.university.cli.CLI;
import com.university.cli.CRUDRepository;
import com.university.cli.repos.RepoCourse;
import com.university.cli.repos.RepoEvaluation;
import com.university.cli.repos.RepoStudent;
import com.university.cli.UniversityCLI;

import com.university.evaluation.Evaluation;
import com.university.mainobjects.Course;
import com.university.mainobjects.Student;

// CLI //

public class RunCLI {
    public static void main(String[] args) {

        CRUDRepository<Student> studentRepo = new RepoStudent();
        CRUDRepository<Course> courseRepo = new RepoCourse();
        CRUDRepository<Evaluation> evaluationRepo = new RepoEvaluation();
        CLI cli = new UniversityCLI();
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});





    }
}
