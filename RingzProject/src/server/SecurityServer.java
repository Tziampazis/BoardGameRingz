package server;

public interface SecurityServer extends LeaderboardServer {

	//				Extension name
	public static final String NAME = "security";
	
	//				Error codes
	public static final int WRONG_PASSWORD = 7;
	public static final int AUTHENTICATION_REQUIRED = 8;
	
	//				Command keywords
	// shared keywords (both client and server)
	public static final String LOGIN = "login";
	// sent by client only
	public static final String REGISTER = "register";
	
	//				Commands
	// sending Commands
	public void sendLogin();
	// receiving Commands
	public void receiveRegister(String registerCommand);
	public void receiveLogin(String loginCommand);
	
	
	
	
	
	
}
