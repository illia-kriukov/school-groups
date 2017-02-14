package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.StudyClass;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface StudyClassDao extends PagingAndSortingRepository<StudyClass, Long> {
}