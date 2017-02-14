package se.school.groups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.school.groups.converter.StudyClassToStudyClassDto;
import se.school.groups.dao.StudyClassDao;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.model.StudyClass;
import se.school.groups.service.ClassService;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private StudyClassDao studyClassDao;

    @Autowired
    private StudyClassToStudyClassDto studyClassConverter;

    @Override
    public StudyClassDto getStudyClass(Long classId) {
        StudyClass studyClass = studyClassDao.findOne(classId);
        return studyClass != null ? studyClassConverter.apply(studyClass) : null;
    }

}