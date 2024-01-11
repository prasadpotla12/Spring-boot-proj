package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.common.Payment;
import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.dao.OrderRepository;
import com.order.entity.Order;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}*/
	
	public TransactionResponse saveOrder(TransactionRequest txReq) {
		String mesg = "";
		Order order = txReq.getOrder();
		Payment payment = txReq.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//Payment paymentResponse =restTemplate.postForObject("http://localhost:8002/payment/doPayment", payment, Payment.class);
		Payment paymentResponse =restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);

		mesg = paymentResponse.getPaymentStatus().equals("success")?"Payment success":"Payment failure";
		
		 orderRepository.save(order);
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),mesg);
	}
}
