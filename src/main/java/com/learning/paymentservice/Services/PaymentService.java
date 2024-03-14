package com.learning.paymentservice.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }

    public String generatePaymentLink(){

        return paymentGatewayChooserStrategy.getBestPaymentGateway().generateLink();
    }

    public String generateUpiPaymentLink(){
        return paymentGatewayChooserStrategy.getBestPaymentGateway().generateUpiPaymentLink();
    }
}
