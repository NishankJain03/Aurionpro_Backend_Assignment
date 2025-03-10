package com.aurionpro.behavioural.strategy.test;

import com.aurionpro.behavioural.strategy.model.AddOperation;
import com.aurionpro.behavioural.strategy.model.Multiplication;
import com.aurionpro.behavioural.strategy.model.OperationStrategy;

public class OperationStrategyTest {
	public static void main(String[] args) {
		OperationStrategy ops = new OperationStrategy(new AddOperation());
		ops.doOperation(5, 7);
		
		ops.setOperation(new Multiplication());
		ops.doOperation(7, 8);
	}
}
