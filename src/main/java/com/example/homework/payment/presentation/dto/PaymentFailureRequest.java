package com.example.homework.payment.presentation.dto;

import com.example.homework.payment.application.dto.PaymentFailureCommand;

public record PaymentFailureRequest(
        String orderId,
        String paymentKey,
        String code,
        String message,
        Long amount,
        String rawPayload
) {
    public PaymentFailureCommand toCommand() {
        return new PaymentFailureCommand(orderId, paymentKey, code, message, amount, rawPayload);
    }
}
