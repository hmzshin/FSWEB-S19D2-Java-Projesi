package com.example.s19d2.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Member;
import com.example.s19d2.entity.Role;
import com.example.s19d2.exception.MemberException;
import com.example.s19d2.repository.MemberRepository;
import com.example.s19d2.repository.RoleRepository;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public Member register(String email, String password, String role) {

        Optional<Member> memberOp = memberRepository.findByEmail(email);

        if (memberOp.isPresent()) {
            throw new MemberException("User is already exist", HttpStatus.BAD_REQUEST);
        }

        String encodedPassword = passwordEncoder.encode(password);
        List<Role> roleList = new ArrayList<>();

        if (role.equals("ADMIN")) {
            Optional<Role> roleAdmin = roleRepository.findByAuthority("ADMIN");

            if (!roleAdmin.isPresent()) {
                Role newRole = new Role();
                newRole.setAuthority("ADMIN");
                roleList.add(roleRepository.save(newRole));
            } else {
                roleList.add(roleAdmin.get());
            }

        } else {
            Optional<Role> roleUser = roleRepository.findByAuthority("USER");

            if (!roleUser.isPresent()) {
                Role roleUserEntity = new Role();
                roleUserEntity.setAuthority("USER");
                roleList.add(roleRepository.save(roleUserEntity));
            } else {
                roleList.add(roleUser.get());
            }

        }
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(roleList);

        return memberRepository.save(member);
    }
}
