package com.example.order.domain.model.order;

import com.example.order.domain.model.base.ValueObject;
import com.example.order.domain.model.catalog.ProductId;
import com.example.order.domain.model.common.Money;

public class OrderLine implements ValueObject {

    private ProductId productId;

    private Money price;

    private int quantity;

    private Money amounts;

    protected OrderLine() {
    }

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public ProductId getProductId() {
        return productId;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getAmounts() {
        return amounts;
    }
}
