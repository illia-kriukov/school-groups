package se.school.groups.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.school.groups.converter.StudyClassToStudyClassDto;
import se.school.groups.dao.StudyClassDao;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.model.StudyClass;
import se.school.groups.service.impl.ClassServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_ID;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_NAME;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ClassServiceTest {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudyClassDao studyClassDao;

    @Test
    public void testGetStudyClass() {
        when(studyClassDao.findOne(isA(Long.class))).thenReturn(new StudyClass(STUDY_CLASS_ID, STUDY_CLASS_NAME));
        StudyClassDto expectedClass = new StudyClassDto(STUDY_CLASS_ID, STUDY_CLASS_NAME);
        StudyClassDto actualClass = classService.getStudyClass(STUDY_CLASS_ID);
        assertEquals("Study classes should be the same", expectedClass, actualClass);
    }

    @Configuration
    static class ClassServiceTestContextConfiguration {
        @Bean
        public ClassService classService() {
            return new ClassServiceImpl();
        }

        @Bean
        public StudyClassDao studyClassDao() {
            return mock(StudyClassDao.class);
        }

        @Bean
        public StudyClassToStudyClassDto studyClassConverter() {
            return new StudyClassToStudyClassDto();
        }
    }

}