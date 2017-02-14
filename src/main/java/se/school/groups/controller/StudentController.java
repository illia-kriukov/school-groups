package se.school.groups.controller;

import org.springframework.web.bind.annotation.*;
import se.school.groups.dto.student.StudentDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface StudentController {

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    StudentDto getStudent(@PathVariable("studentId") Long studentId);

}