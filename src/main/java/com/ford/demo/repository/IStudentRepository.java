package com.ford.demo.repository;

import com.ford.demo.entity.Student;

import java.util.List;

public interface IStudentRepository {
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public boolean deleteStudent(int studentId);
    public Student getStudent(int studentId);
    public List<Student> getAllStudents();
}
