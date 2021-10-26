package com.example.university.dao;

import com.example.university.entity.LectureHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHallRepo extends JpaRepository<LectureHall, Long> {
    LectureHall findLectureHallById(int id);
    LectureHall findLectureHallByNumber(int number);
}
