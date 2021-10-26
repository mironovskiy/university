package com.example.university.dao;

import com.example.university.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepo extends JpaRepository<Group, Long> {
    Group findGroupById(int id);
    Group findGroupByNumber(int number);
}
