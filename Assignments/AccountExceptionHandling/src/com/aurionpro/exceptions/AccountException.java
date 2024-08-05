package com.aurionpro.exceptions;

public class AccountException extends RuntimeException {
	public static class AmountLessThanZero extends AccountException{
		public String getMessage() {
			return "Please enter the valid amount";
		}
	}
	
	public static class AmountGreaterThanOverDraftLimit extends AccountException{
		public String getMessage() {
			return "Amount is Greater than overdraft limit";
		}
	}
	
	public static class MinimumBalanceNeedToMaintain extends AccountException{
		public String getMessage() {
			return "Cannot withdraw. Minimum balance requirement not met";
		}
	}
	
	public static class MinimumBalanceToKeep extends AccountException{
		public String getMessage() {
			return "You Balance must be greater than minimum value set";
		}
	}
}

	