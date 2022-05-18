package com.example.order.web;

import com.example.order.application.OrderDTO;
import com.example.order.application.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderDetailService orderDetailService;


    @GetMapping("/order/1")
    public OrderDTO test() {
        return orderDetailService.getOrderDetail("1");
    }

}
