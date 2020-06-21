package com.example.cloud.service;

import com.example.cloud.entity.CommentResult;
import com.example.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @PostMapping("/payment/insert")
    CommentResult<Integer> insert(Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
