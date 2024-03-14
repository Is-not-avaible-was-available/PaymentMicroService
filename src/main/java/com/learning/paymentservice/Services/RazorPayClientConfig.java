package com.learning.paymentservice.Services;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayClientConfig {
    @Value("${razorpay.key.id}")
    private String clientKey;
    @Value("${razorpay.key.secret}")

    private String clientSecret;


    public RazorpayClient getRazorPayClient(){
        try {
            return new RazorpayClient(clientKey, clientSecret);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
