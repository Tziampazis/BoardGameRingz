package exceptions;

public class IllegalArgumentsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int numofArgs;
	
	public IllegalArgumentsException(int num){
		this.numofArgs = num;
	}
	
	@Override
	public String getMessage(){
		return "Arguments should be between 2 and 4, not : " +this.numofArgs;
	}
}
