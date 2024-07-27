package com.arclaudio.sms.service.impl;

import com.arclaudio.sms.dto.StudentDTO;
import com.arclaudio.sms.entity.Student;
import com.arclaudio.sms.mapper.StudentMapper;
import com.arclaudio.sms.repository.StudentRepository;
import com.arclaudio.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::mapToStudentDTO)
                .collect(Collectors.toList());

    }
}