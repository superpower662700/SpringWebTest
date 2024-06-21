package com.example.webtest.repostirory;

import com.example.webtest.entity.role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface roleRepostirory extends JpaRepository<role,Integer>   {
    boolean existsByname(String name);
}
