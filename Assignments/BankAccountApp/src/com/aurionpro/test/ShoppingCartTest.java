package com.aurionpro.test;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Biscuit;
import com.aurionpro.model.Hat;
import com.aurionpro.model.HatAdapter;
import com.aurionpro.model.IItems;
import com.aurionpro.model.ShoppingCart;

public class ShoppingCartTest {

	public static void main(String[] args) {
		List<IItems> items = new ArrayList<IItems>();
		
		items.add(new Biscuit("parle", 10));
		items.add(new Biscuit("happy happy", 30));
		
		Hat hat = new Hat("LA", "Los Angeles", 10000, 1200);
		items.add(new HatAdapter(hat));
		
		ShoppingCart shoppingCart = new ShoppingCart(items);
		shoppingCart.addItemCart(items);
		
		System.out.println(shoppingCart.getCartItems());
		shoppingCart.displayCart(items);
		System.out.println(shoppingCart.getCartPrice(items));
		
		

	}

}
