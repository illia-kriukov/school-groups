package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import se.school.groups.dto.GradeLevelDto;
import se.school.groups.model.GradeLevel;

/**
 * Convert GradeLevel model to GradeLevelDto.
 *
 * Created by illia.kriukov on 1/13/17.
 */
@Component
public class GradeLevelToGradeLevelDto implements Function<GradeLevel, GradeLevelDto> {

    @Override
    public GradeLevelDto apply(GradeLevel gradeLevel) {
        GradeLevelDto gradeLevelDto = new GradeLevelDto();
        BeanUtils.copyProperties(gradeLevel, gradeLevelDto);
        return gradeLevelDto;
    }

}