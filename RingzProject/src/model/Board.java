package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class board keeps track of the territories and make some validations when a move is requested. It keeps track of
 * starting base, bases and rings on the territories. It has a dimension of 5 x 5 = 25 territories.
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public class Board {

	/**
	 * The dimension of the board on a x,y axis.
	 */
	public static final int DIM = 5;

	/**
	 * The number of territories = the dimension squared.
	 */
	public static final int TERRITORIES = DIM * DIM;

	/**
	 * An array that contains the territories of the board.
	 */
	private Territory[] territories;

	/**
	 * Constructor that initializes the board territories to null. It first initializes the territories array with the number of territories.
	 * Then loops through it and initializes each territory to null.
	 */
	public Board() {
		territories = new Territory[TERRITORIES];
		for (int i = 0; i < TERRITORIES; i++) {
			territories[i] = new Territory();
		}
	}

	/**
	 * Method that translates the coordinates in an index. Index start with (0,0).
	 * @param row The given number of row.
	 * @param col The given number of column.
	 * @return The index computed as row * DIM + col.
	 */
	public int index(int row, int col) {
		return DIM * row + col;
	}

	/**
	 * Method that checks if the given integer is in the interval [0, number of territories].
	 * @param i The integer that need to be checked.
	 * @return The boolean value that checks if the introduced index is valid.
	 */
	public boolean isTerritory(int i) {
		return 0 <= i && i < TERRITORIES;
	}

	/**
	 * Method that checks if the given coordinates correspond to a territory.
	 * @param row The given number of row.
	 * @param col The given number of column.
	 * @return The boolean value that checks if the introduced coordinates are valid.
	 */
	public boolean isTerritory(int row, int col) {
		return isTerritory(index(row, col));
	}

	/**
	 * Getter for a specific territory.
	 * @param i The index of the searched territory.
	 * @return Returns the territory on the given index.
	 */
	public Territory getTerritory(int i) {
		return territories[i];
	}

	/**
	 * Getter for a specific territory.
	 * @param row The given number of row.
	 * @param col The given number of column.
	 * @return Returns the territory on the given coordinates.
	 */
	public Territory getTerritory(int row, int col) {
		return getTerritory(index(row, col));
	}

	/**
	 * Method that resets the board. It has the same functionality as the constructor.
	 * Sets all territories.
	 */
	public void resetBoard() {
		for (int i = 0; i < TERRITORIES; i++) {
			territories[i] = new Territory();
		}
	}
	/**
	 * This method checks the majority for all the territories.
	 * This could also be 1 or 2 colours so the return type is an array of Strings.
	 * @return String[]
	 */
	public Map<String,Integer> isWinner(){
		int red =0;
		int green =0;
		int yellow =0;
		int purple =0;
		String colour;
		Map<String,Integer> map = new HashMap<String,Integer>();
		String[] winnerColour = new String[4];
				
		for(int i=0;i<TERRITORIES;i++){
			if(this.getTerritory(i).isOwnedBy()!= null){
				colour = this.getTerritory(i).isOwnedBy().toString();
				System.out.println("Territory " +i + " owned by  " + colour);
				if(colour != null){
					switch(colour){
					case "R": red++;
						break;
					case "G": green++;
						break;
					case "Y": yellow++;
						break;
					case "P": purple++;
						break;
					}
				}
			}
		}
		map.put("R",red);
		map.put("G", green);
		map.put("Y", yellow);
		map.put("P",purple);

		System.out.println("KEEYS: " + map);
		
		return map;
	}


	/**
	 * Method that verifies if the territory on the given index has a base of the given colour on a horizontally or vertically axis.
	 * It checks all the fields up, down, left, right of the given index.
	 * @param c The searched colour.
	 * @param i The index of the territory.
	 * @return A boolean value that is 0 if there is no base of the given colour near or 1 otherwise.
	 */
	public boolean hasBaseSameColourNear(Colour c, int i) {
		boolean hasBaseSameColourUp = false;
		boolean hasBaseSameColourDown = false;
		boolean hasBaseSameColourLeft = false;
		boolean hasBaseSameColourRight = false;

		if(isTerritory(i-5)) {
			hasBaseSameColourUp = getTerritory(i - 5).hasBase(c);
		}
		if(isTerritory(i+5)) {
			hasBaseSameColourDown = getTerritory(i + 5).hasBase(c);
		}
		if(isTerritory(i-1) && i != 5 && i != 10 && i != 15 && i != 20) {
			hasBaseSameColourLeft = getTerritory(i - 1).hasBase(c);
		}
		if(isTerritory(i+1) && i != 4 && i != 9 && i != 14 && i != 19) {
			hasBaseSameColourRight = getTerritory(i + 1).hasBase(c);
		}

		return hasBaseSameColourUp || hasBaseSameColourDown || hasBaseSameColourLeft || hasBaseSameColourRight;	
	}

	/**
	 * Method that verifis if the territory on the given index has a ring of any size and of the given colour on a horizontally or vertically axis.
	 * It checks all the fields up, down, left, right of the given index.
	 * @param c The searched colour.
	 * @param i The index of the territory.
	 * @return A boolean value that is 0 if there is no ring of any size and of the given colour near or 1 otherwise.
	 */
	public boolean hasRingSameColourNear(Colour c, int i) {
		boolean hasRingSameColourUp = false;
		boolean hasRingSameColourDown = false;
		boolean hasRingSameColourLeft = false;
		boolean hasRingSameColourRight = false;

		if(isTerritory(i-5)) {
			hasRingSameColourUp = getTerritory(i - 5).hasRing(c);

		}
		if(isTerritory(i+5)) {
			hasRingSameColourDown = getTerritory(i + 5).hasRing(c);
		}
		if(isTerritory(i-1) && i != 5 && i != 10 && i != 15 && i != 20) {
			hasRingSameColourLeft = getTerritory(i - 1).hasRing(c);
		}
		if(isTerritory(i+1) && i != 4 && i != 9 && i != 14 && i != 19) {
			hasRingSameColourRight = getTerritory(i + 1).hasRing(c);
		}

		return hasRingSameColourUp || hasRingSameColourDown || hasRingSameColourLeft || hasRingSameColourRight;
	}

	/**
	 * Method that verifis if the territory on the given index has a ring of any size and of the given colour on a horizontally or vertically axis,
	 * but also on the given territory.
	 * @param c The searched colour.
	 * @param index The index of the territory.
	 * @return A boolean value that is 0 if there is no ring of any size and of the given colour on the same territory or near or 1 otherwise.
	 */
	public boolean hasRingSameColour(Colour c, int index) {
		return getTerritory(index).hasRing(c) || hasRingSameColourNear(c,index);
	}

	/**
	 * Method that verifies if there is a ring with the given size on the territory with the given index.
	 * @param s The size of the ring that need to be checked.
	 * @param index The index of the territory.
	 * @return The boolean value that checks if the space of the given size is occupied.
	 */
	public boolean hasRingSameSize(Size s, int index) {
		return getTerritory(index).hasRing(s);
	}

	/**
	 * Method that verifies if a base can be placed on a territory with the given index. It implements the rules of the game.
	 * The base can be placed on an existent territory that is entirely empty, doesn't contain a base of the same colour near and
	 * has a ring of the same colour near.
	 * @param base The base that needs to be checked.
	 * @param index The index of the territory where the player wants to move.
	 * @return A boolean value that validates the move.
	 */
	public boolean isValidMoveBase(Base base, int index) {
		return isTerritory(index) && !hasBaseSameColourNear(base.getColour(), index) &&
				hasRingSameColourNear(base.getColour(), index) && !getTerritory(index).isOccupied();
	}

	/**
	 * Method that verifies if a ring can be placed on a territory with the given index. It implements the rules of the game.
	 * The ring can be placed on an existent territory that has a correct size spot empty, contains a base of the same colour near
	 * or contains a ring of the same colour. 
	 * @param base The ting that needs to be checked.
	 * @param index The index of the territory where the player wants to move.
	 * @return A boolean value that validates the move.
	 */
	public boolean isValidMoveRing(Ring ring, int index) {   	
		return isTerritory(index) && (hasBaseSameColourNear(ring.getColour(), index) || hasRingSameColour(ring.getColour(), index)) &&
				!hasRingSameSize(ring.getSize(), index) && !getTerritory(index).hasBase();
	}

	/**
	 * Method that verifies if start base can be placed on the territory with given index i.
	 * @param i The index of the territory.
	 * @return A boolean value that validates the move of the start base.
	 */
	public boolean canPlaceStartBase(int i) {
		return isTerritory(i) && !getTerritory(i).isOccupied() && (i == 6 || i == 7 || i == 8 || 
				i == 11 || i == 12 || i == 13 || i == 16 || i == 17 || i == 18);
	}

	/**
	 * Method that places the start base on the territory with the given index. The start base is made of a red ring size level1, 
	 * a green ring size level2, a yellow ring size level3 and a purple ring size level4.
	 * @param i The index of the territory where the player wants to move. It has to be 6,7,8,11,12,13,16,17 or 18.
	 */
	public void placeStartBase(int i) {
		getTerritory(i).setRing(new Ring(Colour.RED, Size.LEVEL1));
		getTerritory(i).setRing(new Ring(Colour.GREEN, Size.LEVEL2));
		getTerritory(i).setRing(new Ring(Colour.YELLOW, Size.LEVEL3));
		getTerritory(i).setRing(new Ring(Colour.PURPLE, Size.LEVEL4));
	}

	/**
	 * Method that prints the current state of the board, including the rings and bases on the territories.
	 */
	public String toString() {
		String s = "";
		String[] l = new String[TERRITORIES];
		
		for(int i = 0; i < TERRITORIES; i++) {
			l[i] = "";
			if(i % 5 == 0) {
				l[i] = l[i] + "--+-----------+-----------+-----------+-----------+-----------+--\n";
				for(int j = 0; j < DIM; j++) {
					if(getTerritory(index(i / 5, j)).hasRingLevel4()) {
						l[i] = l[i] + "  |  ring4:" + getTerritory(index(i / 5, j)).getRingLevel4().getColour().toString();
					} else {
						l[i] = l[i] + "  |  ring4:-";
					}
				}
				l[i] = l[i] + "  |\n";
			}
			if(i % 5 == 1) {
				for(int j = 0; j < DIM; j++) {
					if(getTerritory(index(i / 5, j)).hasRingLevel3()) {
						l[i] = l[i] + "  |  ring3:" + getTerritory(index(i / 5, j)).getRingLevel3().getColour().toString();
					} else {
						l[i] = l[i] + "  |  ring3:-";
					}
				}
				l[i] = l[i] + "  |\n";

			}
			if(i % 5 == 2) {
				for(int j = 0; j < DIM; j++) {
					if(getTerritory(index(i / 5, j)).hasRingLevel2()) {
						l[i] = l[i] + "  |  ring2:" + getTerritory(index(i / 5, j)).getRingLevel2().getColour().toString();
					} else {
						l[i] = l[i] + "  |  ring2:-";
					}
				}
				l[i] = l[i] + "  |\n";

			}
			if(i % 5 == 3) {
				for(int j = 0; j < DIM; j++) {
					if(getTerritory(index(i / 5, j)).hasRingLevel1()) {
						l[i] = l[i] + "  |  ring1:" + getTerritory(index(i / 5, j)).getRingLevel1().getColour().toString();
					} else {
						l[i] = l[i] + "  |  ring1:-";
					}
				}
				l[i] = l[i] + "  |\n";

			}
			if(i % 5 == 4) {
				for(int j = 0; j < DIM; j++) {
					if(getTerritory(index(i / 5, j)).hasBase()) {
						l[i] = l[i] + "  |  base :" + getTerritory(index(i / 5, j)).getBase().getColour().toString();
					} else {
						l[i] = l[i] + "  |  base :-";
					}
				}
				l[i] = l[i] + "  |\n";

			}
			s = s + l[i];
		}
		
		
		return s + "--+-----------+-----------+-----------+-----------+-----------+--\n" +
		"-+--+--+--+--+--+-\n" +
		" |0 |1 |2 |3 |4 | \n" +
		"-+--+--+--+--+--+-\n" +
		" |5 |6 |7 |8 |9 | \n" +
		"-+--+--+--+--+--+-\n" +
		" |10|11|12|13|14| \n" +
		"-+--+--+--+--+--+-\n" +
		" |15|16|17|18|19| \n" +
		"-+--+--+--+--+--+-\n" +
		" |20|21|22|23|24| \n" +
		"-+--+--+--+--+--+-\n";
	}

	//only for verification
	public static void main(String[] args) {
		Board b = new Board();
		b.getTerritory(0).setBase(new Base(Colour.GREEN));
		b.getTerritory(13).setRing(new Ring(Colour.RED, Size.LEVEL3));
		b.getTerritory(14).setRing(new Ring(Colour.RED, Size.LEVEL1));
		b.getTerritory(24).setRing(new Ring(Colour.RED, Size.LEVEL1));
		b.getTerritory(14).setRing(new Ring(Colour.GREEN, Size.LEVEL2));

		System.out.println(b.toString());
	}
}