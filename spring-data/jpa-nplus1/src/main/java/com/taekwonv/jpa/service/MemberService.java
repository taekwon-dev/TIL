package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        List<Member> members = memberRepository.findAll();
        return members;
    }
}
