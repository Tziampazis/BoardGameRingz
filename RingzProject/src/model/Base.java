package model;

/**
 * Base represents a piece(base) from the game. It should have a colour.
 * 
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public class Base {

	/**
	 * The colour of the base.
	 */
	private Colour colour;
	
	/**
	 * Constructor that initializes the base with the colour given as parameter.
	 * @param c This is the colour of the base.
	 */
	public Base (Colour c) {
		colour = c;
	}
	
	/**
	 * Getter for colour property of the base object.
	 * @return The colour of the base.
	 */
	public Colour getColour() {
		return colour;
	}

}
