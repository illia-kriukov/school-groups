package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.Student;

/**
 * Created by illia.kriukov on 1/13/17.
 */
public interface StudentDao extends PagingAndSortingRepository<Student, Long> {

    Student findByEmail(String email);

}