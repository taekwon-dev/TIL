package com.taekwonv.jpa.domain.eager;

import javax.persistence.*;

@Entity
@Table(name = "EAGER_ORDERS")
public class EagerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "eager_id")
    private EagerMember eagerMember;

    protected EagerOrder() {
    }

    public EagerOrder(String name) {
        this.name = name;
    }
}
