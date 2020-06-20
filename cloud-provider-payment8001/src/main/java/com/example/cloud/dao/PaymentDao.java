package com.example.cloud.dao;

import com.example.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
