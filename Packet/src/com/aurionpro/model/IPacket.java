package com.aurionpro.model;

public interface IPacket{
	IPacket next();
	IPacket previous();
	IPacket currentStatus();
}
