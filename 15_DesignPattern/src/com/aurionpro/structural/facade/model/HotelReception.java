package com.aurionpro.structural.facade.model;

public class HotelReception {
	public static void getIndianMenu() {
		IHotel indHotel = new IndianHotel();
		IMenu menu = indHotel.getMenu();
		menu.displayMenu();
		
	}
	public static void getItalianMenu() {
		IHotel italianHotel = new ItalianHotel();
		IMenu menu = italianHotel.getMenu();
		menu.displayMenu();
		
	}
}
