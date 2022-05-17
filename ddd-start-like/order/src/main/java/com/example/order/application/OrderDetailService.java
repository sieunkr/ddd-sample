package com.example.order.application;

import com.example.order.domain.model.order.Order;
import com.example.order.domain.model.order.OrderNo;
import com.example.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderRepository orderRepository;

    //TODO: 스터디 설명을 위해서 임시로 작성한 코드
    @Transactional
    public OrderDTO getOrderDetail(final String orderNumber) {

        Optional<Order> optOrder = orderRepository.findById(new OrderNo(orderNumber));

        return optOrder
                .map(order -> OrderDTO.builder()
                        .number(order.getNumber().getNumber())
                        //TODO
                        .build()
                )
                .orElseThrow();
    }

}
