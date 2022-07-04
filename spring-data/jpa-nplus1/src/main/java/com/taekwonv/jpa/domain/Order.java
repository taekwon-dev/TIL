package com.taekwonv.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    protected Order() {
    }

    public Order(Long id, Member member) {
        this.id = id;
        this.member = member;
    }

    public void updateMember(Member member) {
        this.member = member;
    }
}
