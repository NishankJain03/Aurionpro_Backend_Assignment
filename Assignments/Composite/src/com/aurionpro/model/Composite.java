package com.aurionpro.model;

import java.util.ArrayList;

public class Composite implements Component{
	String name;
	ArrayList<Component> components;
	
	
	public Composite(String name) {
		super();
		this.name = name;
		this.components = new ArrayList<>();
	}

	

	@Override
	public void showPrice() {
		for(Component component : components)
			component.showPrice();
	}
	
	public void add(Component subComponent) {
		components.add(subComponent);
	}
	
}
