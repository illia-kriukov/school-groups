package se.school.groups.dto;

import se.school.groups.dto.student.StudentDto;

import java.util.List;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public class SubjectDto {

    private Long id;

    private String name;

    private GradeLevelDto gradeLevel;

    private SubjectTypeDto subjectType;

    private List<StudentDto> student;

    private List<StudentDto> unplacedStudent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeLevelDto getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevelDto gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public SubjectTypeDto getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectTypeDto subjectType) {
        this.subjectType = subjectType;
    }

    public List<StudentDto> getStudent() {
        return student;
    }

    public void setStudent(List<StudentDto> student) {
        this.student = student;
    }

    public List<StudentDto> getUnplacedStudent() {
        return unplacedStudent;
    }

    public void setUnplacedStudent(List<StudentDto> unplacedStudent) {
        this.unplacedStudent = unplacedStudent;
    }

}