package com.example.s19d2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Member;
import com.example.s19d2.exception.MemberException;
import com.example.s19d2.repository.MemberRepository;
import com.example.s19d2.validation.MemberValidation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

   private MemberRepository memberRepository;

   @Override
   public List<Member> findAll() {
      return memberRepository.findAll();
   }

   @SuppressWarnings("null")
   @Override
   public Member save(Member member) {
      MemberValidation.isMemberCredentialsValid(member);
      return memberRepository.save(member);
   }

   @SuppressWarnings("null")
   @Override
   public Member update(Long id, Member member) {
      MemberValidation.isMemberCredentialsValid(member);
      MemberValidation.isIdValid(id);
      memberRepository.findById(id)
            .orElseThrow(() -> new MemberException("There is no member with given id", HttpStatus.NOT_FOUND));
      member.setId(id);
      return memberRepository.save(member);
   }

   @SuppressWarnings("null")
   @Override
   public Member delete(Long id) {
      MemberValidation.isIdValid(id);
      Member member = findById(id);
      memberRepository.delete(member);
      return member;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return memberRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Member not found"));
   }

   @SuppressWarnings("null")
   @Override
   public Member findById(Long id) {
      MemberValidation.isIdValid(id);
      Member member = memberRepository.findById(id)
            .orElseThrow(() -> new MemberException("There is no Member with given ID", HttpStatus.NOT_FOUND));
      return member;

   }

}
