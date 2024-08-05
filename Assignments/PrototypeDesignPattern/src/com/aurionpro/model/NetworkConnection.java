package com.aurionpro.model;


//cloneable is the marker interface --> provide the tag
public class NetworkConnection implements Cloneable{
	private String ip;
	private String data;   //important data
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public void loadImportantData() {
		//it takes time to load the data
		this.data = "Imp data";
	}
	@Override
	public String toString() {
		return "NetworkConnection [ip=" + ip + ", data=" + data + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
}
