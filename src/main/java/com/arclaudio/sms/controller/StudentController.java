package com.arclaudio.sms.controller;

import com.arclaudio.sms.dto.StudentDTO;
import com.arclaudio.sms.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    // handler method to handle list students request
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students); //String attribute name, then the actual value
        return "students"; // thymeleaf html template (same name with html file)
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
    public String saveStudent(@Valid @ModelAttribute("student") StudentDTO student,
                              BindingResult result,
                              Model model){

        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "create_student";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    // handler method for edit student request
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        model.addAttribute("student", studentDTO);
        return "edit_student";
    }

    // handler method for edit student form submit request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDTO);
            return "edit_student";
        }

        studentDTO.setId(studentId);
        studentService.updateStudent(studentDTO);
        return "redirect:/students";
    }
}
