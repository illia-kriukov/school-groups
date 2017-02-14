package se.school.groups.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.school.groups.service.StudentService;
import se.school.groups.util.StudentTestUtil;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static se.school.groups.util.SubjectTestUtil.GRADE_LEVEL_1_ID;
import static se.school.groups.util.SubjectTestUtil.GRADE_LEVEL_1_NAME;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_ID;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_NAME;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentController.class,
        includeFilters = @ComponentScan.Filter(classes = EnableWebSecurity.class))
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testExample() throws Exception {
        given(studentService.getStudent(anyLong())).willReturn(StudentTestUtil.createStudentDtoWithFullInfo());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/" + StudentTestUtil.STUDENT_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(StudentTestUtil.STUDENT_ID.intValue())))
                .andExpect(jsonPath("$.firstName", Matchers.is(StudentTestUtil.FIRST_NAME)))
                .andExpect(jsonPath("$.email", Matchers.is(StudentTestUtil.EMAIL)))
                .andExpect(jsonPath("$.gradeLevel.id", is(GRADE_LEVEL_1_ID.intValue())))
                .andExpect(jsonPath("$.gradeLevel.name", is(GRADE_LEVEL_1_NAME)))
                .andExpect(jsonPath("$.studyClass.id", is(STUDY_CLASS_ID.intValue())))
                .andExpect(jsonPath("$.studyClass.name", is(STUDY_CLASS_NAME)));

        verify(studentService, times(1)).getStudent(anyLong());
        verifyNoMoreInteractions(studentService);
    }

}