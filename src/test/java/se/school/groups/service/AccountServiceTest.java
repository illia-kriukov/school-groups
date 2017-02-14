package se.school.groups.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.school.groups.dao.GradeLevelDao;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.StudyClassDao;
import se.school.groups.exception.AccountException;
import se.school.groups.model.Student;
import se.school.groups.service.impl.AccountServiceImpl;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private GradeLevelDao gradeLevelDao;

    @Autowired
    private StudyClassDao studyClassDao;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = AccountException.class)
    public void testCreateStudentAlreadyExist() {
        when(gradeLevelDao.findOne(isA(Long.class))).thenReturn(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        when(studyClassDao.findOne(isA(Long.class))).thenReturn(createStudyClass());
        when(studentDao.findByEmail(isA(String.class))).thenReturn(createStudent(STUDENT_ID));
        accountService.createStudent(createStudentCreateDto());
        expectedException.expectMessage("Failed to create student '%s'. The student with such email already exists.");
    }

    @Test(expected = AccountException.class)
    public void testCreateStudentWrongGradeLevel() {
        when(gradeLevelDao.findOne(isA(Long.class))).thenReturn(null);
        when(studyClassDao.findOne(isA(Long.class))).thenReturn(createStudyClass());
        when(studentDao.findByEmail(isA(String.class))).thenReturn(createStudent(STUDENT_ID));
        accountService.createStudent(createStudentCreateDto());
        expectedException.expectMessage("Failed to create student '%s'. Wrong grade level.");
    }

    @Test(expected = AccountException.class)
    public void testCreateStudentWrongStudyClass() {
        when(gradeLevelDao.findOne(isA(Long.class))).thenReturn(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        when(studyClassDao.findOne(isA(Long.class))).thenReturn(null);
        when(studentDao.findByEmail(isA(String.class))).thenReturn(createStudent(STUDENT_ID));
        accountService.createStudent(createStudentCreateDto());
        expectedException.expectMessage("Failed to create student '%s'. Wrong study class.");
    }

    @Test
    public void testCreateStudent() {
        when(gradeLevelDao.findOne(isA(Long.class))).thenReturn(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        when(studyClassDao.findOne(isA(Long.class))).thenReturn(createStudyClass());
        when(studentDao.findByEmail(isA(String.class))).thenReturn(null);
        accountService.createStudent(createStudentCreateDto());
        verify(studentDao, times(1)).save(isA(Student.class));
    }

    @Configuration
    static class ClassServiceTestContextConfiguration {
        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }

        @Bean
        public StudentDao studentDao() {
            return mock(StudentDao.class);
        }

        @Bean
        public GradeLevelDao gradeLevelDao() {
            return mock(GradeLevelDao.class);
        }

        @Bean
        public StudyClassDao studyClassDao() {
            return mock(StudyClassDao.class);
        }
    }

}