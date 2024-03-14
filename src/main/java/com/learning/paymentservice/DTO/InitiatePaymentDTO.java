package com.learning.paymentservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDTO {
    private int price;
    private String currency;
    private String description;
}
