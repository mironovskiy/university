package com.example.university.service.impl;

import com.example.university.dao.GroupRepo;
import com.example.university.entity.Group;
import com.example.university.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepo groupRepo;

    @Override
    public boolean addGroup(int groupNumber) {
        if (groupRepo.findGroupByNumber(groupNumber) != null){
            return false;
        }
        groupRepo.save(new Group(groupNumber));
        return true;
    }

    @Override
    public Group findGroupById(int id) {
        return groupRepo.findGroupById(id);
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public boolean updateGroup(int id, int newNumber) {
        Group group = groupRepo.findGroupById(id);
        if ((group == null) || (groupRepo.findGroupByNumber(newNumber) != null)) {
            return false;
        }
        group.setNumber(newNumber);
        groupRepo.save(group);
        return true;
    }

    @Override
    public boolean deleteGroup(int id) {
        if (groupRepo.findGroupById(id) == null){
            return false;
        }
        groupRepo.delete(groupRepo.findGroupById(id));
        return true;
    }
}
