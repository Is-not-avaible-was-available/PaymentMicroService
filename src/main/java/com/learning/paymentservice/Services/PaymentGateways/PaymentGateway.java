package com.learning.paymentservice.Services.PaymentGateways;

import org.springframework.stereotype.Service;

public interface PaymentGateway {

    public String generateLink();

    public String generateUpiPaymentLink();
}
