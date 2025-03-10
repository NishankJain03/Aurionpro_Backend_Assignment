package com.aurionpro.behavioural.state.model;

public class Packet {
	IPacket packet;

	public Packet(IPacket packet) {
		super();
		this.packet = packet;
	}
	
	public IPacket getPacketState() {
		return packet.current();
	}
	
	public void nextState() {
		if(packet.hasNext())
			packet = packet.next();
	}
	
	public void prevState() {
		if(packet.hasPrevious())
			packet = packet.previous();
	}
}
