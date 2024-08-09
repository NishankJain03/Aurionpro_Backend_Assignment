package com.aurionpro.model;

public class Player {
	private String name;
	private MarkType markType;
	public Player(String name, MarkType markType) {
		super();
		this.name = name;
		this.markType = markType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MarkType getMarkType() {
		return markType;
	}
	public void setMarkType(MarkType markType) {
		this.markType = markType;
	}
	
	
}
