package com.learning.paymentservice.Services;

import com.learning.paymentservice.Services.PaymentGateways.PaymentGateway;
import com.learning.paymentservice.Services.PaymentGateways.RazorPayPaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {

    private final RazorPayPaymentGateway razorPayPaymentGateway;

    public PaymentGatewayChooserStrategy(RazorPayPaymentGateway razorPayPaymentGateway) {
        this.razorPayPaymentGateway = razorPayPaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway(){
        return razorPayPaymentGateway;
    }
}
