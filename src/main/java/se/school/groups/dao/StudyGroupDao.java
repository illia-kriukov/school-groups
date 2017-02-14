package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.StudyGroup;
import se.school.groups.model.Subject;

import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface StudyGroupDao extends PagingAndSortingRepository<StudyGroup, Long> {

    List<StudyGroup> findAllBySubject(Subject subject);

}