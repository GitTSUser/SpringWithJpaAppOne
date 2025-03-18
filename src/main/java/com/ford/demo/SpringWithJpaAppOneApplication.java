package com.ford.demo;

import com.ford.demo.entity.Student;
import com.ford.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringWithJpaAppOneApplication  implements CommandLineRunner {

    @Autowired
    IStudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringWithJpaAppOneApplication.class, args);
    }

    public void testSavingStudent(){
    Student s1=new Student(1,"ArunKumar","CSE","arun@yahoo.com","044-235-758");
        Student s2=new Student(2,"VarunKumar","IT","varun@gmail.com","044-335-789");
        Student s3=new Student(3,"CharunKumar","EEE","charun@yahoo.com","040-435-789");
        Student s4=new Student(4,"TarunKumar","ECE","tarun@rediff.com","041-635-789");
        Student savedStudent=studentRepository.saveStudent(s1);
        Student savedStudent2=studentRepository.saveStudent(s2);
        Student savedStudent3=studentRepository.saveStudent(s3);
        Student savedStudent4=studentRepository.saveStudent(s4);

        if(savedStudent!=null){
            System.out.println("Student details saved in DB!");
        }else{
            System.out.println("Student details not saved in DB!");
        }
    }

    public void testFindStudentById(){

        Student student=studentRepository.getStudent(3);
        System.out.println("----Student Found By ID----");
        System.out.println(student);
    }

    public void testFindAllStudents(){

        List<Student> studentList=studentRepository.getAllStudents();

        System.out.println("----ALL STUDENTS---");

        studentList.forEach(System.out::println);



    }
    @Override
    public void run(String... args) throws Exception {

        testSavingStudent();
        testFindStudentById();
        testFindAllStudents();
    }
}
