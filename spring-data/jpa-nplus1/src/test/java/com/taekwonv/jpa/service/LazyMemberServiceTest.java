package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.lazy.LazyMember;
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
class LazyMemberServiceTest {

    @Autowired
    private LazyMemberRepository lazyMemberRepository;

    @BeforeEach
    public void init() {
        List<LazyMember> lazyMembers = new ArrayList<>();

        for (long i = 1; i <= 5; i++) {
            LazyMember em = new LazyMember("LM " + i);
            lazyMembers.add(em);
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

        /**
         *  Hibernate: select lazymember0_.id as id1_2_, lazymember0_.name as name2_2_ from lazy_member lazymember0_
         *  지연 로딩으로 설정 시, 대상 엔티티 조회 시 연관 엔티티를 즉시 조회하는 구조가 아니므로 대상 엔티티 조회 시점에는 N + 1 문제 발생 X
         */
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
        /** @beforeEach 에서
         *
         *  각 회원 별로 주문 목록을 추가하지 않은 것을 확인 할 수 있다.
         *
         *  이 때, INNER JOIN + FETCH JOIN 사용하게 되면 회원과 주문 목록의 교집합 부분이 조회되므로
         *
         *  이 상황에서는  이 나온다.
         *
         *  JPQL 은 엔티티 그래프와 달리 `join fetch` 명령어 앞에 INNER or LEFT OUTER 를 명시하여 조인 방식을 결정할 수 있다.
         *
         * */
        assertThat(lazyMembers.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 지연 로딩 관계 - (LEFT OUTER JOIN) 페치조인 사용")
    void OUTER_페치조인_지연로딩_N_Plus_1() {

        // given
        List<LazyMember> lazyMembers = lazyMemberRepository.findAllLeftOuterJoinFetch();

        // then
        assertThat(lazyMembers.size()).isEqualTo(5);
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