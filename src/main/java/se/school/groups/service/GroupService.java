package se.school.groups.service;

import se.school.groups.dto.group.GroupTemplateCreateDto;
import se.school.groups.dto.group.StudyGroupDto;

/**
 * Created by illia.kriukov on 1/13/17.
 */
public interface GroupService {

    StudyGroupDto getStudyGroup(Long groupId);

    /**
     * Add student to group for specific subject.
     *
     * @param studentId
     * @param subjectId
     */
    void addStudentToGroup(Long studentId, Long subjectId);

    void createGroupsTemplate(GroupTemplateCreateDto dto);

}