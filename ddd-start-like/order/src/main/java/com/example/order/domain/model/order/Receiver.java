package com.example.order.domain.model.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Receiver {

    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_phone")
    private String phone;

    public Receiver() {
    }

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
