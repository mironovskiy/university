package com.example.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lecture_halls", schema = "public", catalog = "university")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;

    public LectureHall(int number) {
        this.number = number;
    }
}
