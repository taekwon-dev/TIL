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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void init() {
        List<Member> members = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            Member member = new Member("Member " + i);
            member.addOrders(new Order((long) i, member));
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
    void 멤버_주문_즉시로딩_N_Plus_1() {

        /**
         *  Hibernate: select member0_.id as id1_0_, member0_.name as name2_0_ from member member0_
         *
         *  Hibernate: select orders0_.member_id as member_i2_1_0_, orders0_.id as id1_1_0_, orders0_.id as id1_1_1_, orders0_.member_id as member_i2_1_1_ from orders orders0_ where orders0_.member_id=?
         *  Hibernate: select orders0_.member_id as member_i2_1_0_, orders0_.id as id1_1_0_, orders0_.id as id1_1_1_, orders0_.member_id as member_i2_1_1_ from orders orders0_ where orders0_.member_id=?
         *  Hibernate: select orders0_.member_id as member_i2_1_0_, orders0_.id as id1_1_0_, orders0_.id as id1_1_1_, orders0_.member_id as member_i2_1_1_ from orders orders0_ where orders0_.member_id=?
         *  Hibernate: select orders0_.member_id as member_i2_1_0_, orders0_.id as id1_1_0_, orders0_.id as id1_1_1_, orders0_.member_id as member_i2_1_1_ from orders orders0_ where orders0_.member_id=?
         *  Hibernate: select orders0_.member_id as member_i2_1_0_, orders0_.id as id1_1_0_, orders0_.id as id1_1_1_, orders0_.member_id as member_i2_1_1_ from orders orders0_ where orders0_.member_id=?
         */

        // given
        List<Member> members = memberRepository.findAll();

        // then
        Assertions.assertThat(members.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("N + 1 해결 - Fetch Join - 멤버(일) & 주문(다) - 즉시 로딩 관계")
    void 멤버_주문_즉시로딩_N_Plus_1_Fetch_Join() {
        // given
        List<Member> members = memberRepository.findALLJoinFetch();

        // then
        Assertions.assertThat(members.size()).isEqualTo(0);
    }


    @Test
    @DisplayName("N + 1 - 팀(일) & 멤버(다) - 지연 로딩 관계")
    void 팀_회원_지연로딩_N_Plus_1() {
    }


}