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
@Table(name="Skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SkillId")
    private int id;
    @Column(name="SkillName")
    private String name;
    @Column(name="SkillDescription")
    private String Description;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name= "ProjectSkill",
            joinColumns = @JoinColumn(name = "SkillID"),
            inverseJoinColumns = @JoinColumn( name = "ProjectID"))
    private List<Project> projects;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name= "ClassSkill",
            joinColumns = @JoinColumn(name = "SkillID"),
            inverseJoinColumns = @JoinColumn( name = "ClassID"))
    private List<ClassOb> classes;
}
