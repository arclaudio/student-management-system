package com.arclaudio.sms.service;

import com.arclaudio.sms.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    void createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long studentId);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long studentId);
}
