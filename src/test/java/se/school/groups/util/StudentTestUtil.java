package se.school.groups.util;

import se.school.groups.dto.GradeLevelDto;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.dto.student.StudentCreateDto;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public class StudentTestUtil {

    public static final Long STUDENT_ID = 1L;
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "Test";
    public static final String EMAIL = "test@test.com";
    public static final String PASSWORD = "123456";

    public static Student createStudent(Long studentId) {
        Student student = new Student();
        student.setId(studentId);
        student.setGradeLevel(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        return student;
    }

    public static Student createStudentWithFullInfo() {
        Student student = new Student(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD,
                createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME), createStudyClass());
        student.setId(STUDENT_ID);
        return student;
    }

    public static StudentDto createStudentDtoWithFullInfo() {
        GradeLevelDto gradeLevelDto = new GradeLevelDto(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME);
        StudyClassDto studyClassDto = new StudyClassDto(STUDY_CLASS_ID, STUDY_CLASS_NAME);
        return new StudentDto(STUDENT_ID, FIRST_NAME, LAST_NAME, EMAIL, gradeLevelDto, studyClassDto);
    }

    public static List<Student> createStudentListWithStudent(Long studentId) {
        return new ArrayList<Student>() {{ add(createStudent(studentId)); }};
    }

    public static List<Student> createEmptyStudentList() {
        return new ArrayList<>();
    }

    public static StudentCreateDto createStudentCreateDto() {
        return new StudentCreateDto(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, GRADE_LEVEL_1_ID, STUDY_CLASS_ID);
    }

}