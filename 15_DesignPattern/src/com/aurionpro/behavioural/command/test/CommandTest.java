package com.aurionpro.behavioural.command.test;

import com.aurionpro.behavioural.command.model.Command;
import com.aurionpro.behavioural.command.model.DrawCircleCommand;
import com.aurionpro.behavioural.command.model.DrawShape;
import com.aurionpro.behavioural.command.model.SketchBoard;

public class CommandTest {

	public static void main(String[] args) {
		SketchBoard sketchBoard = new SketchBoard();  //Invoker
	    
	    DrawShape drawShape = new DrawShape("Circle..");  //Create a drawshape object this will be the receiver of the request
	    Command drawCircle = new DrawCircleCommand(drawShape);  //Creating Command object and passing receiver 
	    sketchBoard.setCommand(drawCircle);    //pass the command to the invoker
	    sketchBoard.drawTheShape();  

	}

}
