package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectId")
    private int id;

    @Column(name = "ProjectName")
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "DetailID")
    private ProjectDetail detail;
}
