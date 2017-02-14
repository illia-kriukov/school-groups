package se.school.groups.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.school.groups.converter.GradeLevelToGradeLevelDto;
import se.school.groups.converter.StudentToStudentDto;
import se.school.groups.converter.StudyClassToStudyClassDto;
import se.school.groups.dao.StudentDao;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.service.impl.StudentServiceImpl;
import se.school.groups.util.StudentTestUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testGetStudent() {
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudentWithFullInfo());
        StudentDto expectedStudent = StudentTestUtil.createStudentDtoWithFullInfo();
        StudentDto actualStudent = studentService.getStudent(StudentTestUtil.STUDENT_ID);
        assertEquals("Students should be the same", expectedStudent, actualStudent);
    }

    @Configuration
    static class ClassServiceTestContextConfiguration {
        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }

        @Bean
        public StudentDao studentDao() {
            return mock(StudentDao.class);
        }

        @Bean
        public StudentToStudentDto studentConverter() {
            return new StudentToStudentDto();
        }

        @Bean
        public GradeLevelToGradeLevelDto gradeLevelConverter() {
            return new GradeLevelToGradeLevelDto();
        }

        @Bean
        public StudyClassToStudyClassDto studyClassConverter() {
            return new StudyClassToStudyClassDto();
        }
    }

}