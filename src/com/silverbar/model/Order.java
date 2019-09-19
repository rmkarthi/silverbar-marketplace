package com.silverbar.model;

public class Order {

	private Integer userId;
	private double orderQty;
	private double pricePerKg;
	private OrderType orderType;

	public Order(Integer userId, double orderQty, double pricePerKg) {
		super();
		this.userId = userId;
		this.orderQty = orderQty;
		this.pricePerKg = pricePerKg;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(orderQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pricePerKg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (Double.doubleToLongBits(orderQty) != Double.doubleToLongBits(other.orderQty))
			return false;
		if (Double.doubleToLongBits(pricePerKg) != Double.doubleToLongBits(other.pricePerKg))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}