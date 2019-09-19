package com.silverbar.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.silverbar.model.Order;
import com.silverbar.model.OrderSummary;

public class SummaryService {

	public List<OrderSummary> getSummaryListAllOrders(List<Order> ordersList, Order orderType) {

		List<OrderSummary> sortedOrdersListByType = new ArrayList<>();
		List<Order> ordersListComparator;

		if (orderType.getOrderType().equals("BUY")) {
			ordersListComparator = ordersList.stream().sorted(Comparator.comparing(Order::getPricePerKg))
					.collect(Collectors.toList());
			sortedOrdersListByType.addAll(buyOrders(ordersList, ordersListComparator));
		} else {
			ordersListComparator = ordersList.stream().sorted(Comparator.comparing(Order::getPricePerKg).reversed())
					.collect(Collectors.toList());
			sortedOrdersListByType.addAll(sellOrders(ordersList, ordersListComparator));
		}
		return sortedOrdersListByType;
	}

	private Collection<? extends OrderSummary> sellOrders(List<Order> ordersList, List<Order> ordersListComparator) {
		return ordersList.stream().filter(order -> "SELL".equals(order.getOrderType()))
				.collect(Collectors.groupingBy(Order::getPricePerKg)).values().stream().map(OrderSummary::new)
				.sorted((order1, order2) -> ((Comparator) ordersListComparator).compare(order1.getPrice(),
						order2.getPrice()))
				.collect(Collectors.toList());
	}

	private Collection<? extends OrderSummary> buyOrders(List<Order> ordersList, List<Order> ordersListComparator) {
		return ordersList.stream().filter(order -> "BUY".equals(order.getOrderType()))
				.collect(Collectors.groupingBy(Order::getPricePerKg)).values().stream().map(OrderSummary::new)
				.sorted((order1, order2) -> ((Comparator) ordersListComparator).compare(order1.getPrice(),
						order2.getPrice()))
				.collect(Collectors.toList());
	}

}