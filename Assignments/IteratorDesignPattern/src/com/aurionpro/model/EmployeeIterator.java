package com.aurionpro.model;

import java.util.List;

public class EmployeeIterator implements Iterator{
	private List<Employee> list;
	private int length;
	private int currentIndex = 0;
	
	
	public EmployeeIterator(List<Employee> list) {
		super();
		this.list = list;
		this.length = list.size();
	}

	@Override
	public boolean hasNext() {
		if(currentIndex >= length)
			return false;
		return true;
	}

	@Override
	public Employee next() {
		return list.get(currentIndex++);
	}

}
