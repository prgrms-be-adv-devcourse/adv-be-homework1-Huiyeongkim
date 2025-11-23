package com.example.homework.order.application.dto;

import com.example.homework.order.domain.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseOrderCommand(
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status
) {
}
