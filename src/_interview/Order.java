package _interview;

import java.util.Date;

public class Order {
	
	private int OrderId;
	private int userId;
	private Date timeStamp;
	private int amount;
	
	public Order(int orderId, int userId, Date timeStamp, int amount) {
		super();
		OrderId = orderId;
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.amount = amount;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	} 
	
	
	
}
