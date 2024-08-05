package com.aurionpro.model;

import java.util.List;

public class ShoppingCart {
	List<IItems> cartItems;

	public ShoppingCart(List<IItems> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public List<IItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<IItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addItemCart(List<IItems> items) {
		setCartItems(items);
	}
	
	public void getCartItems(List<IItems> items){
		for(IItems item: items) {
			System.out.println(item.getItemName());
		}
	}
	
	public double getCartPrice(List<IItems> items) {
		double totalPrice = 0;
		for(IItems item: items) {
			totalPrice += item.getItemPrice();
		}
		return totalPrice;
	}
	
	public void displayCart(List<IItems> items) {
		for(IItems item: items) {
			System.out.println(item.getItemName() + " "+ item.getItemPrice());
		}
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartItems=" + cartItems + "]";
	}
	
	
}
