package com.aurionpro.model;

public enum Builder {
	FENDER, MARTIN, GIBSON, COLLINS;
	public String toString() {
		switch (this) {
		case FENDER:
			return "Fender";
		case MARTIN:
			return "Martin";
		case GIBSON:
			return "Gibson";
		case COLLINS:
			return "Collins";
		default:
			return "Default";
		}
	}
}
