package se.school.groups.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.school.groups.dto.group.GroupTemplateCreateDto;
import se.school.groups.dto.group.StudyGroupDto;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/13/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface GroupController {

    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    StudyGroupDto getStudyGroup(@PathVariable("groupId") Long groupId);

    @RequestMapping(value = "/group/template", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    void createGroupsTemplate(@RequestBody @Valid GroupTemplateCreateDto groupTemplateCreateDto);

}