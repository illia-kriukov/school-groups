package se.school.groups.dto.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import se.school.groups.dto.GradeLevelDto;
import se.school.groups.dto.StudyClassDto;

/**
 * Created by illia.kriukov on 1/13/17.
 */
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private GradeLevelDto gradeLevel;

    private StudyClassDto studyClass;

    public StudentDto(Long id, String firstName, String lastName, String email,
                      GradeLevelDto gradeLevel, StudyClassDto studyClass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gradeLevel = gradeLevel;
        this.studyClass = studyClass;
    }

    public StudentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StudentDto that = (StudentDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(firstName, that.firstName)
                .append(lastName, that.lastName)
                .append(email, that.email)
                .append(gradeLevel, that.gradeLevel)
                .append(studyClass, that.studyClass)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(email)
                .append(gradeLevel)
                .append(studyClass)
                .toHashCode();
    }

}