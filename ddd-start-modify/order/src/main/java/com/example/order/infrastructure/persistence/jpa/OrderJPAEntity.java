package com.example.order.infrastructure.persistence.jpa;

import com.example.order.domain.model.common.Money;
import com.example.order.domain.model.order.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/*
    도메인 주도 설계 철학에 맞게 JPA엔티티와 도메인 객체 엔티티 클래스를 분리하는 방향으로 수정
    더 복잡해지는 듯;;
    ShippingInfo 같은 값객체도 별도로 분리하는게 좋을지?
    아니면, 도메인 객체를 그대로 사용해도 무방할지?
 */


@Entity
@Table(name = "purchase_order_modify")
@Access(AccessType.FIELD)
public class OrderJPAEntity {

    @Id
    @Column(name = "order_number")
    private String number;

    @Version
    private long version;

    @Column(name = "orderer_id")
    private String ordererId;

    @Column(name = "orderer_name")
    private String ordererName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line_modify", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLineJPAEntity> orderLines;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "total_amounts")
    private Money totalAmounts;

    //어색함..
    @Embedded
    private ShippingInfoJPAValueObject shippingInfo;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

}
