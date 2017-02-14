package se.school.groups.service;

import se.school.groups.dto.StudyClassDto;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface ClassService {

    StudyClassDto getStudyClass(Long classId);

}