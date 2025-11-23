package com.example.homework.order.infrastructure;

import com.example.homework.order.domain.OrderRepository;
import com.example.homework.order.domain.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return orderJpaRepository.save(purchaseOrder);
    }
}
