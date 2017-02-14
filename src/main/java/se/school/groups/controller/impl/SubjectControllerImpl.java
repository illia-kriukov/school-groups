package se.school.groups.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.school.groups.controller.SubjectController;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.service.SubjectService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class SubjectControllerImpl implements SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Override
    @RequestMapping(value = "/subject/{subjectId}/student/{studentId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addStudentToSubject(@PathVariable("subjectId") Long subjectId, @PathVariable("studentId") Long studentId) {
        subjectService.addStudentToSubject(subjectId, studentId);
    }

    @Override
    @RequestMapping(value = "/subject/{subjectId}/unplaced-students", method = RequestMethod.GET)
    public List<StudentDto> getUnplacedStudents(@PathVariable("subjectId") Long subjectId) {
        return subjectService.listUnplacedStudents(subjectId);
    }

}