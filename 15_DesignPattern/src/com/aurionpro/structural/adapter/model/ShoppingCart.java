package com.aurionpro.structural.adapter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class ShoppingCart {
	List<IItems> items ;

	public ShoppingCart(List<IItems> items) {
		super();
		this.items = items;
	}

	public List<IItems> getItems() {
		return items;
	}

	public void setItems(List<IItems> items) {
		this.items = items;
	}
	
	public void addItemsToCart(List<IItems> items) {
		setItems(items);
	}
	
	public void getCartItems(List<IItems> items) {
		for(IItems item: items) {
			System.out.println(item.getItemName());
		}
	}	
	
	public double  getCartPrice(List<IItems> items) {
		DoubleStream prices= items.stream().mapToDouble((item) -> item.getItemPrice());
		double sum = prices.reduce(0, (item1,item2) -> item1+item2);
		
//		double totalPrice = 0.0;
//		for(IItems item: items) {
//			totalPrice += item.getItemPrice();
//		}
//		return totalPrice;
//		System.out.println(sum);
		return sum;
	}
	
	public void displayCart() {
		System.out.println("Shopping Cart");
		for(IItems item: items) {
			System.out.println(item.getItemName() + " " + item.getItemPrice());
		}
		System.out.println("Total Price is " + getCartPrice(items));
	}
	
	
}
