package com.example.cloud.service.impl;

import com.example.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPaymentById(Long id) {
        return "获取到了payment对象";
    }
}
