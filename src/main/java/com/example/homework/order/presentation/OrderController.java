package com.example.homework.order.presentation;

import com.example.homework.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.v1}/orders")
public class OrderController {

    private final OrderService orderService;

}