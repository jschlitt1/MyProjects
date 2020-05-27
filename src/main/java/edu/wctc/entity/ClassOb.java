package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "class")
public class ClassOb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassID")
    private int id;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "ClassDescription")
    private String ClassDescription;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "LocationID")
    private Location location;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ProjectClass",
    joinColumns = @JoinColumn(name = "ClassID"),
    inverseJoinColumns = @JoinColumn(name = "ProjectID"))
    private List<Project> Projects;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ClassSkill",
            joinColumns = @JoinColumn(name = "ClassID"),
            inverseJoinColumns = @JoinColumn(name = "SkillID"))
    private List<Skill> skills;
}
