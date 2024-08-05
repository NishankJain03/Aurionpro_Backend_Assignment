package com.aurionpro.behavioural.state.model;

import java.util.Iterator;
import java.util.ListIterator;

public interface IPacket extends Iterator<IPacket>{
	boolean hasPrevious();
	IPacket previous();
	IPacket current();
	
	
	
}
