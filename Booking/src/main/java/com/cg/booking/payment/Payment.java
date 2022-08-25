package com.cg.booking.payment;

public class Payment {

	private String paymentStatus;
	private String transactionId;
	private String passengerName;
	private Long referenceNumber;

	public Payment() {
		super();
	}

	public Payment(String paymentStatus, String transactionId, String passengerName, Long referenceNumber) {
		super();
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.passengerName = passengerName;
		this.referenceNumber = referenceNumber;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "Payment [paymentStatus=" + paymentStatus + ", transactionId=" + transactionId + ", passengerName="
				+ passengerName + ", referenceNumber=" + referenceNumber + "]";
	}
}

