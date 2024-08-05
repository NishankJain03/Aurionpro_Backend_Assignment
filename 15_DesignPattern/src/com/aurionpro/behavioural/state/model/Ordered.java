package com.aurionpro.behavioural.state.model;

public class Ordered implements IPacket{

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public IPacket next() {
		return new Shift();
	}

	@Override
	public IPacket previous() {
		return null;
		
	}

	@Override
	public IPacket current() {
		return this;
		
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

}
