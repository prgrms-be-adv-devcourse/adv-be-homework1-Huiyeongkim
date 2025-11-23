package com.example.homework.order.presentation;

import com.example.homework.common.ResponseEntity;
import com.example.homework.order.application.OrderService;
import com.example.homework.order.application.dto.PurchaseOrderInfo;
import com.example.homework.order.presentation.dto.PurchaseOrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Operation(summary = "주문 목록 조회", description = "생성된 주문을 페이지 단위로 조회한다.")
    @GetMapping
    public ResponseEntity<List<PurchaseOrderInfo>> findAll(Pageable pageable) {
        return orderService.findAll(pageable);
    }

}