package com.example.homework.order.repository;

import com.example.homework.order.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<PurchaseOrder, UUID> {
}
