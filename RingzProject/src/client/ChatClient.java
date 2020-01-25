package client;

public interface ChatClient extends BasicClient {

	//              Extension name                 
	public static final String NAME = "chat";
	
	//              Command keywords                 
	//				shared keywords (both client and server)
	public static final String CHAT = "chat";
	
	//              Commands                 
	// sending Commands
	public String sendChat(String message);
	// receiving Commands
	public void receiveChat(String chatCommand);
}
