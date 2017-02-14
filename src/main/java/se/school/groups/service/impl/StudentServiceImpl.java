package se.school.groups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.school.groups.converter.StudentToStudentDto;
import se.school.groups.dao.StudentDao;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.model.Student;
import se.school.groups.service.StudentService;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentToStudentDto studentConverter;

    public StudentDto getStudent(Long studentId) {
        Student student = studentDao.findOne(studentId);
        return student != null ? studentConverter.apply(student) : null;
    }

}