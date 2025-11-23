package com.example.homework.order.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "구매 주문 엔티티")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "\"purchase_order\"", schema = "public")
public class PurchaseOrder {

    @Schema(description = "주문 고유 식별자")
    @Id
    private UUID id;

    @Schema(description = "상품 고유 식별자")
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Schema(description = "판매자 고유 식별자")
    @Column(name = "seller_id", nullable = false)
    private UUID sellerId;

    @Schema(description = "구매자 고유 식별자")
    @Column(name = "member_id", nullable = false)
    private UUID memberId;

    @Schema(description = "주문 금액")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Schema(description = "주문 상태")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PurchaseOrderStatus status;

    @Schema(description = "주문 생성 일시")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Schema(description = "주문 수정 일시")
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public void markPaid() {
        this.status = PurchaseOrderStatus.PAID;
    }

    private PurchaseOrder(UUID id,
                          UUID productId,
                          UUID sellerId,
                          UUID memberId,
                          BigDecimal amount) {
        this.id = id;
        this.productId = productId;
        this.sellerId = sellerId;
        this.memberId = memberId;
        this.amount = amount;
    }

    public static PurchaseOrder create(
            UUID productId,
            UUID sellerId,
            UUID memberId,
            BigDecimal amount) {
        return new PurchaseOrder(UUID.randomUUID(), productId,sellerId, memberId, amount);
    }

    public void changeStatus(PurchaseOrderStatus status) {
        this.status = status;
    }

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if (id == null) {
            id = UUID.randomUUID();
        }
        createdAt = now;
        updatedAt = now;
        if (status == null) {
            status = PurchaseOrderStatus.CREATED;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
