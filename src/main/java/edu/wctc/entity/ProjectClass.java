package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ProjectClass")
public class ProjectClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PCID")
    private int id;

    @Column(name = "ClassID")
    private int classID;

    @Column(name="ProjectID")
    private int ProjectID;
}
