package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.eager.EagerMember;
import com.taekwonv.jpa.repository.EagerMemberRepository;
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
class EagerMemberServiceTest {

    @Autowired
    private EagerMemberRepository eagerMemberRepository;


    @BeforeEach
    public void init() {
        List<EagerMember> eagerMembers = new ArrayList<>();

        for (long i = 1; i <= 5; i++) {
            EagerMember em = new EagerMember("EM " + i);
            eagerMembers.add(em);
        }
        eagerMemberRepository.saveAll(eagerMembers);
    }

    @AfterEach
    public void tearDown() {
        eagerMemberRepository.deleteAll();
    }

    @Test
    @DisplayName("N + 1 문제 발생 - 즉시 로딩 관계")
    void 즉시로딩_N_Plus_1() {

        /**
         * Hibernate: select eagermembe0_.id as id1_0_, eagermembe0_.name as name2_0_ from eager_member eagermembe0_ ❗️ 5건 조회 ❗️
         *
         * ❗️ 각 eager member 주문 목록 조회 -> N + 1 문제❗️
         * Hibernate: select eagerorder0_.eager_id as eager_id3_1_0_, eagerorder0_.id as id1_1_0_, eagerorder0_.id as id1_1_1_, eagerorder0_.eager_id as eager_id3_1_1_, eagerorder0_.name as name2_1_1_ from eager_orders eagerorder0_ where eagerorder0_.eager_id=?
         * Hibernate: select eagerorder0_.eager_id as eager_id3_1_0_, eagerorder0_.id as id1_1_0_, eagerorder0_.id as id1_1_1_, eagerorder0_.eager_id as eager_id3_1_1_, eagerorder0_.name as name2_1_1_ from eager_orders eagerorder0_ where eagerorder0_.eager_id=?
         * Hibernate: select eagerorder0_.eager_id as eager_id3_1_0_, eagerorder0_.id as id1_1_0_, eagerorder0_.id as id1_1_1_, eagerorder0_.eager_id as eager_id3_1_1_, eagerorder0_.name as name2_1_1_ from eager_orders eagerorder0_ where eagerorder0_.eager_id=?
         * Hibernate: select eagerorder0_.eager_id as eager_id3_1_0_, eagerorder0_.id as id1_1_0_, eagerorder0_.id as id1_1_1_, eagerorder0_.eager_id as eager_id3_1_1_, eagerorder0_.name as name2_1_1_ from eager_orders eagerorder0_ where eagerorder0_.eager_id=?
         * Hibernate: select eagerorder0_.eager_id as eager_id3_1_0_, eagerorder0_.id as id1_1_0_, eagerorder0_.id as id1_1_1_, eagerorder0_.eager_id as eager_id3_1_1_, eagerorder0_.name as name2_1_1_ from eager_orders eagerorder0_ where eagerorder0_.eager_id=?
         */
        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAll();

        // then
        assertThat(eagerMembers.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (INNER JOIN) 페치조인 사용")
    void INNER_페치조인_즉시로딩_N_Plus_1() {

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllJoinFetch();

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
        assertThat(eagerMembers.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (LEFT OUTER JOIN) 페치조인 사용")
    void OUTER_페치조인_즉시로딩_N_Plus_1() {

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllLeftOuterJoinFetch();

        // then
        assertThat(eagerMembers.size()).isEqualTo(5);
    }


    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (LEFT OUTER JOIN) 엔티티 그래프 사용")
    void OUTER_엔티티그래프_즉시로딩_N_Plus_1() {

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllEntityGraph();

        // then
        assertThat(eagerMembers.size()).isEqualTo(5);
    }

}