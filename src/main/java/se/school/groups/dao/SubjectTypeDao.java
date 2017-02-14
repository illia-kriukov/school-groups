package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.SubjectType;

/**
 * Created by illia.kriukov on 1/14/17.
 */
public interface SubjectTypeDao extends PagingAndSortingRepository<SubjectType, Long> {
}