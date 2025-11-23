package com.example.homework.payment.presentation;

import com.example.homework.payment.application.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.v1}/payments")
public class PaymentController {

    private final PaymentService paymentService;
}
