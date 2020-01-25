package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import model.*;

import controller.*;

public class PlayersTest {
	//ADD ALSO THE COMPUTER PLAYERS
	Game game;
	RingzAndBases ringz;
	String[] names;
	List<Player> players;
	
	@Before
	public void setUp(){
		ringz = new RingzAndBases();
		ringz.createRed();
		ringz.createGreen();
		ringz.createPurple();
		ringz.createYellow();
		players = new ArrayList<Player>();
		
	}
	//Test for all human players
	@Test
	public void twoHumanPlayers(){
		names = new String[2];
		names[0] = "chris";
		names[1] = "john";
		players = RingzMain.determinePlayerRings(names,ringz);
		assertEquals(players.size(),2);
		for(int i=0;i<names.length;i++){
			assertEquals(6, players.get(i).getBases().size());
			assertEquals(24, players.get(i).getRings().size());
			assertEquals(2, players.get(i).getColours().size());
		}
	}
	
	@Test
	public void threeHumanPlayers(){
		names = new String[3];
		names[0] = "chris";
		names[1] = "john";
		names[2] = "marios";
		players = RingzMain.determinePlayerRings(names,ringz);
		assertEquals(players.size(),3);
		for(int i=0;i<names.length;i++){
			assertEquals(4, players.get(i).getBases().size());
			assertEquals(16, players.get(i).getRings().size());
			assertEquals(2, players.get(i).getColours().size());
		}
	}
	
	@Test
	public void fourHumanPlayers(){
		names = new String[4];
		names[0] = "chris";
		names[1] = "john";
		names[2] = "marios";
		names[3] = "christos";
		players = RingzMain.determinePlayerRings(names,ringz);
		assertEquals(players.size(),4);
		for(int i=0;i<names.length;i++){
			assertEquals(3, players.get(i).getBases().size());
			assertEquals(12, players.get(i).getRings().size());
			assertEquals(1, players.get(i).getColours().size());
		}
	}
	
}
