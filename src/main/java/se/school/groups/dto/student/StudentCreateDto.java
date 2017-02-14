package se.school.groups.dto.student;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Dto for creating new student.
 *
 * Created by illia.kriukov on 1/13/17.
 */
public class StudentCreateDto {

    @NotNull(message = "First name should not be empty.")
    @Pattern(regexp = "^[a-zA-Z- ]*$", message = "First name can contain only letters and '-'.")
    private String firstName;

    @NotNull(message = "Last name should not be empty.")
    @Pattern(regexp = "^[a-zA-Z- ]*$", message = "Last name can contain only letters and '-'.")
    private String lastName;

    @NotNull(message = "Email should not be empty.")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "Incorrect email format.")
    private String email;

    @NotNull(message = "Password should not be empty.")
    @Pattern(regexp = "^[\\d\\w@#$%\\{\\}\\(\\)]{6,20}$", message = "Password should be at least 6 symbols.")
    private String password;

    @NotNull(message = "Grade level should not be empty.")
    private Long gradeLevelId;

    @NotNull(message = "Study class should not be empty.")
    private Long studyClassId;

    public StudentCreateDto(String firstName, String lastName, String email, String password,
                            Long gradeLevelId, Long studyClassId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gradeLevelId = gradeLevelId;
        this.studyClassId = studyClassId;
    }

    public StudentCreateDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Long gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public Long getStudyClassId() {
        return studyClassId;
    }

    public void setStudyClassId(Long studyClassId) {
        this.studyClassId = studyClassId;
    }

}