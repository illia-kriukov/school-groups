package se.school.groups.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.school.groups.dto.student.StudentCreateDto;

import javax.validation.Valid;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface AccountController {

    @RequestMapping(value = "account/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    void createStudent(@RequestBody @Valid StudentCreateDto studentCreateDto);

}