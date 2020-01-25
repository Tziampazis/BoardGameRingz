package model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Class player keeps track of the player and his rings, bases and colours. It is an abstract class that is extended
 * by human or computer player. It contains all the methods except determineMove and determineStartMove, which is the only difference
 * between human and computer, how the input is given. 
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public abstract class Player implements Observer {

	/**
	 * The name of the player.
	 */
	private String name;
	/**
	 * A list with rings that the player has.
	 */
	private List<Ring> rings;
	/**
	 * A list with bases that the player has.
	 */
	private List<Base> bases;
	/**
	 * A list with colours that the player has. Maximum 2 colours
	 * the first colour is primary and the second is secondary.
	 */
	private List<Colour> colours;

	/**
	 * Constructor that initializes the player with the given name, given rings, given bases and colours.
	 * It sets the private fields with the given values.
	 */
	public Player(String name, List<Base> bases, List<Ring> rings, List<Colour> colours) {
		this.name = name;
		this.bases = bases;
		this.rings = rings;
		this.colours = colours;
	}

	/**
	 * Abstract method that returns an int array containing the move coded as follows: <Piece> <Colour> <Size> <Index>.
	 * @param board The board where the checkings are made and where the move should be made.
	 * @return An integer array containing the settings of the move.
	 */
	public abstract int[] determineMove(Board board);

	/**
	 * Abstract method that returns an int that means the position of the start base.
	 * @param board The board where the start base should be placed.
	 * @return AN int that means the index of the territory where the move should be made.
	 */
	public abstract int determineStartBase(Board board);

	/**
	 * Method that should be called when want to add start base. The player that starts should call this method once.
	 * This method should be called just once per game. First it verifies if the piece can be placed and the it's placed.
	 * @param board The board where the start base should be placed.
	 */
	public void addStartBase(Board board) {
			board.placeStartBase(determineStartBase(board));
	}

	/**
	 * Method that makes the move based on the decision made by player. It gets the decision calling the method determineMove.
	 * It adds the piece on the board and then removes that piece from the players pieces.
	 * @param board The board where the piece should be placed.
	 */
	public void makeMove(Board board) {
		int[] choice = determineMove(board);

		int piece = choice[0];
		Colour colour = intToColour(choice[1]);
		Size size = intToSize(choice[2]);
		int index = choice[3];

		if(piece == 0) {
			Base base = new Base(colour);
			board.getTerritory(index).setBase(base);
			for(Base b : bases) {
				if(b.getColour() == colour) {
					bases.remove(b);
					break;
				}
			}
		} else if(piece == 1) {
			Ring ring = new Ring(colour, size);
			board.getTerritory(index).setRing(ring);
			for(Ring r : rings) {
				if(r.getColour() == colour && r.getSize() == size) {
					rings.remove(r);
					break;
				}
			}
		}
		
		
	}

	/**
	 * Method that verifies if any ring can still be placed. It first checks if the player still has rings and then, 
	 * it loops through the remaining rings and all territories and if the value of isValidMoveRing is true it imediately
	 * returns true. This method is used to determine if its game over.
	 * @param board The board where the moves can be made.
	 * @return A boolean value that checks if rings can still be placed.
	 */
	public boolean canStillMakeMoveRing(Board board) {
		List<Ring> rings = getRings();
		if(rings.isEmpty()) {
			return false;
		} else {
			for(int i = 0; i < rings.size(); i++) {
				for(int j = 0; j < Board.TERRITORIES; j++) {
					if(board.isValidMoveRing(rings.get(i), j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Method that verifies if any base can still be placed. It first checks if the player still has bases and then, 
	 * it loops through the remaining bases and all territories and if the value of isValidMoveBase is true it imediately
	 * returns true. This method is used to determine if its game over.
	 * @param board The board where the moves can be made.
	 * @return A boolean value that checks if bases can still be placed.
	 */
	public boolean canStillMakeMoveBases(Board board){
		List<Base> bases = getBases();
		if(bases.isEmpty()) {
			return false;
		} else {
			for(int i = 0; i < bases.size(); i++) {
				for(int j = 0; j < Board.TERRITORIES; j++) {
					if(board.isValidMoveBase(bases.get(i), j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Getter for the private field name.
	 * @return The name of the player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for rings that the player owns.
	 * @return A list containing the remaining rings.
	 */
	public List<Ring> getRings() {
		return rings;
	}

	/**
	 * Method that checks if the player has a ring with the given specs.
	 * @param c The colour of the ring that has to be verified.
	 * @param s The size of the ring that has to be verified.
	 * @return A boolean value that is true if the player still has a ring with the given colour and size or false otherwise.
	 */
	public boolean hasRing(Colour c, Size s) {
		for(int i = 0; i < rings.size(); i++) {
			if(rings.get(i) != null && rings.get(i).getSize() == s && rings.get(i).getColour() == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter for ring on the given position i.
	 * @return The ring on the ith position.
	 */
	public Ring getRing(int i) {
		return rings.get(i);
	}

	/**
	 * Getter for ring with the given specs.
	 * @param c The colour of the searched ring.
	 * @param s The size of the searched ring.
	 * @return The players ring with the given specs and null if it doesnt exist.
	 */
	public Ring getRing(Colour c, Size s) {
		for(int i = 0; i < rings.size(); i++) {
			if(rings.get(i) != null && rings.get(i).getSize() == s && rings.get(i).getColour() == c) {
				return rings.get(i);
			}
		}
		return null;
	}

	/**
	 * Method that checks if the player has a base with the given specs.
	 * @param c The colour of the base that has to be verified.
	 * @return A boolean value that is true if the player still has a base with the given colour or false otherwise.
	 */
	public boolean hasBase(Colour c) {
		for(int i = 0; i < bases.size(); i++) {
			if(bases.get(i) != null && bases.get(i).getColour() == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getter for bases that the player owns.
	 * @return A list containing the remaining bases.
	 */
	public List<Base> getBases() {
		return bases;
	}

	/**
	 * Getter for colours that the player owns.
	 * @return A list containing the colours.
	 */
	public List<Colour> getColours() {
		return colours;
	}

	/**
	 * Verifier that checks if the player has a given colour.
	 * @param c The colour that needs to be checked.
	 * @return A boolean value that is true if the player has the colour c or false otherwise.
	 */
	public boolean hasColour(Colour c) {
		for(int i = 0; i < colours.size(); i++) {
			if(colours.get(i) != null && colours.get(i) == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that converts an integer to a colour.
	 * @param i The int value of the colour. (1 = red; 2 = green; 3 = yellow; 4 = purple;)
	 * @return The colour associated with the given integer value. Returns null if the given int is else than 1 or 2 or 3 or 4.
	 */	
	public Colour intToColour(int i) {
		 Colour c = null;
		 if(i == 1) {
			 c = Colour.RED;
		 }else if(i == 2) {
			 c = Colour.GREEN;
		 }else if(i == 3) {
			 c = Colour.YELLOW;
		 }else if(i == 4) {
			 c = Colour.PURPLE;
		 }
		 return c;
	 }

	/**
	 * Method that converts an integer to a size.
	 * @param i The int value of the size. (1 = level1; 2 = level2; 3 = level3; 4 = level4;)
	 * @return The size associated with the given integer value. Returns null if the given int is else than 1 or 2 or 3 or 4.
	 */	
	 public Size intToSize(int i) {
		 Size s = null;
		 if(i == 1) {
			 s = Size.LEVEL1;
		 }else if(i == 2) {
			 s = Size.LEVEL2;
		 }else if(i == 3) {
			 s = Size.LEVEL3;
		 }else if(i == 4) {
			 s = Size.LEVEL4;
		 }
		 return s;
	 }

}
