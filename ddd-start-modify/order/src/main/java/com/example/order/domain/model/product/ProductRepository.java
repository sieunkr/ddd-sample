package com.example.order.domain.model.product;

import com.example.order.domain.model.product.Product;
import com.example.order.domain.model.product.ProductId;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(ProductId id);

}
