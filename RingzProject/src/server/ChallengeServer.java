package server;

public interface ChallengeServer extends BasicServer {

	//              Extension name                 
	public static final String NAME = "challenge";
	
	//                 Error codes                 
	public static final int INVALID_NAME = 5;
	public static final int PLAYER_BUSY = 6;
	
	//              Command keywords                 
	// shared keywords (both client and server)
	public static final String PLAYERLIST = "playerlist";
	// sent by server only
	public static final String CHALLENGED = "challenged";
	public static final String CHALLENGE_DECLINED = "challenge_declined";
	// sent by client only
	public static final String CHALLENGE = "challenge";
	public static final String ACCEPT = "accept";
	
		
	//                Commands                 
	// sending Commands
	public void sendPlayerlist(String[] names);	
	public void sendChallenged(String challenger, String[] names);
	public void sendChallengeDeclined(String name);
	// receiving Commands
	public void receivePlayerlist(String playerlistCommand);
	public void receiveChallenge(String challengeCommand);
	public void receiveAccept(String acceptCommand);
}
