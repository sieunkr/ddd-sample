package com.example.order.domain.model.order;


public class Receiver {

    private String name;

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
