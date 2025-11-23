package com.example.homework.payment.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "결제 실패 엔티티")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "\"payment_failure\"", schema = "public")
public class PaymentFailure {

    @Id
    @Schema(description = "실패 기록 고유 식별자")
    private UUID id;

    @Schema(description = "주문 ID")
    @Column(name = "order_id", nullable = false, length = 100)
    private String orderId;

    @Schema(description = "결제 키")
    @Column(name = "payment_key", length = 200)
    private String paymentKey;

    @Schema(description = "에러 코드")
    @Column(name = "error_code", length = 50)
    private String errorCode;

    @Schema(description = "에러 메시지")
    @Column(name = "error_message")
    private String errorMessage;

    @Schema(description = "결제 시도 금액")
    @Column(name = "amount")
    private Long amount;

    @Schema(description = "원본 페이로드")
    @Column(name = "raw_payload")
    private String rawPayload;

    @Schema(description = "실패 기록 생성 일시")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    private PaymentFailure(String orderId,
                           String paymentKey,
                           String errorCode,
                           String errorMessage,
                           Long amount,
                           String rawPayload) {
        this.id = UUID.randomUUID();
        this.orderId = orderId;
        this.paymentKey = paymentKey;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.amount = amount;
        this.rawPayload = rawPayload;
    }

    public static PaymentFailure from(String orderId,
                                      String paymentKey,
                                      String errorCode,
                                      String errorMessage,
                                      Long amount,
                                      String rawPayload) {
        return new PaymentFailure(orderId, paymentKey, errorCode, errorMessage, amount, rawPayload);
    }

    @PrePersist
    public void onCreate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        createdAt = LocalDateTime.now();
    }
}