package se.school.groups.service;

import se.school.groups.dto.student.StudentDto;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface StudentService {

    StudentDto getStudent(Long studentId);

}