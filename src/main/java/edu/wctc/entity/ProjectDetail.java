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
@Table(name = "ProjectDetail")
public class ProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectID")
    private int id;

    @ManyToMany(cascade = {CascadeType.DETACH,
    CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name= "ProjectClass",
    joinColumns = @JoinColumn(name = "ProjectID"),
    inverseJoinColumns = @JoinColumn( name = "ClassID"))
    private List<ClassOb> classes;

    @Column(name="Reason")
    private String Reason;

    @Column(name="Description")
    private String Description;

    @OneToOne(mappedBy = "detail",
    cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private Project project;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name= "ProjectSkill",
            joinColumns = @JoinColumn(name = "ProjectID"),
            inverseJoinColumns = @JoinColumn( name = "SkillID"))
    private List<Skill> skills;
}
