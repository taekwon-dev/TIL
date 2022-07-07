package com.taekwonv.jpa.domain.lazy;

import javax.persistence.*;

@Entity
@Table(name = "LAZY_ORDERS")
public class LazyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "lazy_id")
    private LazyMember lazyMember;

    protected LazyOrder() {
    }

    public LazyOrder(String name) {
        this.name = name;
    }
}
