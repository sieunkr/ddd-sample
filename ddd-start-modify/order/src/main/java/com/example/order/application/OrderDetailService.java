package com.example.order.application;

import com.example.order.domain.model.order.Order;
import com.example.order.domain.model.order.OrderNo;
import com.example.order.domain.model.order.OrderRepository;
import com.example.order.domain.model.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderDTO getOrderDetail(final String orderNumber) {

        Order order = orderRepository.findById(new OrderNo(orderNumber)).orElseThrow();
        //Product product = productRepository.findById(order.getProductId()).orElseThrow();
        return OrderDTO.builder()
                        .number(order.getNumber().getNumber())
                        //TODO
                        .build();
    }

}
