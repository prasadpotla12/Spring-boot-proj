package com.order.common;

import com.order.entity.Order;

public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionId;
	private String mesg;
	public TransactionResponse(Order order, double amount, String transactionId, String mesg) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.mesg = mesg;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	
	
	
}
