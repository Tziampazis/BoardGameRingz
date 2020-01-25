package client;

public interface SecurityClient extends LeaderboardClient {
	
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
	public void sendRegister(String password);
	public void sendLogin(String password);
	// receiving Commands
	public void receiveLogin(String loginCommand);
}
