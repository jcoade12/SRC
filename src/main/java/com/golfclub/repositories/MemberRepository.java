package com.golfclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.golfclub.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom query methods if needed
}
