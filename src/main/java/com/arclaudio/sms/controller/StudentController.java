package com.arclaudio.sms.controller;

import com.arclaudio.sms.dto.StudentDTO;
import com.arclaudio.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    // handler method to handle list students request
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("student", studentDTO);
        return "create_student";
    }

    // handle method to save student form submit request
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") StudentDTO student){
        studentService.createStudent(student);
        return "redirect:/students";
    }
}
