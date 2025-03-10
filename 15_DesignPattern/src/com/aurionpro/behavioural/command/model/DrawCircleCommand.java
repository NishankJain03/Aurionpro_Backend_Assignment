package com.aurionpro.behavioural.command.model;

public class DrawCircleCommand implements Command{
	DrawShape draw;
    
    public DrawCircleCommand(DrawShape draw) {
        this.draw = draw;
    }
	@Override
	public void execute() {
		draw.drawCircle();
	}
	
}
