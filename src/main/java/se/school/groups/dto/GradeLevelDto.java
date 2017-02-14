package se.school.groups.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by illia.kriukov on 1/15/17.
 */
public class GradeLevelDto {

    private Long id;

    private String name;

    public GradeLevelDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GradeLevelDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GradeLevelDto that = (GradeLevelDto) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .toHashCode();
    }

}