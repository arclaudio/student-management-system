package com.arclaudio.sms.mapper;

import com.arclaudio.sms.dto.StudentDTO;
import com.arclaudio.sms.entity.Student;

public class StudentMapper {

    public static StudentDTO mapToStudentDTO(Student student){
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDTO studentDTO){
        return new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail()
        );
    }
}
