package se.school.groups.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by illia.kriukov on 1/14/17.
 */
@Entity
public class StudyGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private GradeLevel gradeLevel;

    @ManyToOne
    private StudyClass studyClass;

    @Column(nullable = false)
    private Integer minSeats;

    @Column(nullable = false)
    private Integer maxSeats;

    @ManyToMany
    private List<Subject> subject;

    @ManyToMany
    private List<Student> student;

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

    public StudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClass studyClass) {
        this.studyClass = studyClass;
    }

    public Integer getMinSeats() {
        return minSeats;
    }

    public void setMinSeats(Integer minSeats) {
        this.minSeats = minSeats;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}