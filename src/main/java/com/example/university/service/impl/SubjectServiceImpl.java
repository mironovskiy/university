package com.example.university.service.impl;

import com.example.university.dao.SubjectRepo;
import com.example.university.entity.Subject;
import com.example.university.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepo subjectRepo;

    @Override
    public boolean addSubject(String name) {
        if (subjectRepo.findSubjectByName(name) != null){
            return false;
        }
        subjectRepo.save(new Subject(name));
        return true;
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectRepo.findSubjectById(id);
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public boolean updateSubject(int id, String newName) {
        Subject subject = subjectRepo.findSubjectById(id);
        if ((subject == null) || (subjectRepo.findSubjectByName(newName) != null)) {
            return false;
        }
        subject.setName(newName);
        subjectRepo.save(subject);
        return true;
    }

    @Override
    public boolean deleteSubject(int id) {
        if (subjectRepo.findSubjectById(id) == null){
            return false;
        }
        subjectRepo.delete(subjectRepo.findSubjectById(id));
        return true;
    }
}