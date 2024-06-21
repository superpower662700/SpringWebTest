package com.example.webtest.service;

import com.example.webtest.entity.role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface roleService {
    public List<role> findAll();
    public Optional findById(int id);
    public boolean deleteById(int id);
    public void addRole(role role);
    public void updateRole(role role);
}
