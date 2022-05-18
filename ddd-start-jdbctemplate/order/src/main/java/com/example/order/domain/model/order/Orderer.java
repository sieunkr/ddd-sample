package com.example.order.domain.model.order;

import com.example.order.domain.model.member.MemberId;

import java.util.Objects;

public class Orderer {

    private MemberId memberId;

    private String name;

    protected Orderer() {
    }

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderer orderer = (Orderer) o;
        return Objects.equals(memberId, orderer.memberId) &&
                Objects.equals(name, orderer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name);
    }
}
