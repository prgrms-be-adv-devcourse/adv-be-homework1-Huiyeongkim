package com.example.homework.order.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepository {

    PurchaseOrder save(PurchaseOrder purchaseOrder);

    Page<PurchaseOrder> findAll(Pageable pageable);
}
