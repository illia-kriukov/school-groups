package se.school.groups.util;

import se.school.groups.model.GradeLevel;
import se.school.groups.model.StudyClass;
import se.school.groups.model.Subject;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public class SubjectTestUtil {

    public static final Long SUBJECT_ID = 1L;

    public static final Long GRADE_LEVEL_1_ID = 1L;
    public static final String GRADE_LEVEL_1_NAME = "1";
    public static final Long GRADE_LEVEL_2_ID = 2L;
    public static final String GRADE_LEVEL_2_NAME = "2";

    public static final Long STUDY_CLASS_ID = 1L;
    public static final String STUDY_CLASS_NAME = "1";

    public static Subject createSubject() {
        Subject subject = new Subject();
        subject.setGradeLevel(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        subject.setStudent(StudentTestUtil.createEmptyStudentList());
        subject.setUnplacedStudent(StudentTestUtil.createEmptyStudentList());
        return subject;
    }

    public static Subject createSubjectWithLevel2() {
        Subject subject = new Subject();
        subject.setGradeLevel(createGradeLevel(GRADE_LEVEL_2_ID, GRADE_LEVEL_2_NAME));
        subject.setStudent(StudentTestUtil.createEmptyStudentList());
        return subject;
    }

    public static Subject createSubjectWithStudent(Long studentId) {
        Subject subject = new Subject();
        subject.setGradeLevel(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        subject.setStudent(StudentTestUtil.createStudentListWithStudent(studentId));
        return subject;
    }

    public static Subject createSubjectWithUnplacedStudent(Long studentId) {
        Subject subject = new Subject();
        subject.setGradeLevel(createGradeLevel(GRADE_LEVEL_1_ID, GRADE_LEVEL_1_NAME));
        subject.setUnplacedStudent(StudentTestUtil.createStudentListWithStudent(studentId));
        return subject;
    }

    public static GradeLevel createGradeLevel(Long id, String name) {
        return new GradeLevel(id, name);
    }

    public static StudyClass createStudyClass() {
        return new StudyClass(STUDY_CLASS_ID, STUDY_CLASS_NAME);
    }

}