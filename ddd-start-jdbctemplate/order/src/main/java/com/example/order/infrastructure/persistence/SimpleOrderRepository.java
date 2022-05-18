package com.example.order.infrastructure.persistence;

import com.example.order.domain.model.common.Address;
import com.example.order.domain.model.member.MemberId;
import com.example.order.domain.model.order.*;
import com.example.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SimpleOrderRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Order> findById(OrderNo id) {

        //JdbcTemplate 사용해서 퍼시스턴스 데이터 조회
        //실무에서는 JdbcTemplate 사용 거의 안함

        return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM purchase_order WHERE order_number = ?",
                    mapper,
                    new Object[]{id.getNumber()}
                )
        );
    }

    @Override
    public void save(Order order) {

    }

    static RowMapper<Order> mapper = (rs, rowNum) -> new Order(
            new OrderNo(rs.getString("order_number")),
            new Orderer(new MemberId(rs.getString("orderer_id")), rs.getString("orderer_name")),
            Collections.emptyList(), //TODO
            new ShippingInfo(
                    new Address(rs.getString("shipping_addr1"), rs.getString("shipping_addr2"), rs.getString("order_number")),
                    rs.getString("shipping_message"),
                    new Receiver(rs.getString("receiver_name"), rs.getString("receiver_phone"))),
            OrderState.SHIPPED //TODO
            );
}
