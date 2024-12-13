package com.golfclub.services;

import com.golfclub.models.Member;
import com.golfclub.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    // Ensure there is only one searchMembers method here
    public List<Member> searchMembers(String firstName, String lastName, String phone) {
        return memberRepository.searchMembers(firstName, lastName, phone);
    }
}
