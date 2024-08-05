package com.aurionpro.model;

public class Delivered implements IPacket{

	boolean hasNext = false;
	boolean hasPrevious = true;
	@Override
	public IPacket next() {
		return null;
	}

	@Override
	public IPacket previous() {
		if(hasPrevious)
			return new Shift();
		return null;
	}

	@Override
	public Delivered currentStatus() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String toString() {
		return "Delivered [hasNext=" + hasNext + ", hasPrevious=" + hasPrevious + "]";
	}
	
	
	
}
