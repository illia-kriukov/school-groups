package se.school.groups.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private GradeLevel gradeLevel;

    @ManyToOne
    private SubjectType subjectType;

    @ManyToMany
    private List<Student> student;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "unplaced_student", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> unplacedStudent;

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

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Student> getUnplacedStudent() {
        return unplacedStudent;
    }

    public void setUnplacedStudent(List<Student> unplacedStudent) {
        this.unplacedStudent = unplacedStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return new EqualsBuilder()
                .append(id, subject.id)
                .append(name, subject.name)
                .append(gradeLevel, subject.gradeLevel)
                .append(subjectType, subject.subjectType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(gradeLevel)
                .append(subjectType)
                .toHashCode();
    }

}