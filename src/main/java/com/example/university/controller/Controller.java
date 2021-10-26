package com.example.university.controller;

import com.example.university.entity.*;
import com.example.university.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private GroupService groupService;
    private LectureHallService lectureHallService;
    private SubjectService subjectService;
    private StudentService studentService;
    private LectureService lectureService;

    //Group

    @PostMapping("/group/add")
    public void addGroup(@RequestParam int groupNumber){
        groupService.addGroup(groupNumber);
    }

    @GetMapping("/group/getById")
    public Group findGroupById(@RequestParam int id){
        return groupService.findGroupById(id);
    }

    @GetMapping("/group/getAll")
    public List<Group> findAllGroups(){
        return groupService.findAllGroups();
    }

    @PutMapping("/group/update")
    public void updateGroup(@RequestParam int id, @RequestParam int newNumber){
        groupService.updateGroup(id, newNumber);
    }

    @DeleteMapping("/group/delete")
    public void deleteGroup(@RequestParam int id){
        groupService.deleteGroup(id);
    }

    //LectureHall

    @PostMapping("/lectureHall/add")
    public void addLectureHall(@RequestParam int lectureHallNumber){
        lectureHallService.addLectureHall(lectureHallNumber);
    }

    @GetMapping("/lectureHall/getById")
    public LectureHall findLectureHallById(@RequestParam int id){
        return lectureHallService.findLectureHallById(id);
    }

    @GetMapping("/lectureHall/getAll")
    public List<LectureHall> findAllLectureHalls(){
        return lectureHallService.findAllLectureHalls();
    }

    @PutMapping("/lectureHall/update")
    public void updateLectureHall(@RequestParam int id, @RequestParam int newNumber){
        lectureHallService.updateLectureHall(id, newNumber);
    }

    @DeleteMapping("/lectureHall/delete")
    public void deleteLectureHall(@RequestParam int id){
        lectureHallService.deleteLectureHall(id);
    }

    //Subject

    @PostMapping("/subject/add")
    public void addSubject(@RequestParam String subjectName){
        subjectService.addSubject(subjectName);
    }

    @GetMapping("/subject/getById")
    public Subject findSubjectById(@RequestParam int id){
        return subjectService.findSubjectById(id);
    }

    @GetMapping("/subject/getAll")
    public List<Subject> findAllSubjects(){
        return subjectService.findAllSubjects();
    }

    @PutMapping("/subject/update")
    public void updateSubject(@RequestParam int id, @RequestParam String newName){
        subjectService.updateSubject(id, newName);
    }

    @DeleteMapping("/subject/delete")
    public void deleteSubject(@RequestParam int id){
        subjectService.deleteSubject(id);
    }

    //Student

    @PostMapping("/student/add")
    public void addStudent(@RequestParam String name, String lastname, int groupNumber){
        studentService.addStudent(name, lastname, groupNumber);
    }

    @GetMapping("/student/getById")
    public Student findStudentById(@RequestParam int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/student/getAll")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PutMapping("/student/update")
    public void updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String lastname, @RequestParam int groupNumber){
        studentService.updateStudent(id, name, lastname, groupNumber);
    }

    @DeleteMapping("/student/delete")
    public void deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
    }

    //Lecture

    @PostMapping("/lecture/add")
    public void addLecture(@RequestParam Date date, @RequestParam int groupNumber, int lectureHallNumber, String subjectName){
        lectureService.addLecture(date, groupNumber, lectureHallNumber, subjectName);
    }

    @GetMapping("/lecture/getAll")
    public List<Lecture> findAllLectures(){
        return lectureService.findAllLectures();
    }

    @PutMapping("/lecture/update")
    public void updateLecture(@RequestParam int id, @RequestParam Date date, @RequestParam int groupNumber, int lectureHallNumber, String subjectName){
        lectureService.updateLecture(id, date, groupNumber, lectureHallNumber, subjectName);
    }

    @DeleteMapping("/lecture/delete")
    public void deleteLecture(@RequestParam int id) {
        lectureService.deleteLecture(id);
    }

    @GetMapping("/lecture/get")
    public List<Lecture> findLectureForStudent(@RequestParam int studentId, @RequestParam Date date){
        return lectureService.findLectureForStudent(studentId, date);
    }
}