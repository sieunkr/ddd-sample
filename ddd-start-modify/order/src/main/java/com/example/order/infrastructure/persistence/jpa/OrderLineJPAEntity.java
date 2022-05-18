package com.example.order.infrastructure.persistence.jpa;

import com.example.order.domain.model.common.Money;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public class OrderLineJPAEntity {

    @Column(name = "product_id")
    private String productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;
}
