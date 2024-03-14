package com.learning.paymentservice.Controller;

import com.learning.paymentservice.DTO.InitiatePaymentDTO;
import com.learning.paymentservice.Services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentDTO initiatePaymentDTO){
        return paymentService.generatePaymentLink();
    }

    @PostMapping("/UPI")

    public String initiatePayment(){
        return paymentService.generateUpiPaymentLink();
    }
}
