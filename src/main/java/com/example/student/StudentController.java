package com.example.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }
}
//POST http://localhost:8080/api/v1/student
//Content-Type: application/json
//
//{
//    "name": "John Doe",
//        "email": "john.doe@example.com",
//        "dob": "2000-01-01"
//}
