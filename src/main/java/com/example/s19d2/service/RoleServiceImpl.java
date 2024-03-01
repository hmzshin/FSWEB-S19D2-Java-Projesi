package com.example.s19d2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Role;
import com.example.s19d2.exception.RoleException;
import com.example.s19d2.repository.RoleRepository;
import com.example.s19d2.validation.RoleValidation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Role save(Role role) {
        RoleValidation.isRoleCredentialsValid(role);
        return roleRepository.save(role);
    }

    @Override
    public Role update(long id, Role role) {
        RoleValidation.isRoleCredentialsValid(role);
        RoleValidation.isIdValid(id);
        roleRepository.findById(id)
                .orElseThrow(() -> new RoleException("There is no role with given id", HttpStatus.NOT_FOUND));
        role.setId(id);
        return roleRepository.save(role);

    }

    @SuppressWarnings("null")
    @Override
    public Role delete(long id) {
        RoleValidation.isIdValid(id);
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleException("There is no role with given id", HttpStatus.NOT_FOUND));
        roleRepository.delete(role);
        return role;
    }

}
