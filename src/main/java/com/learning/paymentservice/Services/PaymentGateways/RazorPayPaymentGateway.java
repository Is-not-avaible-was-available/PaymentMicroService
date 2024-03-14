package com.learning.paymentservice.Services.PaymentGateways;

import com.learning.paymentservice.Services.RazorPayClientConfig;
import com.razorpay.*;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;

@Service
public class RazorPayPaymentGateway implements PaymentGateway{
    private final RazorPayClientConfig razorPayClientConfig;

    public RazorPayPaymentGateway(RazorPayClientConfig razorPayClientConfig) {
        this.razorPayClientConfig = razorPayClientConfig;
    }

    @Override
    public String generateLink() {
        RazorpayClient razorpayClient = razorPayClientConfig.getRazorPayClient();

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1710527804);
        paymentLinkRequest.put("reference_id","TS1999");
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","Rajat Yadav");
        customer.put("contact","+917987643689");
        customer.put("email","yadraj1803@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.google.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link =null;

        try {
            link = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return link.toString();
    }

    public String generateUpiPaymentLink(){

        RazorpayClient razorpayClient = razorPayClientConfig.getRazorPayClient();

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("upi_link",true);
        paymentLinkRequest.put("amount",10000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","Rajat Yadav");
        customer.put("contact","+917987643689");
        customer.put("email","yadraj1803@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);

        PaymentLink paymentLink = null;

        try {
            paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return paymentLink.toString();
    }
}
