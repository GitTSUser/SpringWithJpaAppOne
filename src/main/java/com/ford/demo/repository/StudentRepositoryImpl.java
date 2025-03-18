package com.ford.demo.repository;

import com.ford.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class StudentRepositoryImpl implements IStudentRepository{

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        log.info("Saving student: "+student);
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        log.info("Updating student:"+student);
        entityManager.merge(student);
        return student;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        if(getStudent(studentId) != null) {
            entityManager.remove(getStudent(studentId));
            log.info("Deleted student: "+studentId);
            return true;
        }
        return false;
    }

    @Override
    public Student getStudent(int studentId) {
        return  entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> typedQuery=entityManager.createQuery("select s from Student s",Student.class);
        return typedQuery.getResultList();
    }
}