package com.aurionpro.structural.facade.model;

public class MovieFacade {
	public static void watchMovie() {
		DvdPlayer dvdPlayer = new DvdPlayer();
		dvdPlayer.On();
		dvdPlayer.setMovie("Movie1");
		
		SoundSystem soundSystem = new SoundSystem();
		soundSystem.On();
		soundSystem.setVolume(100);
		
		Projector projector = new Projector();
		projector.On();
	}
}
