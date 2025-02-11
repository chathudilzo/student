package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
private final StudentRepository studentRepository;

@Autowired
public StudentService(StudentRepository studentRepository){
    this.studentRepository=studentRepository;
}


public List<Student> getStudents(){
    return studentRepository.findAll();
}

public void addStudent(Student student){
    Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());

    if(studentOptional.isPresent()){
        throw new IllegalStateException("Email already exists");
    }
    studentRepository.save(student);
}

public void deleteStudent(Long studentId){
    boolean exists=studentRepository.existsById(studentId);

    if(!exists){
        throw new IllegalStateException("Student with id"+studentId+"does not exists!");
    }
    studentRepository.deleteById(studentId);
}

}
