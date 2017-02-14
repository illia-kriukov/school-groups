package se.school.groups.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.school.groups.controller.GroupController;
import se.school.groups.dto.group.GroupTemplateCreateDto;
import se.school.groups.dto.group.StudyGroupDto;
import se.school.groups.service.GroupService;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by illia.kriukov on 1/13/17.
 */
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class GroupControllerImpl implements GroupController {

    @Autowired
    private GroupService groupService;

    @Override
    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public StudyGroupDto getStudyGroup(@PathVariable("groupId") Long groupId) {
        return groupService.getStudyGroup(groupId);
    }

    @RequestMapping(value = "/group/template", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createGroupsTemplate(@RequestBody @Valid GroupTemplateCreateDto groupTemplateCreateDto) {
        groupService.createGroupsTemplate(groupTemplateCreateDto);
    }

}