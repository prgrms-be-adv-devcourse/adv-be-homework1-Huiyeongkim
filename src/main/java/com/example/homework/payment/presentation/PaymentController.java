package com.example.homework.payment.presentation;

import com.example.homework.common.ResponseEntity;
import com.example.homework.payment.application.PaymentService;
import com.example.homework.payment.application.dto.PaymentInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.v1}/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "결제 내역 조회", description = "확정된 결제 정보를 페이지 단위로 조회한다.")
    @GetMapping
    public ResponseEntity<List<PaymentInfo>> findAll(Pageable pageable) {
        return paymentService.findAll(pageable);
    }

}
