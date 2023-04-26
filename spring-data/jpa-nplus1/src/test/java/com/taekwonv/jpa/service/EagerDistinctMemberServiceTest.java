package com.taekwonv.jpa.service;

import com.taekwonv.jpa.domain.eager.EagerMember;
import com.taekwonv.jpa.domain.eager.EagerOrder;
import com.taekwonv.jpa.repository.EagerMemberRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EagerDistinctMemberServiceTest {

    @Autowired
    private EagerMemberRepository eagerMemberRepository;

    @BeforeEach
    public void init() {
        List<EagerMember> eagerMembers = new ArrayList<>();

        for (long i = 1; i <= 5; i++) {
            EagerMember em = new EagerMember("EM " + i);

            EagerOrder eo = new EagerOrder("EO " + i);
            EagerOrder eo2 = new EagerOrder("EO2 " + i);

            em.addEagerOrders(eo);
            em.addEagerOrders(eo2);
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
        assertThat(eagerMembers.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (LEFT OUTER JOIN) 페치조인 사용")
    void OUTER_페치조인_즉시로딩_N_Plus_1() {

        /**
         * select {EM.*, EO.*}
         * from eager_member
         * left outer join eager_orders
         * on eager_member.id = eagerorder.eager_id
         */

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllLeftOuterJoinFetch();

        // then
        assertThat(eagerMembers.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (LEFT OUTER JOIN) 페치조인 + Distinct 적용")
    void OUTER_페이조인_즉시로딩_N_Plus_1_Distinct() {

        /**
         * select {EM.*, EO.*}
         * from eager_member
         * left outer join eager_orders
         * on eager_member.id = eagerorder.eager_id
         */

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllLeftOuterJoinFetchWithDistinct();

        // then
        assertThat(eagerMembers.size()).isEqualTo(5);
    }


    /**
     * For Entity Graphs distinct applies by default. (https://stackoverflow.com/a/73348400)
     */
    @Test
    @DisplayName("N + 1 문제 해결 - 즉시 로딩 관계 - (LEFT OUTER JOIN) 엔티티 그래프 사용")
    void OUTER_엔티티그래프_즉시로딩_N_Plus_1() {

        /**
         * select {EM.*, EO.*}
         * from eager_member
         * left outer join eager_orders
         * on eager_member.id = eagerorder.eager_id
         */

        // given
        List<EagerMember> eagerMembers = eagerMemberRepository.findAllEntityGraph();

        // then
        assertThat(eagerMembers.size()).isEqualTo(5);
    }

}
