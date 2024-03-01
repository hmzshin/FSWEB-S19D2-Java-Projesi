package com.example.s19d2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s19d2.dto.MemberResponse;
import com.example.s19d2.dto.RegisterRequestBody;
import com.example.s19d2.entity.Member;
import com.example.s19d2.service.AuthenticationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping
    public MemberResponse register(@RequestBody RegisterRequestBody registrationMember) {
        Member createdMember = authenticationService.register(registrationMember.email(),
                registrationMember.password(), registrationMember.role());

        System.out.println(registrationMember);
        return new MemberResponse(createdMember.getId(), createdMember.getEmail(), createdMember.getRoles());
    }

}