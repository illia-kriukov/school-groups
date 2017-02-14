package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.school.groups.dto.group.StudyGroupDto;
import se.school.groups.model.StudyGroup;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Convert StudyGroup model to StudyGroupDto.
 *
 * Created by illia.kriukov on 1/14/17.
 */
@Component
public class StudyGroupToStudyGroupDto implements Function<StudyGroup, StudyGroupDto> {

    @Autowired
    private GradeLevelToGradeLevelDto gradeLevelConverter;

    @Autowired
    private StudyClassToStudyClassDto studyClassConverter;

    @Autowired
    private SubjectToSubjectDto subjectConverter;

    @Autowired
    private StudentToStudentDto studentConverter;

    @Override
    public StudyGroupDto apply(StudyGroup studyGroup) {
        StudyGroupDto studyGroupDto = new StudyGroupDto();
        BeanUtils.copyProperties(studyGroup, studyGroupDto);

        studyGroupDto.setGradeLevel(gradeLevelConverter.apply(studyGroup.getGradeLevel()));
        studyGroupDto.setStudyClass(studyClassConverter.apply(studyGroup.getStudyClass()));
        studyGroupDto.setSubject(studyGroup.getSubject().stream().map(s -> subjectConverter.apply(s))
                .collect(Collectors.toList()));
        studyGroupDto.setStudent(studyGroup.getStudent().stream().map(s -> studentConverter.apply(s))
                .collect(Collectors.toList()));

        return studyGroupDto;
    }

}