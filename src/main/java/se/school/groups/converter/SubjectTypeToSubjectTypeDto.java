package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import se.school.groups.dto.SubjectTypeDto;
import se.school.groups.model.SubjectType;

/**
 * Convert SubjectType model to SubjectTypeDto.
 *
 * Created by illia.kriukov on 1/15/17.
 */
@Component
public class SubjectTypeToSubjectTypeDto implements Function<SubjectType, SubjectTypeDto> {

    @Override
    public SubjectTypeDto apply(SubjectType subjectType) {
        SubjectTypeDto subjectTypeDto = new SubjectTypeDto();
        BeanUtils.copyProperties(subjectType, subjectTypeDto);
        return subjectTypeDto;
    }

}