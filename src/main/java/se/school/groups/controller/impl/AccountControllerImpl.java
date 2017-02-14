package se.school.groups.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.school.groups.controller.AccountController;
import se.school.groups.dto.student.StudentCreateDto;
import se.school.groups.service.AccountService;

import javax.validation.Valid;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;

    @Override
    @RequestMapping(value = "account/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentCreateDto studentCreateDto) {
        accountService.createStudent(studentCreateDto);
    }

}