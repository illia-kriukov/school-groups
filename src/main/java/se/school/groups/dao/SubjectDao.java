package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.Student;
import se.school.groups.model.Subject;

import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface SubjectDao extends PagingAndSortingRepository<Subject, Long> {

    List<Subject> findAllByStudent(Student student);

}