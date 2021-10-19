package com.StudentMarkWeb.Controller;

import com.StudentMarkWeb.Models.Student;
import com.StudentMarkWeb.Models.StudentMark;
import com.StudentMarkWeb.Services.MarksApi;
import com.StudentMarkWeb.Services.StudentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@EnableFeignClients(basePackageClasses = MarksApi.class)
public class MarksController {


    private MarksApi marksApi;

    @Autowired
    public void setMarksApi(MarksApi marksApi) {
        this.marksApi = marksApi;
    }

    private StudentApi studentApi;

    @Autowired
    public void setStudentApi(StudentApi studentApi) {
        this.studentApi = studentApi;
    }

    @GetMapping("/Studentmark/{Sid}")
    public String getAllMark(@PathVariable("Sid") String Sid, Model model){
       List<Object> marks= marksApi.getAllMarks(Sid);
       model.addAttribute("Marks",marks);
       return "StudentMark";

    }

    @GetMapping("/addMark")
    public String markAdd(){

        return "AddMark";

    }

    @GetMapping("/AddMark/{id}")
    public String addMarked( @PathVariable("id") int id, Model model){
       Student student= studentApi.getStudentId(id);
        model.addAttribute("studentId",student.getId());

        return "AddMark";

    }

    @PostMapping("/AddedMark")
    public String addMark(@ModelAttribute StudentMark studentMark){
        marksApi.updateMark(studentMark);
        return "redirect:/Studentmark/"+ studentMark.getStudent_Id();

    }

    @GetMapping("/updateMark/{id}")
    public String getUpdateMark(@PathVariable("id") int id, Model model){
     StudentMark studentMark= marksApi.getStudentMark(id);
     model.addAttribute("StudentMark",studentMark);
     return "updateMark";
    }

    @PostMapping("/UpdatedMark")
    public String updateMark( @ModelAttribute StudentMark studentMark){
        marksApi.updateMark(studentMark);
        return "redirect:/Studentmark/"+ studentMark.getStudent_Id();

    }

    @GetMapping("/delete/{id}")
    public String deleteStudentMark(@PathVariable("id") int id){

        StudentMark studentMark= marksApi.getStudentMark(id);
        marksApi.deleteMark(id);
        return "redirect:/Studentmark/"+ studentMark.getStudent_Id();

    }
}
