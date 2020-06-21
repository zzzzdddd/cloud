package com.example.cloud.controller;

import com.example.cloud.entity.CommentResult;
import com.example.cloud.entity.Payment;
import com.example.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;

    @PostMapping("/insert")
    public CommentResult<Integer> insert(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        if (result > 0){
            return new CommentResult<>(200,port+"成功",result );
        }else {
            return new CommentResult<>(400,"失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("配置成功");
        if (payment != null){
            return new CommentResult<>(200,port+"成功", payment);
        }
        return new CommentResult<>(400,"失败");
    }

    @GetMapping("/discoverClient")
    public void getDiscoverClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId() + "  " + instance.getInstanceId() );
        }

    }
}
