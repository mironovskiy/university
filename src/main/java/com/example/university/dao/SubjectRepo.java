package com.example.university.dao;

import com.example.university.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findSubjectById(int id);
    Subject findSubjectByName(String name);
}