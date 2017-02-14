package se.school.groups.dto.group;

import se.school.groups.dto.GradeLevelDto;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.dto.SubjectDto;
import se.school.groups.dto.student.StudentDto;

import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public class StudyGroupDto {

    private Long id;

    private String name;

    private GradeLevelDto gradeLevel;

    private StudyClassDto studyClass;

    private Integer minSeats;

    private Integer maxSeats;

    private List<SubjectDto> subject;

    private List<StudentDto> student;

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

    public StudyClassDto getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClassDto studyClass) {
        this.studyClass = studyClass;
    }

    public Integer getMinSeats() {
        return minSeats;
    }

    public void setMinSeats(Integer minSeats) {
        this.minSeats = minSeats;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public List<SubjectDto> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectDto> subject) {
        this.subject = subject;
    }

    public List<StudentDto> getStudent() {
        return student;
    }

    public void setStudent(List<StudentDto> student) {
        this.student = student;
    }

}