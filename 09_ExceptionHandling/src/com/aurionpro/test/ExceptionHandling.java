package com.aurionpro.test;

public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		
		double result = number1 / number2;
		System.out.println("Division is " + result);
		
		
		}catch (ArithmeticException e){
			System.out.println("Invalid input, number2 cannot be zero");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Division requires two arguments , Enter two values");
		}catch (NumberFormatException e){
			System.out.println("Cannot divide the string with the integer");
		}catch(Exception e) {
			//this is the common exception if exception occurred other than mentioned above
			System.out.println("Exception occured");
		}finally {
			System.out.println("Finallly block executed");
		}

	}

}


//Exception --> abnormal condition that arises during exceution of the code
// they are the runtime error

//try  --> the code you want to monitor for an exception
//catch --> catch the object that is thrown (are you handling the object?) handling the situation resume the code after catch block
//throws --> this is use in method here we only state that it might throw exception but not handling it 
//throw --> used to throw an exception explicitly
//finally --> it always executes whether exception occur or not .... basically use for the closing activities



//why exception occur --> does it have any exception (class)--> make the object and throw 


//every try has atleast one catch or finally block
//one try can have more than one catch block and a finally block
//


// Exception Hierarchy

// Throwable   --> 1) error(compile) 2) exception   -> (subclass) runtimeException  ---> subclass(unchecked exception --> runtime) --> they are not compulsory to handle (arrayindexoutofbound, arithmetic, nullpointer)
//													   (subclass) checked exception --> these are the exception that we must handle --> they are compile timed exception (file not found, io, classnot found)

// custom exception --->create a class of subclass exception using extends

//when we create a custom exception i bydefault creates a checked excepion but if we want uncheckked exception we wenat to 
//extends RunTimeException