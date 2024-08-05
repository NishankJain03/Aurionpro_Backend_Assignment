package com.aurionpro.model;

public class BoxWeight extends Box{
	private int weight;
	
	public BoxWeight(int width, int height, int depth, int weight) {
		super(width, height, depth);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "BoxWeight [weight=" + weight + ", Width=" + getWidth() + ", Height=" + getHeight()
				+ ", Depth=" + getDepth() + "]";
	}
}


// when we call the constructor of the same clas we use this() and if calling constructor of parent we use super
//we make the object of the child class