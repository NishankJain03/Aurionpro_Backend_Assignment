package com.aurionpro.model;

public class Ordered implements IPacket{
	boolean hasNext = true;
	boolean hasPrevious = false;

	@Override
	public IPacket next() {
		if(hasNext)
			return new Shift();
		return null;
	}

	@Override
	public IPacket previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordered currentStatus() {
		return this;
	}

	@Override
	public String toString() {
		return "Ordered [hasNext=" + hasNext + ", hasPrevious=" + hasPrevious + "]";
	}
	
}
