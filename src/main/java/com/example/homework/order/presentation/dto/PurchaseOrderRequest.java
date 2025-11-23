package com.example.homework.order.presentation.dto;

import com.example.homework.order.application.dto.PurchaseOrderCommand;
import com.example.homework.order.domain.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseOrderRequest(
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status
) {
    public PurchaseOrderCommand toCommand() {
        return new PurchaseOrderCommand(productId, sellerId, memberId, amount, status);
    }
}
