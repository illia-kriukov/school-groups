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
import se.school.groups.converter.GradeLevelToGradeLevelDto;
import se.school.groups.converter.StudentToStudentDto;
import se.school.groups.converter.StudyClassToStudyClassDto;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.SubjectDao;
import se.school.groups.exception.AccountException;
import se.school.groups.exception.StudentException;
import se.school.groups.exception.SubjectException;
import se.school.groups.model.Subject;
import se.school.groups.service.impl.SubjectServiceImpl;
import se.school.groups.util.StudentTestUtil;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SubjectServiceTest {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentDao studentDao;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = SubjectException.class)
    public void testAddStudentToSubjectWrongSubject() {
        when(subjectDao.findOne(isA(Long.class))).thenReturn(null);
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        subjectService.addStudentToSubject(SUBJECT_ID, StudentTestUtil.STUDENT_ID);
        expectedException.expectMessage("Such subject doesn't exists.");
    }

    @Test(expected = AccountException.class)
    public void testAddStudentToSubjectWrongStudent() {
        when(subjectDao.findOne(isA(Long.class))).thenReturn(createSubject());
        when(studentDao.findOne(isA(Long.class))).thenReturn(null);
        subjectService.addStudentToSubject(SUBJECT_ID, StudentTestUtil.STUDENT_ID);
        expectedException.expectMessage("Such student doesn't exists.");
    }

    @Test(expected = StudentException.class)
    public void testAddStudentToSubjectWithBiggerGradeLevel() {
        when(subjectDao.findOne(isA(Long.class))).thenReturn(createSubjectWithLevel2());
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        subjectService.addStudentToSubject(SUBJECT_ID, StudentTestUtil.STUDENT_ID);
        expectedException.expectMessage("Student grade level should be the same with subject.");
    }

    @Test(expected = StudentException.class)
    public void testAddStudentToSubjectAlreadyAdded() {
        when(subjectDao.findOne(isA(Long.class))).thenReturn(createSubjectWithStudent(StudentTestUtil.STUDENT_ID));
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        subjectService.addStudentToSubject(SUBJECT_ID, StudentTestUtil.STUDENT_ID);
        expectedException.expectMessage("This student already took such subject.");
    }

    @Test
    public void testAddStudentToSubject() {
        when(subjectDao.findOne(isA(Long.class))).thenReturn(createSubject());
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        subjectService.addStudentToSubject(SUBJECT_ID, StudentTestUtil.STUDENT_ID);
        verify(subjectDao, times(1)).save(isA(Subject.class));
        verify(groupService, times(1)).addStudentToGroup(isA(Long.class), isA(Long.class));
    }

    @Configuration
    static class SubjectServiceTestContextConfiguration {
        @Bean
        public SubjectService subjectService() {
            return new SubjectServiceImpl();
        }

        @Bean
        public GroupService groupService() {
            return mock(GroupService.class);
        }

        @Bean
        public SubjectDao subjectDao() {
            return mock(SubjectDao.class);
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