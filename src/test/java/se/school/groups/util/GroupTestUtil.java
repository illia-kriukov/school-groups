package se.school.groups.util;

import se.school.groups.model.StudyGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public class GroupTestUtil {

    public static final Integer MIN_SEATS = 0;
    public static final Integer MAX_SEATS = 5;

    public static final String TEMPLATE_NAME = "Groups template";
    public static final Integer TEMPLATE_GROUPS_AMOUNT = 3;

    public static StudyGroup createGroup() {
        StudyGroup group = new StudyGroup();
        group.setStudent(StudentTestUtil.createEmptyStudentList());
        return group;
    }

    public static StudyGroup createGroupWithSeats(Integer minSeats, Integer maxSeats) {
        StudyGroup group = new StudyGroup();
        group.setMinSeats(minSeats);
        group.setMaxSeats(maxSeats);
        group.setStudent(StudentTestUtil.createEmptyStudentList());
        return group;
    }

    public static List<StudyGroup> createGroupList() {
        return new ArrayList<StudyGroup>() {{
            add(createGroup());
        }};
    }

    public static List<StudyGroup> createGroupList(StudyGroup studyGroup) {
        return new ArrayList<StudyGroup>() {{
            add(studyGroup);
        }};
    }

    public static List<StudyGroup> createGroupListWithStudent(Long studentId) {
        return new ArrayList<StudyGroup>() {{
            add(createGroupWithStudent(studentId));
        }};
    }

    public static List<StudyGroup> createEmptyGroupList() {
        return new ArrayList<>();
    }

    public static StudyGroup createGroupWithStudent(Long studentId) {
        StudyGroup group = new StudyGroup();
        group.setStudent(StudentTestUtil.createStudentListWithStudent(studentId));
        return group;
    }

}