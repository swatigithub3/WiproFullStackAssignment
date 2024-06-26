package com.liststackqueue;
import java.util.LinkedList;

public class ShoppingCart {
	private LinkedList<String> cart;
	public ShoppingCart() {
		cart = new LinkedList<>();
	}
	public void addItem(String item) {
		cart.add(item);
		System.out.println(item + " added to the cart.");
	}
	public void removeItem(String item) {
		if(cart.remove(item)) {
			System.out.println(item + " removed from the cart.");
		} else {
			System.out.println(item + " is not in the cart.");
		}
	}
	public void viewCart() {
		if(cart.isEmpty()) {
			System.out.println("Your cart is empty.");
		} else {
			System.out.println("Items in your cart: " + cart);
		}
	}
	public LinkedList<String> getCartItems(){
		return new LinkedList<>(cart);
	}

}
