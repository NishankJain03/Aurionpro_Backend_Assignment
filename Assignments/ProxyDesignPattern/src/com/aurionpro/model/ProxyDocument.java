package com.aurionpro.model;

public class ProxyDocument implements Document{
	private RealDocument realDocument;
	private String content;
	
	
	public ProxyDocument(String content) {
		super();
		this.content = content;
	}


	@Override
	public void display() {
		if(realDocument == null)
			realDocument = new RealDocument(content);
		
		realDocument.display();
		
	}

}
