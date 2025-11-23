package com.example.homework.order.application;

import com.example.homework.common.ResponseEntity;
import com.example.homework.order.application.dto.PurchaseOrderCommand;
import com.example.homework.order.application.dto.PurchaseOrderInfo;
import com.example.homework.order.domain.OrderRepository;
import com.example.homework.order.domain.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<PurchaseOrderInfo> create(PurchaseOrderCommand command) {
        PurchaseOrder purchaseOrder = PurchaseOrder.create(
                command.productId(), command.sellerId(),
                command.memberId(), command.amount(), command.status());
        PurchaseOrder saved = orderRepository.save(purchaseOrder);
        return new ResponseEntity<>(HttpStatus.CREATED.value(), PurchaseOrderInfo.from(saved), 1);
    }
}
