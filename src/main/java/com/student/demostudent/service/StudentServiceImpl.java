package com.student.demostudent.service;

import com.student.demostudent.model.Student;
import com.student.demostudent.model.StudentRequest;
import com.student.demostudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(StudentRequest studentRequest) {

        Student student = new Student();
        student.setAge(studentRequest.getAge());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setGender(studentRequest.getGender());

        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student student) {

        Optional<Student> studentToUpdate = studentRepository.findById(student.getId());

        if(studentToUpdate.isPresent())
        {
            studentToUpdate.get().setAge(student.getAge());
            studentToUpdate.get().setFirstName(student.getFirstName());
            studentToUpdate.get().setLastName(student.getLastName());
            studentToUpdate.get().setGender(student.getGender());
        }

        return studentRepository.save(studentToUpdate.get());
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
