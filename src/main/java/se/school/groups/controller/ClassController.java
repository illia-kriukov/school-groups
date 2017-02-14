package se.school.groups.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.school.groups.dto.StudyClassDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface ClassController {

    @RequestMapping(value = "/class/{classId}", method = RequestMethod.GET)
    StudyClassDto getStudyClass(@PathVariable("classId") Long classId);

}