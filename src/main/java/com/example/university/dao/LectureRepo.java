package com.example.university.dao;

import com.example.university.entity.Group;
import com.example.university.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface LectureRepo extends JpaRepository<Lecture, Long> {
    List<Lecture> findLecturesByGroupsByGroupIdAndDate(Group group, Date date);
    Lecture findLectureById(int id);
}
