package com.golfclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.golfclub.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // Custom search query for flexible parameter matching
    @Query("SELECT m FROM Member m WHERE " +
           "(:firstName IS NULL OR m.firstName = :firstName) AND " +
           "(:lastName IS NULL OR m.lastName = :lastName) AND " +
           "(:phone IS NULL OR m.phone = :phone)")
    List<Member> searchMembers(@Param("firstName") String firstName,
                               @Param("lastName") String lastName,
                               @Param("phone") String phone);
}
