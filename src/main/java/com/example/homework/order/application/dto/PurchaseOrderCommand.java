package com.example.homework.order.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseOrderCommand(
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount
) {
}
