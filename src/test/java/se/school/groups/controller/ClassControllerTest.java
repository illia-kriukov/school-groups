package se.school.groups.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.school.groups.dto.StudyClassDto;
import se.school.groups.service.ClassService;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_ID;
import static se.school.groups.util.SubjectTestUtil.STUDY_CLASS_NAME;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ClassController.class,
        includeFilters = @ComponentScan.Filter(classes = EnableWebSecurity.class))
public class ClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassService classService;

    @Test
    public void testGetStudyClass() throws Exception {
        given(classService.getStudyClass(anyLong())).willReturn(new StudyClassDto(STUDY_CLASS_ID, STUDY_CLASS_NAME));

        mockMvc.perform(get("/class/" + STUDY_CLASS_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(STUDY_CLASS_ID.intValue())))
                .andExpect(jsonPath("$.name", is(STUDY_CLASS_NAME)));

        verify(classService, times(1)).getStudyClass(anyLong());
        verifyNoMoreInteractions(classService);
    }

}