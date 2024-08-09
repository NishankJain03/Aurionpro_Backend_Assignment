package com.aurionpro.test;

import com.aurionpro.model.BatchProcessingPrepared;

public class BatchProcessingPreparedTest {

	public static void main(String[] args) {
		BatchProcessingPrepared batchProcessingPrepared = new BatchProcessingPrepared();
		
		batchProcessingPrepared.connectToDo();
		batchProcessingPrepared.startBatchProcessing();

	}

}
