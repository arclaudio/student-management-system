package com.arclaudio.sms.controller;

import com.arclaudio.sms.dto.StudentDTO;
import com.arclaudio.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

}
