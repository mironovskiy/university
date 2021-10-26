package com.example.university.service.impl;

import com.example.university.dao.SubjectRepo;
import com.example.university.entity.Subject;
import com.example.university.service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class SubjectServiceImplTest {

    @Mock
    private SubjectRepo subjectRepo;

    private SubjectService subjectService;

    private Subject subject;

    @BeforeEach
    public void init(){
        subjectService = new SubjectServiceImpl(subjectRepo);
        subject = new Subject("Философия");
    }

    @Test
    void testAddSubject() {
        Mockito.when(subjectRepo.findSubjectByName(Mockito.any(String.class))).thenReturn(null);
        assertTrue(subjectService.addSubject("Экономика"));
    }

    @Test
    void testUpdateSubject() {
        Mockito.when(subjectRepo.findSubjectByName(Mockito.any(String.class))).thenReturn(null);
        Mockito.when(subjectRepo.findSubjectById(Mockito.any(Integer.class))).thenReturn(subject);
        assertTrue(subjectService.updateSubject(1, "Экономика"));
    }

    @Test
    void testDeleteSubject() {
        Mockito.when(subjectRepo.findSubjectById(Mockito.any(Integer.class))).thenReturn(subject);
        assertTrue(subjectService.deleteSubject(1));
    }
}