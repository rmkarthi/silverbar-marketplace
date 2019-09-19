package com.silverbar.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.silverbar.model.Order;
import com.silverbar.model.OrderSummary;

public class LiveOrderBoard {

	private Set<Order> ordersSet = new HashSet<>();
	SummaryService serviceOrders = new SummaryService();

	public void registerOrder(Order order) {
		if (!ordersSet.contains(order.getUserId())) {
			ordersSet.add(order);
		}
	}

	public void cancelOrder(Order order) {
		boolean userOrderPresent = ordersSet.contains(order.getUserId());
		if (userOrderPresent) {
			ordersSet.remove(order);
		}
	}

	public List<OrderSummary> getOrdersSummary(List<Order> orders, Order orderType) {
		return serviceOrders.getSummaryListAllOrders(orders, orderType);
	}
}