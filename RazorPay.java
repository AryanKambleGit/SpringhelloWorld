package com.example.RazorPaymentTrial;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;



@Component
@ConditionalOnProperty(name = "payment.stipe", havingValue = "razor")
public class RazorPay implements PaymentService {
    @Override
   public String pay(){
        String paymentChiString = "Payment done Razor Pay  ";

        return paymentChiString;

    }

}
