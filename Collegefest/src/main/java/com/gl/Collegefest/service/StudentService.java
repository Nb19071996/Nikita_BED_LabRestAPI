package com.gl.Collegefest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Collegefest.entity.Student;
import com.gl.Collegefest.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        List<Student> books= studentRepository.findAll();
        return books;
    }

    public Student findById(int theId) {
        return studentRepository.findById(theId).get();
    }

    public void save(Student theStudent) {
    	studentRepository.save(theStudent);

    }

    public void deleteById(int theId) {
    	studentRepository.deleteById(theId);
    }


}
