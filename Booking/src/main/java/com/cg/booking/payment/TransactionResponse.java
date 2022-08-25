package com.cg.booking.payment;

import com.cg.booking.model.Booking;

public class TransactionResponse {
	private Booking booking;
	private String transactionId;
	private String message;
	private Long referenceNumber;

	public TransactionResponse() {
		super();
	}

	public TransactionResponse(Booking booking, String transactionId, String message, Long referenceNumber) {
		super();
		this.booking = booking;
		this.transactionId = transactionId;
		this.message = message;
		this.referenceNumber = referenceNumber;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "TransactionResponse [booking=" + booking + ", transactionId=" + transactionId + ", message=" + message
				+ ", referenceNumber=" + referenceNumber + "]";
	}
}
