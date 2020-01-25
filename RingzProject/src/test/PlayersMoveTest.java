package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.*;
import controller.*;

public class PlayersMoveTest {

	List<Player> listofPl;
	RingzMain main;
	RingzAndBases rnb;
	Game game;
	Board board;
	String[] names;
	
	@Before
	public void setUp() throws Exception {
		listofPl = new ArrayList<>();
		main = new RingzMain();
		board = new Board();
		rnb = new RingzAndBases();
		rnb.createRed();
		rnb.createGreen();
		rnb.createPurple();
		rnb.createYellow();
		names = new String[4];
		names[0] = "chris";
		names[1] = "john";
		names[2] = "george";
		names[3] = "rick";
		listofPl = RingzMain.determinePlayerRings(names, rnb);
	}

	
//	@Test
//	public void testRestofMoves() {
//		for(int i=0;i<listofPl.get(0).getRings().size();i++){
//			board.getTerritory(1).setRing(listofPl.get(0).getRing(i));
//			System.out.println(board.getTerritory(1).getRings());
//			if(board.getTerritory(1).isFull()){
//				System.out.println("in..");
//				System.out.println(board.getTerritory(1).isFull());
//				assertTrue(board.getTerritory(1).isFull());
//				break;
//			}
//		
//		}
//		System.out.println(board.getTerritory(1).isOwnedBy());
//		Colour col = listofPl.get(0).getColours().get(0);
//		System.out.println(col+ " "+board.getTerritory(1).isOwnedBy());
//		assertTrue(board.getTerritory(1).isOwnedBy() == col );
//	}

	
	//From board isWinner() have to be checked here
}
