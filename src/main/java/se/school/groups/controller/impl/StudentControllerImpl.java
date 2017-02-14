package se.school.groups.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.school.groups.controller.StudentController;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.service.StudentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    public StudentDto getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

}