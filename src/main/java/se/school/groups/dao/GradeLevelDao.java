package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.GradeLevel;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface GradeLevelDao extends PagingAndSortingRepository<GradeLevel, Long> {
}