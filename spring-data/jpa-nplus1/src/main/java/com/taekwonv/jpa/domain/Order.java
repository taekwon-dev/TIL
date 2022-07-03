package com.taekwonv.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    protected Order() {
    }

    public Order(Member member) {
        this.member = member;
    }

    public void updateMember(Member member) {
        this.member = member;
    }
}
