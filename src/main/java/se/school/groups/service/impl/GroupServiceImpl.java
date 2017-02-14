package se.school.groups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.school.groups.converter.StudyGroupToStudyGroupDto;
import se.school.groups.dao.GroupsTemplateDao;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.StudyGroupDao;
import se.school.groups.dao.SubjectDao;
import se.school.groups.dto.group.GroupTemplateCreateDto;
import se.school.groups.dto.group.StudyGroupDto;
import se.school.groups.exception.GroupException;
import se.school.groups.exception.SubjectException;
import se.school.groups.model.GroupsTemplate;
import se.school.groups.model.Student;
import se.school.groups.model.StudyGroup;
import se.school.groups.model.Subject;
import se.school.groups.service.GroupService;

import java.util.List;

/**
 * Created by illia.kriukov on 1/13/17.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private StudyGroupDao studyGroupDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private GroupsTemplateDao groupsTemplateDao;

    @Autowired
    private StudyGroupToStudyGroupDto studyGroupConverter;

    @Override
    public StudyGroupDto getStudyGroup(Long groupId) {
        StudyGroup studyGroup = studyGroupDao.findOne(groupId);
        return studyGroup != null ? studyGroupConverter.apply(studyGroup) : null;
    }

    @Override
    public void addStudentToGroup(Long studentId, Long subjectId) {
        Student student = studentDao.findOne(studentId);
        Subject subject = subjectDao.findOne(subjectId);
        List<StudyGroup> groups = studyGroupDao.findAllBySubject(subject);

        checkPresence(student, groups);

        if (!addToGroup(student, groups)) {
            addToUnplaced(student, subject);
        }
    }

    @Override
    public void createGroupsTemplate(GroupTemplateCreateDto dto) {
        groupsTemplateDao.save(new GroupsTemplate(dto.getName(), dto.getGroupsAmount()));
    }

    /**
     * Check that student doesn't exist in the groups.
     *
     * @param student
     * @param groups
     */
    private void checkPresence(Student student, List<StudyGroup> groups) {
        groups.stream().filter(g -> g.getStudent().contains(student)).forEach(g -> {
            throw new GroupException(String.format("Student already exist in the group for this subject."));
        });
    }

    /**
     * Add student to available group.
     *
     * Steps:
     * 1. Find available group;
     * 2. Add student into it.
     *
     * @param student
     * @param groups
     * @return
     */
    private boolean addToGroup(Student student, List<StudyGroup> groups) {
        for (StudyGroup g : groups) {
            if (g.getStudent().size() + 1 <= g.getMaxSeats()) {
                g.getStudent().add(student);
                studyGroupDao.save(g);
                return true;
            }
        }
        return false;
    }

    /**
     * Add student to list of unplaced students for specific subject.
     *
     * @param student
     * @param subject
     */
    private void addToUnplaced(Student student, Subject subject) {
        List<Student> unplacedStudents = subject.getUnplacedStudent();
        if (unplacedStudents.contains(student)) {
            throw new SubjectException(String.format("Student already exist in the unplaced list for this subject."));
        } else {
            unplacedStudents.add(student);
            subjectDao.save(subject);
        }
    }

}