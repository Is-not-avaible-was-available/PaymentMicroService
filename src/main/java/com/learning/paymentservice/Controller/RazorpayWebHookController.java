package com.learning.paymentservice.Controller;

import com.razorpay.Webhook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpaywebhook")
public class RazorpayWebHookController {

    @PostMapping
    public void handleWebHook(){
        System.out.println();
    }
}
