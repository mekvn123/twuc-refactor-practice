package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
	private static final String PRINTING_ORDERS = "======Printing Orders======\n";
	private static final String SALES_TAX = "Sales Tax\t";
	private static final String TOTAL_AMOUNT = "Total Amount\t";
	private static final double TAX_RATE = .10d;
	private Order order;

	public OrderReceipt(Order order) {
		this.order = order;
	}

	public String printReceipt() {
		StringBuilder receipt = new StringBuilder();
		double totalPrice = order.getGoodItemList().stream().mapToDouble(GoodItem::totalItemPrice).sum();
		double totalSalesTax = totalPrice * TAX_RATE;
		double totalPayAmount = totalPrice + totalSalesTax;
		receipt.append(PRINTING_ORDERS);
		receipt.append(order.toString());
		receipt.append(SALES_TAX).append(totalSalesTax);
		receipt.append(TOTAL_AMOUNT).append(totalPayAmount);
		return receipt.toString();
	}
}