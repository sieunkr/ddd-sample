package com.example.order.application;

import com.example.order.domain.model.order.Order;
import com.example.order.domain.model.order.OrderNo;
import com.example.order.domain.model.order.ShippingInfo;
import com.example.order.domain.model.product.Product;
import com.example.order.domain.model.order.OrderRepository;
import com.example.order.domain.model.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private ProductRepository productRepository;

    /*
    public List<ProductDTO> searchProducts(String keyword) {

        List<Product> products = productRepository...
        //keyword 로 상품 리스트를 조회, repository 에서 도메인 객체 가져옴

        //products 를 productDTOS 로 매핑해서 반환
        return productDTOS;
    }
     */


    private final OrderRepository orderRepository;

    public void updateShippingAddress(String orderNumber, ShippingInfo shippingInfo) {

        Order order = orderRepository.findById(new OrderNo(orderNumber)).orElseThrow();
        //도메인 엔티티에 비즈니스 로직을 위임
        //이미 배송되었는지 여부를 changeShippingInfo 메서드의 verifyNotYetShipped 에서 체크
        order.changeShippingInfo(shippingInfo);


        /*
        도메인 주도 설계 이론에는 맞지 않음
        만약..아래와 같이 유효성 체크를 애플리케이션 서비스 에서 한다면?
        도메인 비즈니스 로직이 다수의 애플리케이션 서비스에서 분산되어 사용될 수 있다.
        if(!(order.getState() == OrderState.PREPARING)) {
            order.changeShippingInfo(shippingInfo);
        }
        */
    }

    /*
    public void updateShippingAddress(String orderNumber) {

        //애그리거트 루트가 아닌 객체에서, 애그리거트에 속한 객체(배송정보)를 직접 변경하는 구문은 적합하지 않다.
        Order order = orderRepository.findById(new OrderNo(orderNumber)).orElseThrow();
        ShippingInfo shippingInfo = order.getShippingInfo();
        shippingInfo.setAddress();
    }
     */
}
