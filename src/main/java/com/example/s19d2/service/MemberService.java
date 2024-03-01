package com.example.s19d2.service;

import java.util.List;

import com.example.s19d2.entity.Member;

public interface MemberService {

     List<Member> findAll();

     Member findById(Long id);

     Member save(Member member);

     Member update(Long id, Member member);

     Member delete(Long id);

}
