package com.aurionpro.model;

public class Packet {
	IPacket packet;

	public Packet(IPacket packet) {
		super();
		this.packet = packet;
	}
	
	public void getCurrent() {
		System.out.println(packet.currentStatus());
	}
	
	public void next() {
		packet = packet.next();
	}
	
	public void previous() {
		packet = packet.previous();
	}

	@Override
	public String toString() {
		return "Packet [packet=" + packet + "]";
	}
	
	
}
