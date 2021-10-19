package com.StudentMarkWeb.Services;

import com.StudentMarkWeb.Models.StudentMark;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Service
@FeignClient(name="mark-Api", url="${marks-Api}")
public interface MarksApi {

    @GetMapping("student/{stuId}")
    List<Object> getAllMarks(@PathVariable("stuId") String stuId);

    @GetMapping("Mark/{id}")
   StudentMark getStudentMark(@PathVariable("id") int id);

    @PostMapping("/addMark")
    StudentMark addStudentMark(StudentMark studentMark);

    @PutMapping("/updateMark")
    StudentMark updateMark(StudentMark studentMark);

    @DeleteMapping("/deleteMark/{id}")
    void deleteMark(@PathVariable("id") int id);


}
