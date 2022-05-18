package com.example.order.infrastructure.persistence.jpa;

import com.example.order.domain.model.order.Order;
import com.example.order.domain.model.order.OrderNo;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public interface OrderJPARepository extends Repository<OrderJPAEntity, OrderNo> {

    Optional<Order> findById(OrderNo id);

    void save(Order order);

    default OrderNo nextOrderNo() {
        int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
        String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
        return new OrderNo(number);
    }
}

