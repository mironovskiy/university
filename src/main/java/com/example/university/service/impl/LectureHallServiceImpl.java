package com.example.university.service.impl;

import com.example.university.dao.LectureHallRepo;
import com.example.university.entity.LectureHall;
import com.example.university.service.LectureHallService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LectureHallServiceImpl implements LectureHallService {

    private LectureHallRepo lectureHallRepo;

    @Override
    public boolean addLectureHall(int lectureHallNumber) {
        if (lectureHallRepo.findLectureHallByNumber(lectureHallNumber) != null){
            return false;
        }
        lectureHallRepo.save(new LectureHall(lectureHallNumber));
        return true;
    }

    @Override
    public LectureHall findLectureHallById(int id) {
        return lectureHallRepo.findLectureHallById(id);
    }

    @Override
    public List<LectureHall> findAllLectureHalls() {
        return lectureHallRepo.findAll();
    }

    @Override
    public boolean updateLectureHall(int id, int newNumber) {
        LectureHall lectureHall = lectureHallRepo.findLectureHallById(id);
        if ((lectureHall == null) || (lectureHallRepo.findLectureHallByNumber(newNumber) != null)) {
            return false;
        }
        lectureHall.setNumber(newNumber);
        lectureHallRepo.save(lectureHall);
        return true;
    }

    @Override
    public boolean deleteLectureHall(int id) {
        if (lectureHallRepo.findLectureHallById(id) == null){
            return false;
        }
        lectureHallRepo.delete(lectureHallRepo.findLectureHallById(id));
        return true;
    }
}
