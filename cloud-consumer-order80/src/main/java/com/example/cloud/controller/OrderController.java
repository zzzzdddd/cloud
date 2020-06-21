package com.example.cloud.controller;

import com.example.cloud.entity.CommentResult;
import com.example.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    private final static String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL+ "/payment/get/"+ id,CommentResult.class);
    }

    @GetMapping("/payment/insert")
    public CommentResult insert(Payment payment){
        return restTemplate.postForObject(URL + "/payment/insert",payment,CommentResult.class);
    }
}
