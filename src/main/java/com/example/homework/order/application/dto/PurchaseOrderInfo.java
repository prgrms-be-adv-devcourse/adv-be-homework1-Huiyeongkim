package com.example.homework.order.application.dto;

import com.example.homework.order.domain.PurchaseOrder;
import com.example.homework.order.domain.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseOrderInfo(
        UUID id,
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status
) {
    public static PurchaseOrderInfo from(PurchaseOrder saved) {
        return new PurchaseOrderInfo(
                saved.getId(), saved.getProductId(), saved.getSellerId(), saved.getMemberId(), saved.getAmount(), saved.getStatus()
        );
    }
}
