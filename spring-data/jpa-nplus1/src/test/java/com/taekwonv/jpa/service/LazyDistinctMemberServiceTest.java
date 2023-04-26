package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.lazy.LazyMember;
import com.taekwonv.jpa.domain.lazy.LazyOrder;
import com.taekwonv.jpa.repository.LazyMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LazyDistinctMemberServiceTest {

    @Autowired
    private LazyMemberRepository lazyMemberRepository;

    @BeforeEach
    public void init() {
        List<LazyMember> lazyMembers = new ArrayList<>();

        for (long i = 1; i <= 5; i++) {
            LazyMember lm = new LazyMember("LM " + i);

            LazyOrder lo = new LazyOrder("LO1 " + i);
            LazyOrder lo2 = new LazyOrder("LO2 " + i);

            lm.addLazyOrders(lo);
            lm.addLazyOrders(lo2);

            lazyMembers.add(lm);
        }
        lazyMemberRepository.saveAll(lazyMembers);
    }

    @AfterEach
    public void tearDown() {
        lazyMemberRepository.deleteAll();
    }

    @Test
    @DisplayName("N + 1 문제 발생 - 지연 로딩 관계")
    void 지연로딩_N_Plus_1() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAll();

        // then
        assertThat(lazyMembers.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 지연 로딩 관계 - (INNER JOIN) 페치조인 사용")
    void INNER_페치조인_지연로딩_N_Plus_1() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllJoinFetch();

        // then
        assertThat(lazyMembers.size()).isEqualTo(10);
    }


    @Test
    @DisplayName("N + 1 문제 해결 - 지연 로딩 관계 - (LEFT OUTER JOIN) 페치조인 사용 + Distinct 적용")
    void OUTER_페치조인_지연로딩_N_Plus_1_Distinct() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllLeftOuterJoinFetchWithDistinct();

        // then
        assertThat(lazyMembers.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 지연 로딩 관계 - (LEFT OUTER JOIN) 페치조인 사용")
    void OUTER_페치조인_지연로딩_N_Plus_1() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllLeftOuterJoinFetch();

        // then
        assertThat(lazyMembers.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 지연 로딩 관계 - (LEFT OUTER JOIN) 엔티티 그래프 사용")
    void OUTER_엔티티그래프_지연로딩_N_Plus_1() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllEntityGraph();

        // then
        assertThat(lazyMembers.size()).isEqualTo(5);
    }
}