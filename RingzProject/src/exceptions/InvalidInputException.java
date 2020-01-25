package exceptions;

public class InvalidInputException extends Exception{

	public InvalidInputException() {
		
	}
	
	public String toString() {
		return "The input is invalid!";
	}
}
