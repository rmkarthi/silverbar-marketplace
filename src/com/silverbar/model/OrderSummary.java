package com.silverbar.model;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {

	public OrderSummary() {
	}

	private List<Order> ordersList = new ArrayList<>();

	public double getPrice() {
		return ordersList.stream().findAny().get().getPricePerKg();
	}

	public double getQuantity() {
		return ordersList.stream().mapToDouble(Order::getOrderQty).sum();
	}

	public OrderType getOrderType() {
		return ordersList.stream().findAny().get().getOrderType();
	};

	public OrderSummary(List<Order> ordersList) {
		this.ordersList = ordersList;
	}

	public List<Order> getOrdersList() {
		return ordersList;
	}
}
