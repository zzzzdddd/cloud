package com.example.cloud.controller;

import com.example.cloud.entity.CommentResult;
import com.example.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/get/{id}")
    public String getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
}
