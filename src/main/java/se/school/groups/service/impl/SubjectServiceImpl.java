package se.school.groups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.school.groups.converter.StudentToStudentDto;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.SubjectDao;
import se.school.groups.dto.student.StudentDto;
import se.school.groups.exception.AccountException;
import se.school.groups.exception.StudentException;
import se.school.groups.exception.SubjectException;
import se.school.groups.model.Student;
import se.school.groups.model.Subject;
import se.school.groups.service.GroupService;
import se.school.groups.service.SubjectService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by illia.kriukov on 1/15/17.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private GroupService groupService;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentToStudentDto studentConverter;

    @Override
    public void addStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectDao.findOne(subjectId);
        Student student = studentDao.findOne(studentId);

        checkSubject(subject);
        checkStudent(student);

        if (!student.getGradeLevel().equals(subject.getGradeLevel())) {
            throw new StudentException(String.format("Student grade level should be the same with subject."));
        } else if (subject.getStudent().contains(student)) {
            throw new StudentException(String.format("This student already took such subject."));
        }

        subject.getStudent().add(student);
        subjectDao.save(subject);

        groupService.addStudentToGroup(studentId, subjectId);
    }

    @Override
    public List<StudentDto> listUnplacedStudents(Long subjectId) {
        Subject subject = subjectDao.findOne(subjectId);
        checkSubject(subject);
        List<Student> unplacedStudents = subject.getUnplacedStudent();
        return unplacedStudents == null ? null :
                unplacedStudents.stream().map(s -> studentConverter.apply(s)).collect(Collectors.toList());
    }

    /**
     * Check that subject exists in the db.
     *
     * @param subject
     */
    private void checkSubject(Subject subject) {
        if (subject == null) {
            String msg = "Such subject doesn't exist.";
            throw new SubjectException(String.format(msg));
        }
    }

    /**
     * Check that student exists in the db.
     *
     * @param student
     */
    private void checkStudent(Student student) {
        if (student == null) {
            String msg = "Such student doesn't exist.";
            throw new AccountException(String.format(msg));
        }
    }

}