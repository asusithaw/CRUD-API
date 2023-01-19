package com.susitha.rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student("Kamal", "Athapaththu");
        return student;
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kaml","Harappriya"));
        students.add(new Student("Namal","Rajapaksa"));
        students.add(new Student("Nimal","Ranketha"));
        return students;
    }

    @GetMapping("{firstName}/{lastName}")
    public Student getPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        Student student = new Student(firstName, lastName);
        return student;
    }

    @GetMapping("/student/query")
    public Student studentQueryParam(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName
    )    {
        return new Student(firstName, lastName);
    }
}
