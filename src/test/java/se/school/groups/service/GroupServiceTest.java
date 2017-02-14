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
import se.school.groups.dao.GroupsTemplateDao;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.StudyGroupDao;
import se.school.groups.dao.SubjectDao;
import se.school.groups.dto.group.GroupTemplateCreateDto;
import se.school.groups.exception.GroupException;
import se.school.groups.exception.SubjectException;
import se.school.groups.model.GroupsTemplate;
import se.school.groups.model.StudyGroup;
import se.school.groups.model.Subject;
import se.school.groups.service.impl.GroupServiceImpl;
import se.school.groups.converter.*;
import se.school.groups.util.GroupTestUtil;
import se.school.groups.util.StudentTestUtil;
import se.school.groups.util.SubjectTestUtil;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudyGroupDao studyGroupDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private GroupsTemplateDao groupsTemplateDao;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = GroupException.class)
    public void testAddStudentToGroupAlreadyAdded() {
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        when(subjectDao.findOne(isA(Long.class))).thenReturn(SubjectTestUtil.createSubject());
        when(studyGroupDao.findAllBySubject(isA(Subject.class))).thenReturn(GroupTestUtil.createGroupListWithStudent(StudentTestUtil.STUDENT_ID));
        groupService.addStudentToGroup(StudentTestUtil.STUDENT_ID, SubjectTestUtil.SUBJECT_ID);
        expectedException.expectMessage("Student already exist in the group for this subject.");
    }

    @Test(expected = SubjectException.class)
    public void testAddStudentToGroupAlreadyUnplaced() {
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        when(subjectDao.findOne(isA(Long.class))).thenReturn(SubjectTestUtil.createSubjectWithUnplacedStudent(StudentTestUtil.STUDENT_ID));
        when(studyGroupDao.findAllBySubject(isA(Subject.class))).thenReturn(
                GroupTestUtil.createGroupList(GroupTestUtil.createGroupWithSeats(GroupTestUtil.MIN_SEATS, GroupTestUtil.MIN_SEATS)));
        groupService.addStudentToGroup(StudentTestUtil.STUDENT_ID, SubjectTestUtil.SUBJECT_ID);
        expectedException.expectMessage("Student already exist in the unplaced list for this subject.");
    }

    @Test
    public void testAddStudentToGroupLeaveUnplaced() {
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        when(subjectDao.findOne(isA(Long.class))).thenReturn(SubjectTestUtil.createSubject());
        when(studyGroupDao.findAllBySubject(isA(Subject.class))).thenReturn(
                GroupTestUtil.createGroupList(GroupTestUtil.createGroupWithSeats(GroupTestUtil.MIN_SEATS, GroupTestUtil.MIN_SEATS)));
        groupService.addStudentToGroup(StudentTestUtil.STUDENT_ID, SubjectTestUtil.SUBJECT_ID);
        verify(subjectDao, times(1)).save(isA(Subject.class));
    }

    @Test
    public void testAddStudentToGroup() {
        when(studentDao.findOne(isA(Long.class))).thenReturn(StudentTestUtil.createStudent(StudentTestUtil.STUDENT_ID));
        when(subjectDao.findOne(isA(Long.class))).thenReturn(SubjectTestUtil.createSubject());
        when(studyGroupDao.findAllBySubject(isA(Subject.class))).thenReturn(
                GroupTestUtil.createGroupList(GroupTestUtil.createGroupWithSeats(GroupTestUtil.MIN_SEATS, GroupTestUtil.MAX_SEATS)));
        groupService.addStudentToGroup(StudentTestUtil.STUDENT_ID, SubjectTestUtil.SUBJECT_ID);
        verify(studyGroupDao, times(1)).save(isA(StudyGroup.class));
    }

    @Test
    public void testCreateGroupsTemplate() {
        groupService.createGroupsTemplate(new GroupTemplateCreateDto(GroupTestUtil.TEMPLATE_NAME, GroupTestUtil.TEMPLATE_GROUPS_AMOUNT));
        verify(groupsTemplateDao, times(1)).save(isA(GroupsTemplate.class));
    }

    @Configuration
    static class GroupServiceTestContextConfiguration {
        @Bean
        public GroupService groupService() {
            return new GroupServiceImpl();
        }

        @Bean
        public StudyGroupDao studyGroupDao() {
            return mock(StudyGroupDao.class);
        }

        @Bean
        public StudentDao studentDao() {
            return mock(StudentDao.class);
        }

        @Bean
        public SubjectDao subjectDao() {
            return mock(SubjectDao.class);
        }

        @Bean
        public GroupsTemplateDao groupsTemplateDao() {
            return mock(GroupsTemplateDao.class);
        }

        @Bean
        public StudyGroupToStudyGroupDto studyGroupConverter() {
            return new StudyGroupToStudyGroupDto();
        }

        @Bean
        public GradeLevelToGradeLevelDto gradeLevelConverter() {
            return new GradeLevelToGradeLevelDto();
        }

        @Bean
        public StudyClassToStudyClassDto studyClassConverter() {
            return new StudyClassToStudyClassDto();
        }

        @Bean
        public SubjectToSubjectDto subjectConverter() {
            return new SubjectToSubjectDto();
        }

        @Bean
        public StudentToStudentDto studentConverter() {
            return new StudentToStudentDto();
        }

        @Bean
        public SubjectTypeToSubjectTypeDto subkectTypeConverter() {
            return new SubjectTypeToSubjectTypeDto();
        }
    }

}