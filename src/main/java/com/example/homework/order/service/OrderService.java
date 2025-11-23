package com.example.homework.order.service;


import com.example.homework.order.entity.PurchaseOrder;
import com.example.homework.order.entity.PurchaseOrderStatus;
import com.example.homework.order.entity.ResponseEntity;
import com.example.homework.order.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository jpaRepository;

    public ResponseEntity<PurchaseOrder> create(PurchaseOrder request) {
        request.setSellerId(UUID.randomUUID());
        request.setMemberId(UUID.randomUUID());
        request.setProductId(UUID.randomUUID());
        return new ResponseEntity<>(HttpStatus.CREATED.value(), jpaRepository.save(request), 1);
    }

    public ResponseEntity<List<PurchaseOrder>> findAll(Pageable pageable) {
        Page<PurchaseOrder> page = jpaRepository.findAll(pageable);
        List<PurchaseOrder> orderInfos = page.stream()
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(), orderInfos, page.getTotalElements());
    }

    public ResponseEntity<PurchaseOrder> statusChange(UUID id, PurchaseOrderStatus status) {
        Optional<PurchaseOrder> order = jpaRepository.findById(id);
        if (order.isPresent()) {
            PurchaseOrder item = order.get();
            item.setStatus(status);
            return new ResponseEntity<>(HttpStatus.OK.value(), jpaRepository.save(item), 1);
        } else throw new IllegalArgumentException("order not found id : "+id);
    }

}
