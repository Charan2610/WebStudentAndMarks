package com.StudentMarkWeb.Services;


import com.StudentMarkWeb.Models.Student;
import com.StudentMarkWeb.Models.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient( name="student-Api",url = "${student-Api}")
public interface StudentApi {

    @GetMapping("/allStudents")
    List<Object> getAllStudent();


    @PostMapping("/addStudent")
   public Student addStudent(@RequestBody  Student student);

    @GetMapping("/student/{id}")
   public Student getStudentId( @PathVariable("id") int id);

    @PutMapping("/updateStudent")
    Student updateStudent(@RequestBody Student student);

    @GetMapping("/user/{email}/{password}")
    Users getUser(@PathVariable("email") String email,@PathVariable("password") String password);

    @DeleteMapping("/delete/{id}")
    void deleteStudent(@PathVariable("id") int id);
}
