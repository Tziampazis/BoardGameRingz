package server;

public interface ChatServer extends BasicServer {

	// ------------ Extension name ----------------
	public static final String NAME = "chat";
	
	// ------------ Command keywords --------------
	//				shared keywords (both client and server)
	public static final String CHAT = "chat";
	
	// --------------- Commands ------------------
	// sending Commands
	public void sendChat(String name, String message);
	// receiving Commands
	public void receiveChat(String chatCommand);
}
