package com.example.order.domain.model.order;

import com.example.order.domain.model.common.Address;

import javax.persistence.*;

public class ShippingInfo {

    private Address address;

    private String message;

    private Receiver receiver;

    public ShippingInfo() {
    }

    public ShippingInfo(Address address, String message, Receiver receiver) {
        this.address = address;
        this.message = message;
        this.receiver = receiver;
    }

    public Address getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

    public Receiver getReceiver() {
        return receiver;
    }
}
