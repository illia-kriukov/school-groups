package se.school.groups.dto.group;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Dto for creating new groups template.
 *
 * Created by illia.kriukov on 1/15/17.
 */
public class GroupTemplateCreateDto {

    @NotNull(message = "Template name should not be empty.")
    @Pattern(regexp = "^[a-zA-Z- ]*$", message = "Template name can contain only letters and '-'.")
    private String name;

    @NotNull(message = "Groups amount should not be empty.")
    private Integer groupsAmount;

    public GroupTemplateCreateDto(String name, Integer groupsAmount) {
        this.name = name;
        this.groupsAmount = groupsAmount;
    }

    public GroupTemplateCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupsAmount() {
        return groupsAmount;
    }

    public void setGroupsAmount(Integer groupsAmount) {
        this.groupsAmount = groupsAmount;
    }

}