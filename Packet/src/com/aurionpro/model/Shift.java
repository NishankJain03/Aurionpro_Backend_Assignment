package com.aurionpro.model;

public class Shift implements IPacket{
	boolean hasNext = true;
	boolean hasPrev = true;

	@Override
	public IPacket next() {
		if(hasNext)
			return new Delivered();
		return null;
	}

	@Override
	public IPacket previous() {
		if(hasPrev)
			return new Ordered();
		return null;
	}

	@Override
	public Shift currentStatus() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String toString() {
		return "Shift [hasNext=" + hasNext + ", hasPrev=" + hasPrev + "]";
	}
	
	
	
	
	
}
