package com.example.homework.order.presentation;

import com.example.homework.common.ResponseEntity;
import com.example.homework.order.application.OrderService;
import com.example.homework.order.application.dto.PurchaseOrderInfo;
import com.example.homework.order.presentation.dto.PurchaseOrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.v1}/orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "주문 생성", description = "상품과 구매자 정보를 바탕으로 주문을 생성한다.")
    @PostMapping
    public ResponseEntity<PurchaseOrderInfo> create(@RequestBody PurchaseOrderRequest request) {
        return orderService.create(request.toCommand());
    }

}