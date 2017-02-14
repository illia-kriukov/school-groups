package se.school.groups.model;

import javax.persistence.*;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Entity
public class GroupsTemplate {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer groupsAmount;

    public GroupsTemplate(String name, Integer groupsAmount) {
        this.name = name;
        this.groupsAmount = groupsAmount;
    }

    public GroupsTemplate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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