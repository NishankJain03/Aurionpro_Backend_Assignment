package com.aurionpro.model;

public class PacketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Packet packet = new Packet(new Ordered());
		
		packet.getCurrent();
		packet.next();
		packet.getCurrent();
		packet.next();
		packet.getCurrent();
		packet.previous();
		packet.getCurrent();
		packet.previous();
		packet.getCurrent();

	}

}
