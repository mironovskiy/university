package com.example.university.service.impl;

import com.example.university.dao.*;
import com.example.university.entity.Lecture;
import com.example.university.entity.Student;
import com.example.university.service.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService {

    private LectureRepo lectureRepo;
    private GroupRepo groupRepo;
    private LectureHallRepo lectureHallRepo;
    private SubjectRepo subjectRepo;
    private StudentRepo studentRepo;

    @Override
    public boolean addLecture(Date date, int groupNumber, int lectureHallNumber, String subjectName) {
        if (groupRepo.findGroupByNumber(groupNumber) == null || lectureHallRepo.findLectureHallByNumber(lectureHallNumber) == null
                || subjectRepo.findSubjectByName(subjectName) == null){
            return false;
        }
        lectureRepo.save(new Lecture(date, groupRepo.findGroupByNumber(groupNumber), lectureHallRepo.findLectureHallByNumber(lectureHallNumber), subjectRepo.findSubjectByName(subjectName)));
        return true;
    }

    @Override
    public List<Lecture> findLectureForStudent(int studentId, Date date) {
        if (studentRepo.findStudentById(studentId) == null){
            return null;
        }
        Student student = studentRepo.findStudentById(studentId);
        return lectureRepo.findLecturesByGroupsByGroupIdAndDate(student.getGroupsByGroupId(), date);
    }

    @Override
    public List<Lecture> findAllLectures() {
        return lectureRepo.findAll();
    }

    @Override
    public boolean updateLecture(int id, Date date, int groupNumber, int lectureHallNumber, String subjectName) {
        Lecture lecture = lectureRepo.findLectureById(id);
        if ((lecture == null) || (groupRepo.findGroupByNumber(groupNumber) == null) || (lectureHallRepo.findLectureHallByNumber(lectureHallNumber) == null)
                || (subjectRepo.findSubjectByName(subjectName) == null)) {
            return false;
        }
        lecture.setDate(date);
        lecture.setGroupsByGroupId(groupRepo.findGroupByNumber(groupNumber));
        lecture.setLectureHallsByLectureHallsId(lectureHallRepo.findLectureHallByNumber(lectureHallNumber));
        lecture.setSubjectsBySubjectId(subjectRepo.findSubjectByName(subjectName));
        lectureRepo.save(lecture);
        return true;
    }

    @Override
    public boolean deleteLecture(int id) {
        if (lectureRepo.findLectureById(id) == null){
            return false;
        }
        lectureRepo.delete(lectureRepo.findLectureById(id));
        return true;
    }
}
