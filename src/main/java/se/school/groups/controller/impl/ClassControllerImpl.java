package se.school.groups.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.school.groups.controller.ClassController;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.service.ClassService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class ClassControllerImpl implements ClassController {

    @Autowired
    private ClassService classService;

    @Override
    @RequestMapping(value = "/class/{classId}", method = RequestMethod.GET)
    public StudyClassDto getStudyClass(@PathVariable("classId") Long classId) {
        return classService.getStudyClass(classId);
    }

}