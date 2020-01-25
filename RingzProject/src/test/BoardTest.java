package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Board;
import model.Colour;
import model.Ring;
import model.Size;
import model.Territory;

public class BoardTest {

	private Board board;
	private Ring red;
	private Ring green;
	private Ring yellow;
	private Ring purple;
	private Ring[] startbase;
	@Before
	public void setUp() throws Exception {
		board = new Board();
		startbase = new Ring[4];
		red = new Ring(Colour.RED, Size.LEVEL1);
		green =new Ring(Colour.GREEN, Size.LEVEL2);
		yellow = new Ring(Colour.YELLOW, Size.LEVEL3);
		purple = new Ring(Colour.PURPLE, Size.LEVEL4);
		startbase[0] = red;
		startbase[1] = green;
		startbase[2] = yellow;
		startbase[3] = purple;
	}

	@Test
	public void testCreatedTerritories() {
		for(int i=0;i<Board.TERRITORIES;i++){
			assertNotNull("Null Territory!!",  board.getTerritory(i));
		}
	}
	
//	@Test
//	public void testTerritoriesStartingBase() {
//		board.placeStartBase(13);
//		assertNotNull(board.getTerritory(13).getRings());
//		Ring[] rings =board.getTerritory(13).getRings();
//		for(int i=0;i<board.getTerritory(13).getRings().length;i++){
//			assertEquals(rings[i].getColour(),startbase[i].getColour());
//			assertEquals(rings[i].getSize(),startbase[i].getSize());
//		}
//	}
	
//	@Test
//	public void testdeepCopy(){
//		assertEquals(board, board.deepCopy());
//	}
//	
	@Test
	public void testIsTerritory(){
		for(int i=0;i<Board.TERRITORIES;i++){
			assertTrue(board.isTerritory(i));
		}
	}
	
	@Test
	public void testResetBoard(){
		board.resetBoard();
		for(int i=0;i<Board.TERRITORIES;i++){
			assertEquals(new Territory().hasRing(), board.getTerritory(i).hasRing());
			assertEquals(new Territory().hasBase(), board.getTerritory(i).hasBase());

		}
	}
	
	
	//resetBoard
	

}
