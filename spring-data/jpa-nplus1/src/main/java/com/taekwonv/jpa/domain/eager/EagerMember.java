package com.taekwonv.jpa.domain.eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EAGER_MEMBER")
public class EagerMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "eagerMember", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<EagerOrder> eagerOrders = new ArrayList<>();

    protected EagerMember() {
    }

    public EagerMember(String name) {
        this.name = name;
    }
}
