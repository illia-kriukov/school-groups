package se.school.groups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.school.groups.dao.GradeLevelDao;
import se.school.groups.dao.StudentDao;
import se.school.groups.dao.StudyClassDao;
import se.school.groups.dto.student.StudentCreateDto;
import se.school.groups.exception.AccountException;
import se.school.groups.model.GradeLevel;
import se.school.groups.model.Student;
import se.school.groups.model.StudyClass;
import se.school.groups.service.AccountService;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private GradeLevelDao gradeLevelDao;

    @Autowired
    private StudyClassDao studyClassDao;

    @Override
    public void createStudent(StudentCreateDto dto) {
        GradeLevel gradeLevel = gradeLevelDao.findOne(dto.getGradeLevelId());
        StudyClass studyClass = studyClassDao.findOne(dto.getStudyClassId());

        if (validateStudent(dto.getEmail(), gradeLevel, studyClass)) {
            Student student = new Student(dto.getFirstName(), dto.getLastName(),
                    dto.getEmail(), dto.getPassword(), gradeLevel, studyClass);
            studentDao.save(student);
        }
    }

    /**
     * Validate student's registration data.
     *
     * Checks:
     * - Student email doesn't exists in the db;
     * - Grade level exist in the db;
     * - Study class exist in the db.
     */
     private boolean validateStudent(String email, GradeLevel gradeLevel, StudyClass studyClass) {
        if (studentDao.findByEmail(email) != null) {
            String msg = "Failed to create student '%s'. Student with such email already exists.";
            throw new AccountException(String.format(msg, email));
        } else if (gradeLevel == null) {
            String msg = "Failed to create student '%s'. Wrong grade level.";
            throw new AccountException(String.format(msg, email));
        } else if (studyClass == null) {
            String msg = "Failed to create student '%s'. Wrong study class.";
            throw new AccountException(String.format(msg, email));
        }

        return true;
    }

}