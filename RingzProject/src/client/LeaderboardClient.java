package client;

public interface LeaderboardClient extends BasicClient {
	
	//				Extension name
	public static final String NAME = "leaderboard";
	
	//				Error codes                 
	public static final int INVALID_NAME = 5;
	
	//				Command keywords
	// shared keywords (both client and server)
	public static final String RANKING = "ranking";
	// sent by server
	// sent by client
	
	//				Commands
	// sending Commands
	public void sendRanking(String[] arg);
	// receiving Commands
	public void receiveRanking(String rankingCommand);
}
