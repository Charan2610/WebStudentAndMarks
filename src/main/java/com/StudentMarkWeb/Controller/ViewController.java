package com.StudentMarkWeb.Controller;


import com.StudentMarkWeb.Models.Student;
import com.StudentMarkWeb.Models.Users;
import com.StudentMarkWeb.Services.StudentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller

@EnableFeignClients(basePackageClasses = StudentApi.class)
@RequestMapping("/students")
public class ViewController {


    private StudentApi studentApi;

    @Autowired
    public void setStudentApi(StudentApi studentApi) {
        this.studentApi = studentApi;
    }


    @GetMapping("")
    public String result(Model model){
     List<Object> students=   studentApi.getAllStudent();
     model.addAttribute("Students",students);
     return "Result";

    }

    @GetMapping("/addStudent")

    public String addStudent(){

        return "AddStudent";
    }

    @PostMapping("/Added")
    public String studentAdded( @ModelAttribute Student student ){

        Student su= studentApi.addStudent(student);
        return "redirect:/AddMark/"+ su.getId();
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id , Model model){
        Student student= studentApi.getStudentId(id);
        model.addAttribute("Student",student);
    return "updateStudent";
    }

    @PostMapping("/Updated")
    public String updatedStudent(@ModelAttribute Student student){
        studentApi.updateStudent(student);
        return "redirect:/students/";
    }

    @GetMapping("{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentApi.deleteStudent(id);
        return "redirect:/students/";
    }

//    @PostMapping("/LoginUser")
//    public String loggedUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
//
//      Users user= studentApi.getUser(email,password);
//      if(user!=null){
//          session.setAttribute("LoginUser",user);
//
//          return "redirect:/allStudents";
//      }else{
//          return "redirect:/";
//      }
//
//    }

//    @GetMapping("/logout")
//    public String logout( HttpSession session){
//       session.getAttribute("LoginUser");
//        session.removeAttribute("LoginUser");
//        return "redirect:/";
//
//    }

}
