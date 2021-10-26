package com.example.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "lectures", schema = "public", catalog = "university")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private Group groupsByGroupId;

    @ManyToOne
    @JoinColumn(name = "lecture_halls_id", referencedColumnName = "id", nullable = false)
    private LectureHall lectureHallsByLectureHallsId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    private Subject subjectsBySubjectId;

    public Lecture(Date date, Group groupsByGroupId, LectureHall lectureHallsByLectureHallsId, Subject subjectsBySubjectId) {
        this.date = date;
        this.groupsByGroupId = groupsByGroupId;
        this.lectureHallsByLectureHallsId = lectureHallsByLectureHallsId;
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
}
