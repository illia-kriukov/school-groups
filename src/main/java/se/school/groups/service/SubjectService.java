package se.school.groups.service;

import se.school.groups.dto.student.StudentDto;

import java.util.List;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public interface SubjectService {

    void addStudentToSubject(Long subjectId, Long studentId);

    List<StudentDto> listUnplacedStudents(Long subjectId);

}