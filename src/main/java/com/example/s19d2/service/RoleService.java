package com.example.s19d2.service;

import java.util.List;

import com.example.s19d2.entity.Role;

public interface RoleService {

     List<Role> findAll();

     Role save(Role role);

     Role update(long id, Role role);

     Role delete(long id);

}
