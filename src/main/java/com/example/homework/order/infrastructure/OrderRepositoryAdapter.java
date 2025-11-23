package com.example.homework.order.infrastructure;

import com.example.homework.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

}
