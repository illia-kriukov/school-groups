package se.school.groups.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.school.groups.model.GroupsTemplate;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public interface GroupsTemplateDao extends PagingAndSortingRepository<GroupsTemplate, Long> {
}