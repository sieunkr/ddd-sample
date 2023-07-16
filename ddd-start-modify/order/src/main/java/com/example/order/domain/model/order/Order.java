package com.example.order.domain.model.order;

import com.example.order.domain.model.base.AggregateRoot;
import com.example.order.domain.model.common.Events;
import com.example.order.domain.model.common.Money;
import com.example.order.domain.model.product.Product;
import com.example.order.domain.model.product.ProductId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements AggregateRoot {

    private OrderNo number;
    private long version;
    private Orderer orderer;
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState state;
    private LocalDateTime orderDate;


    //private ProductId productId; //설명을 위해 임시로 넣은 코드.. 실제로는 orderLines 에 상품 정보가 있음

    protected Order() {
    }

    public Order(OrderNo number, Orderer orderer, List<OrderLine> orderLines,
                 ShippingInfo shippingInfo, OrderState state) {
        setNumber(number);
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
        this.orderDate = LocalDateTime.now();
        Events.raise(new OrderPlacedEvent(number.getNumber(), orderer, orderLines, orderDate));
    }

    private void setNumber(OrderNo number) {
        if (number == null) throw new IllegalArgumentException("no number");
        this.number = number;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) throw new IllegalArgumentException("no shipping info");
        this.shippingInfo = shippingInfo;
    }

    public OrderNo getNumber() {
        return number;
    }

    public long getVersion() {
        return version;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public Money getTotalAmounts() {
        return totalAmounts;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public OrderState getState() {
        return state;
    }

    /* public 메서드로 setter 를 남용하지 말자
    public void setShippingInfo(ShippingInfo shippingInfo) {
    }
    */
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
        Events.raise(new ShippingInfoChangedEvent(number, newShippingInfo));
    }

    //주문 취소는 Order 엔티티의 책임
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;


        //Events.raise(new OrderCanceledEvent(number.getNumber()));
    }

    private void verifyNotYetShipped() {
        if (!isNotYetShipped())
            throw new AlreadyShippedException();
    }

    public boolean isNotYetShipped() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public boolean matchVersion(long version) {
        return this.version == version;
    }

    public void startShipping() {
        verifyShippableState();
        this.state = OrderState.SHIPPED;
        Events.raise(new ShippingStartedEvent(number.getNumber()));
    }

    private void verifyShippableState() {
        verifyNotYetShipped();
        verifyNotCanceled();
    }

    private void verifyNotCanceled() {
        if (state == OrderState.CANCELED) {
            throw new OrderAlreadyCanceledException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        //TODO:number 식별자를 비교해서 동일한 주문인지 비교할 수 있다.



        return true;
    }

    /*
    public ProductId getProductId() {
        return productId;
    }

     */
}
