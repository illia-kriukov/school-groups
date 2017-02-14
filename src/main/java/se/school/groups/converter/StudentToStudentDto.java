package se.school.groups.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.model.Student;

/**
 * Convert Student model to StudentDto.
 *
 * Created by illia.kriukov on 1/13/17.
 */
@Component
public class StudentToStudentDto implements Function<Student, StudentDto> {

    @Autowired
    private GradeLevelToGradeLevelDto gradeLevelConverter;

    @Autowired
    private StudyClassToStudyClassDto studyClassConverter;

    @Override
    public StudentDto apply(Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);

        studentDto.setGradeLevel(gradeLevelConverter.apply(student.getGradeLevel()));
        studentDto.setStudyClass(studyClassConverter.apply(student.getStudyClass()));

        return studentDto;
    }

}