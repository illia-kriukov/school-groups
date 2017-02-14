package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.model.StudyClass;

/**
 * Convert StudyClass model to StudyClassDto.
 *
 * Created by illia.kriukov on 1/14/17.
 */
@Component
public class StudyClassToStudyClassDto implements Function<StudyClass, StudyClassDto> {

    @Override
    public StudyClassDto apply(StudyClass studyClass) {
        StudyClassDto studyClassDto = new StudyClassDto();
        BeanUtils.copyProperties(studyClass, studyClassDto);
        return studyClassDto;
    }

}