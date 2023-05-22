package com.student.demostudent.controller;

import com.student.demostudent.model.Student;
import com.student.demostudent.model.StudentRequest;
import com.student.demostudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<Object> addStudent(@RequestBody StudentRequest studentRequest)
    {
        Student student = studentService.addStudent(studentRequest);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Optional<Student> student = studentService.getStudent(id);

        return student.isPresent()
                ? ResponseEntity.ok().body(student.get())
                : new ResponseEntity("Not Found", HttpStatus.NOT_FOUND );
    }

    @PutMapping("/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        Student updatedStudent = studentService.updateStudent(student);

        return ResponseEntity.ok().body(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);

        return ResponseEntity.ok().body("Deleted");
    }
}
