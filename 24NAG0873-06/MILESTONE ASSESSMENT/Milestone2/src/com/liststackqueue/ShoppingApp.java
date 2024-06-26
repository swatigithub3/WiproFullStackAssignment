package com.liststackqueue;
import java.util.LinkedList;

public class ShoppingApp {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		PurchaseHistory history = new PurchaseHistory();
		CustomerService service = new CustomerService();
		cart.addItem("Laptop");
		cart.addItem("Smartphone");
		cart.viewCart();
		cart.removeItem("Smartphone");
		cart.viewCart();
		history.saveCart(cart.getCartItems());
		cart.addItem("Headphones");
		history.saveCart(cart.getCartItems());
		history.viewPurchaseHistory();
		LinkedList<String> lastCart = history.undoLastPurchase();
		if(lastCart != null) {
			System.out.println("Restored cart: " + lastCart);
		}
		service.addRequest("Refund for order #1234");
		service.addRequest("Change shipping address");
		service.viewPendingRequests();
		service.processNextRequest();
		service.viewPendingRequests();
		

	}

}
