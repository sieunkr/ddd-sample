package com.example.order.infrastructure.persistence;

import com.example.order.domain.model.order.Order;
import com.example.order.domain.model.order.OrderNo;
import com.example.order.domain.model.order.OrderRepository;
import com.example.order.infrastructure.persistence.jpa.OrderJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SimpleOrderRepository implements OrderRepository {

    private final OrderJPARepository orderJPARepository;

    @Override
    public Optional<Order> findById(OrderNo id) {

        //매퍼 클래스를 만들어서 변환해주는게 좋을 듯
        //TODO: 매핑 구현 
        //orderJPARepository.findById(id);


        return Optional.empty();
    }

    @Override
    public void save(Order order) {

    }
}
