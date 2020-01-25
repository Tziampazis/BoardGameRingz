package client;

public interface ChallengeClient extends BasicClient {

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
	
	//				Commands
	//  sending Commands
	public void sendPlayerlist();	// maybe a little bit word to call asking for a playerlist "sending", but this is about sending the command/keyword.
	public void challenge(String[] names);
	public void accept(boolean accepting);
	// receiving Commands
	public void receivePlayerlist(String playerlistCommand);
	public void receiveChallenged(String challengedCommand);
	public void receiveChallengeDeclined(String challengeDeclinedCommand);
	
	
}
