package se.school.groups.service;

import se.school.groups.dto.student.StudentCreateDto;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface AccountService {

    void createStudent(StudentCreateDto dto);

}