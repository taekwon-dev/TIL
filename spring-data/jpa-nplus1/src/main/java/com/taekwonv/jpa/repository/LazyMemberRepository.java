package com.taekwonv.jpa.repository;

import com.taekwonv.jpa.domain.eager.EagerMember;
import com.taekwonv.jpa.domain.lazy.LazyMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LazyMemberRepository extends JpaRepository<LazyMember, Long> {

    @Query("SELECT lm FROM LazyMember lm")
    List<LazyMember> findAll();

    @Query("SELECT lm FROM LazyMember lm JOIN FETCH lm.lazyOrders")
    List<LazyMember> findAllJoinFetch();

    @Query("SELECT lm FROM LazyMember lm LEFT OUTER JOIN FETCH lm.lazyOrders")
    List<LazyMember> findAllLeftOuterJoinFetch();

    @EntityGraph(attributePaths = "lazyOrders")
    @Query("SELECT lm FROM LazyMember lm")
    List<LazyMember> findAllEntityGraph();

}
