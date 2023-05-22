package com.student.demostudent.service;

import com.student.demostudent.model.Student;
import com.student.demostudent.model.StudentRequest;

import java.util.Optional;

public interface StudentService {
    public Student addStudent(StudentRequest student);
    public Optional<Student> getStudent(Long id);
    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
}
