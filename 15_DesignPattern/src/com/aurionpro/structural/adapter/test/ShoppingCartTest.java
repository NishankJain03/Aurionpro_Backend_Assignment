package com.aurionpro.structural.adapter.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.structural.adapter.model.Biscuit;
import com.aurionpro.structural.adapter.model.Chocolate;
import com.aurionpro.structural.adapter.model.Hat;
import com.aurionpro.structural.adapter.model.HatAdapter;
import com.aurionpro.structural.adapter.model.IItems;
import com.aurionpro.structural.adapter.model.ShoppingCart;

public class ShoppingCartTest {

	public static void main(String[] args) {
		List<IItems> items = new ArrayList<>();
		
		items.add(new Biscuit("parle", 10));
		items.add(new Biscuit("parle", 10));
		items.add(new Chocolate("cadbury", 20));
		Hat hat = new Hat("avbc", "av", 100, 20);
		items.add(new HatAdapter(hat));
		
		ShoppingCart shoppingCart = new ShoppingCart(items);
		shoppingCart.addItemsToCart(items);
//		shoppingCart.getCartItems(items);
		shoppingCart.displayCart();
		
		

	}

}
