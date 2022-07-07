package com.taekwonv.jpa.domain.lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LAZY_MEMBER")
public class LazyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "lazyMember", fetch = FetchType.LAZY)
    private List<LazyOrder> lazyOrders = new ArrayList<>();

    protected LazyMember() {
    }

    public LazyMember(String name) {
        this.name = name;
    }
}
