package com.example.university.service.impl;

import com.example.university.dao.GroupRepo;
import com.example.university.entity.Group;
import com.example.university.service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {

    @Mock
    private GroupRepo groupRepo;

    private GroupService groupService;

    private Group testGroup;

    @BeforeEach
    public void init(){
        groupService = new GroupServiceImpl(groupRepo);
        testGroup = new Group(772301);
    }

    @Test
    void testAddGroup() {
        Mockito.when(groupRepo.findGroupByNumber(Mockito.any(Integer.class))).thenReturn(null);
        assertTrue(groupService.addGroup(772301));
    }

    @Test
    void testUpdateGroup() {
        Mockito.when(groupRepo.findGroupByNumber(Mockito.any(Integer.class))).thenReturn(null);
        Mockito.when(groupRepo.findGroupById(Mockito.any(Integer.class))).thenReturn(testGroup);
        assertTrue(groupService.updateGroup(1, 772303));
    }

    @Test
    void deleteGroup() {
        Mockito.when(groupRepo.findGroupById(Mockito.any(Integer.class))).thenReturn(testGroup);
        assertTrue(groupService.deleteGroup(1));
    }
}