package com.example.order.domain.service;

import com.example.order.domain.model.common.Money;
import com.example.order.domain.model.order.OrderLine;

import java.lang.reflect.Member;
import java.util.List;

public class DiscountCalculationDomainService {

    public Money calculateDiscountAmounts(List<OrderLine> orderLineList, Member member) {

        //TODO: 도메인 로직 수행

        return new Money(1000);
    }

}
