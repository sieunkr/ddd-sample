package com.example.order.infrastructure.persistence.jpa;

import com.example.order.domain.model.common.Address;
import com.example.order.domain.model.order.Receiver;

import javax.persistence.*;

@Embeddable
public class ShippingInfoJPAValueObject {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    //receiver 클래스는 아래와 같이 처리... 어색함
    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_phone")
    private String receiverPhone;

}
