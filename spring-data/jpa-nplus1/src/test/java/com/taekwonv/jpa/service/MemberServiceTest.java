package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.Member;
import com.taekwonv.jpa.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private MemberService memberService;

    @BeforeEach
    public void init() {
        List<Member> members = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Member member = new Member("Mebmer " + i);
            members.add(member);
        }
        memberRepository.saveAll(members);

    }

    @AfterEach
    public void teardown() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("N + 1 - 멤버(일) & 주문(다) - 즉시 로딩 관계")
    void 멤버_주문_즉시로딩_N_Plus_1_상황() {

        // given
        List<Member> members = memberRepository.findAll();

        // then
        Assertions.assertThat(members.size()).isEqualTo(5);
    }
}