package com.example.order.domain.model.order;

import com.example.order.domain.model.common.Event;

public class OrderCanceledEvent extends Event {

    private String orderNumber;

    public OrderCanceledEvent(String number) {
        super();
        this.orderNumber = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
