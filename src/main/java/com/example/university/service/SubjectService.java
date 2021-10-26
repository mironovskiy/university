package com.example.university.service;

import com.example.university.entity.Subject;

import java.util.List;

public interface SubjectService {
    boolean addSubject(String name);
    Subject findSubjectById(int id);
    List<Subject> findAllSubjects();
    boolean updateSubject(int id, String newName);
    boolean deleteSubject(int id);
}
