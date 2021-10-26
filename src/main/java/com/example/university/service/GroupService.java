package com.example.university.service;

import com.example.university.entity.Group;

import java.util.List;

public interface GroupService {
    boolean addGroup(int groupNumber);
    Group findGroupById(int id);
    List<Group> findAllGroups();
    boolean updateGroup(int id, int newNumber);
    boolean deleteGroup(int id);
}
