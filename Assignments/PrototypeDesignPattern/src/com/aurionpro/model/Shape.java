package com.aurionpro.model;

public interface Shape extends Cloneable{
	void draw();

	Shape clone();  //return the clone of the shape
}
