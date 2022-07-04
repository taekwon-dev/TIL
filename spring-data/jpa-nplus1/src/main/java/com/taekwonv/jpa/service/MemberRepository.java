package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("SELECT m FROM Member m")
    List<Member> findAll();

    @Query("SELECT m FROM Member m join fetch m.orders")
    List<Member> findALLJoinFetch();
}
