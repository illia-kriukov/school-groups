package se.school.groups.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.school.groups.dto.student.StudentDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface SubjectController {

    @RequestMapping(value = "/subject/{subjectId}/student/{studentId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    void addStudentToSubject(@PathVariable("subjectId") Long subjectId, @PathVariable("studentId") Long studentId);

    @RequestMapping(value = "/subject/{subjectId}/unplaced-students", method = RequestMethod.GET)
    List<StudentDto> getUnplacedStudents(@PathVariable("subjectId") Long subjectId);

}