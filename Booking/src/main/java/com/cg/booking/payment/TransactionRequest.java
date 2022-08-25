package com.cg.booking.payment;

import com.cg.booking.model.Booking;

public class TransactionRequest {

	private Booking booking;
	private Payment payment;

	public TransactionRequest() {
		super();
	}

	public TransactionRequest(Booking booking, Payment payment) {
		super();
		this.booking = booking;
		this.payment = payment;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "TransactionRequest [booking=" + booking + ", payment=" + payment + "]";
	}
}
