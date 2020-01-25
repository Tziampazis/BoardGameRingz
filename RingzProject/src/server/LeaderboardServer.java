package server;

import java.util.Map;

public interface LeaderboardServer extends BasicServer {
	
	//				Extension name
	public static final String NAME = "leaderboard";
	
	//				Error codes                 
	public static final int INVALID_NAME = 5;
	
	//				Command keywords
	// shared keywords (both client and server)
	// sent by server
	// sent by client
	
	//				Commands
	// sending Commands
	public void sendRanking(Map<String, Integer> namePositionMap,
							Map<String, Integer> nameScoreMap,
							Map<String, Long> nameTimeMap);
	// receiving Commands
	public void receiveRanking(String rankingCommand);
}
