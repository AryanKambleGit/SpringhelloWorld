package com.example.RazorPaymentTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RazorPaymentTrialApplication  implements CommandLineRunner {


	//1) THis is first
	//private RazorPay razorPay = new RazorPay();


	//2) This is Second Using Constructor Depedency Injection
	//private RazorPay razorPay;
//
//	public RazorPaymentTrialApplication(RazorPay razorPay) {
//		this.razorPay = razorPay;
//
//	}

	//3) USing
//	@Autowired
//	private  RazorPay razorPay;
//
		public static void main(String[] args) {
			SpringApplication.run(RazorPaymentTrialApplication.class, args);
		}

 		private final PaymentService paymentService;

		@Autowired
		public RazorPaymentTrialApplication(PaymentService paymentService) {
			this.paymentService = paymentService;
		}

	@Override
	public void run(String... args) throws Exception{
		String payment = paymentService.pay(); // by using other file payment done
		System.out.println("From main metthod payment done ");
		System.out.println(payment);
	}



}
