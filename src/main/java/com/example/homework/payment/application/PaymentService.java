package com.example.homework.payment.application;

import com.example.homework.common.ResponseEntity;
import com.example.homework.payment.application.dto.PaymentInfo;
import com.example.homework.payment.domain.Payment;
import com.example.homework.payment.domain.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public ResponseEntity<List<PaymentInfo>> findAll(Pageable pageable) {
        Page<Payment> page = paymentRepository.findAll(pageable);
        List<PaymentInfo> paymentInfos = page.stream()
                .map(PaymentInfo::from)
                .toList();

        return new ResponseEntity<>(HttpStatus.OK.value(), paymentInfos, page.getTotalElements());
    }
}
