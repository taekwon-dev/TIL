package com.taekwonv.jpa.repository;

import com.taekwonv.jpa.domain.eager.EagerMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EagerMemberRepository extends JpaRepository<EagerMember, Long> {

    @Query("SELECT em FROM EagerMember em")
    List<EagerMember> findAll();

    @Query("SELECT em FROM EagerMember em JOIN FETCH em.eagerOrders")
    List<EagerMember> findAllJoinFetch();

    @Query("SELECT em FROM EagerMember em LEFT OUTER JOIN FETCH em.eagerOrders")
    List<EagerMember> findAllLeftOuterJoinFetch();

    @Query("SELECT DISTINCT em FROM EagerMember em LEFT OUTER JOIN FETCH em.eagerOrders")
    List<EagerMember> findAllLeftOuterJoinFetchWithDistinct();

    @EntityGraph(attributePaths = "eagerOrders")
    @Query("SELECT em FROM EagerMember em")
    List<EagerMember> findAllEntityGraph();

}
