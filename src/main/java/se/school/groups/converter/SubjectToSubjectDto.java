package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.school.groups.dto.SubjectDto;
import se.school.groups.model.Subject;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Convert Subject model to SubjectDto.
 *
 * Created by illia.kriukov on 1/15/17.
 */
@Component
public class SubjectToSubjectDto implements Function<Subject, SubjectDto> {

    @Autowired
    private GradeLevelToGradeLevelDto gradeLevelConverter;

    @Autowired
    private SubjectTypeToSubjectTypeDto studyTypeConverter;

    @Autowired
    private StudentToStudentDto studentConverter;

    @Override
    public SubjectDto apply(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        BeanUtils.copyProperties(subject, subjectDto);

        subjectDto.setGradeLevel(gradeLevelConverter.apply(subject.getGradeLevel()));
        subjectDto.setSubjectType(studyTypeConverter.apply(subject.getSubjectType()));
        subjectDto.setStudent(subject.getStudent().stream().map(s -> studentConverter.apply(s))
                .collect(Collectors.toList()));
        subjectDto.setUnplacedStudent(subject.getUnplacedStudent().stream().map(s -> studentConverter.apply(s))
                .collect(Collectors.toList()));

        return subjectDto;
    }

}