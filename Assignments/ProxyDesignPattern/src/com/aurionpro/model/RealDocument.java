package com.aurionpro.model;

public class RealDocument implements Document{
	private String content;
	
	
	public RealDocument(String content) {
		super();
		this.content = content;
		loadFromDisk();
	}
	
	private void loadFromDisk() {
		System.out.println("Loading Document " + content  );
	}


	@Override
	public void display() {
		System.out.println("Displaying Content " + content);
		
	}
	
}
