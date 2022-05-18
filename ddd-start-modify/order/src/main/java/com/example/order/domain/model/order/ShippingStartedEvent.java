package com.example.order.domain.model.order;

public class ShippingStartedEvent {
    private String orderNumber;

    public ShippingStartedEvent(String number) {
        this.orderNumber = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
