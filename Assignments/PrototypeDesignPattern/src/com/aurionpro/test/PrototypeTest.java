package com.aurionpro.test;

import com.aurionpro.model.NetworkConnection;

public class PrototypeTest {
	public static void main(String[] args) {
		System.out.println("Creating the object using prototype design pattern");
		
		NetworkConnection networkConnection = new NetworkConnection();
		
		networkConnection.setIp("192.123.123.5");
		networkConnection.loadImportantData();
		
		System.out.println(networkConnection);
		
		//this creates the clone of the object
		
		NetworkConnection networkConnection2 = null;
		try {
			networkConnection2 = (NetworkConnection) networkConnection.clone();
			networkConnection2.setIp("192.123.142.4");
			System.out.println(networkConnection2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}		
