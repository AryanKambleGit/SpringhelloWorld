package com.example.RazorPaymentTrial;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.stipe", havingValue = "stripe")
public class StripePay implements PaymentService{

    @Override
    public String pay(){

        String paymentChiString = "Payment done Stripe Pay  ";
        return paymentChiString;

    }

}
