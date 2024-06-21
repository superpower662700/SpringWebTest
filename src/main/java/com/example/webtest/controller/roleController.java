package com.example.webtest.controller;


import com.example.webtest.entity.role;
import com.example.webtest.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/manageRole")
public class roleController {

    @Autowired
    roleService roleService;

    @GetMapping
    public ResponseEntity getRole(){
        List<role> r = roleService.findAll();
        if(!r.isEmpty()){
            return ResponseEntity.ok(Collections.singletonMap(0, r));
        }
        return ResponseEntity.ok(Collections.singletonMap(-1, "Không tồn tại dữ liệu"));
    }

    @PatchMapping
    public ResponseEntity getRole(@RequestParam int roleId){

        Optional role = roleService.findById(roleId);
        if(role.isPresent()){
            return ResponseEntity.ok(Collections.singletonMap(0, role));
        }
        return ResponseEntity.ok(Collections.singletonMap(-1, "Không có dữ liệu" ));
    }

    @PostMapping
    public ResponseEntity addRole(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double wage) {
            if (name == null || name.equals("") || wage == null) {
                    return ResponseEntity.ok(Collections.singletonMap(-1, "Thiếu thông tin"));
                }
            role r1 = new role();
            r1.setName(name);
            r1.setWage(wage);
            roleService.addRole(r1);
            return ResponseEntity.ok(Collections.singletonMap(0, "Thành công"));

    }
    @PutMapping
    public ResponseEntity updateRole(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer roleId,
                                     @RequestParam(required = false) Double wage){
        if (name == null || name.equals("") || wage == null || roleId == null) {
            return ResponseEntity.ok(Collections.singletonMap(-1, "Thiếu thông tin"));
        }
        role r1 = new role();
        r1.setRoleId(roleId);
        r1.setWage(wage);
        r1.setName(name);
        roleService.updateRole(r1);
        return ResponseEntity.ok(Collections.singletonMap(0, "Thành công"));
    }
    @DeleteMapping
    public ResponseEntity deleteRole(@RequestParam int roleId) {
        if (roleService.deleteById(roleId)){
            return ResponseEntity.ok(Collections.singletonMap(0, "Thành công"));
        }
        return ResponseEntity.ok(Collections.singletonMap(-1, "Không có dữ liệu để xóa" ));
    }
}
