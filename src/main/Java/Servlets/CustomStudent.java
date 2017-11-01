package Servlets;

import Entities.Student;

import javax.servlet.http.HttpServletRequest;

public class CustomStudent extends Custom {
    public Student add(HttpServletRequest req) {
        Student student = new Student();
        student.setRegNo(get(req, "studentregno"));
        student.setName(get(req, "studentname"));
        student.setYearOfStudy(get(req, "year"));
        student.setPassword(get(req, "password"));
        student.setContact(get(req, "contact"));
        student.setDepartment(get(req, "department"));
        student.setEmail(get(req, "email"));

        return student;
    }
}
