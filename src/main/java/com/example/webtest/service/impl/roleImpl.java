package com.example.webtest.service.impl;

import com.example.webtest.entity.role;
import com.example.webtest.repostirory.roleRepostirory;
import com.example.webtest.service.roleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.List;
import java.util.Optional;

@Service
public class roleImpl implements roleService {

    @Autowired
    roleRepostirory _roleRepostirory;

    @Override
    public List<role> findAll() {
        List<role> roleList = _roleRepostirory.findAll();
        return roleList;
    }

    @Override
    public Optional findById(int id) {
        Optional r = _roleRepostirory.findById(id);
            return r;
    }

    @Override
    public boolean deleteById(int id) {
        Optional r = _roleRepostirory.findById(id);
        if(r.isPresent()) {
            _roleRepostirory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void addRole(role role) {
        boolean b = _roleRepostirory.existsByname(role.getName());
        if(!b) {
            _roleRepostirory.save(role);
        }
        else
        {System.out.println("-1");}
    }

    @Override
    public void updateRole(role role) {
        _roleRepostirory.save(role);
    }
}
