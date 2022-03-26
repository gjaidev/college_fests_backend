package com.collegefests.controller;

import com.collegefests.model.Student;
import com.collegefests.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegefestsController {
    @Autowired
    StudentRepository repository;
    @GetMapping(value = "/getInfo")
    public String getCollegeInfo(){
        Student student = new Student();
        student.setId(Long.valueOf(1));
        student.setName("Jai");
        student.setAge(37);
        student.setNumber("777777");
        repository.save(student);
        return "Welcome";
    }
}
