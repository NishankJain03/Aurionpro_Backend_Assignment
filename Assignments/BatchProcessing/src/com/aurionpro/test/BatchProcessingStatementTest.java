package com.aurionpro.test;

import com.aurionpro.model.BatchProcessingStatement;

public class BatchProcessingStatementTest {

	public static void main(String[] args) {
		BatchProcessingStatement batchProcessingStatement = new BatchProcessingStatement();
		batchProcessingStatement.connectToDo();
		
		batchProcessingStatement.startBatchProcessing();

	}

}
