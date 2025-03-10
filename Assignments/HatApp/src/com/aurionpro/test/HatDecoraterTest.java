package com.aurionpro.test;

import com.aurionpro.model.GoldenHat;
import com.aurionpro.model.IHat;
import com.aurionpro.model.PremiumHat;
import com.aurionpro.model.RibonedHat;
import com.aurionpro.model.StandardHat;

public class HatDecoraterTest {

	public static void main(String[] args) {
		IHat standardHat = new StandardHat();
		standardHat = new GoldenHat(standardHat);
		System.out.println(standardHat.getName());
		System.out.println(standardHat.getPrice());
		System.out.println(standardHat.getDescription());
		
		IHat premiumHat = new PremiumHat();
		premiumHat = new RibonedHat(premiumHat);
		System.out.println(premiumHat.getName());
		System.out.println(premiumHat.getPrice());
		System.out.println(premiumHat.getDescription());
		

	}

}
