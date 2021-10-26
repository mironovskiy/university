package com.example.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "public", catalog = "university")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private Group groupsByGroupId;

    public Student(String name, String lastname, Group groupsByGroupId) {
        this.name = name;
        this.lastname = lastname;
        this.groupsByGroupId = groupsByGroupId;
    }
}
