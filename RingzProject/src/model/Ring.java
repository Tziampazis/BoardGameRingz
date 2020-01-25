package model;

/**
 * Ring represents a piece(ring) from the game. It should have a colour and a size.
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public class Ring {
	/**
	 * The colour of the ring.
	 */
	private Colour colour;
	/**
	 * The size of the ring.
	 */
	private Size size;
	
	/**
	 * Constructor that initializes the ring with the colour and size given as parameter.
	 * @param c This is the colour of the ring.
	 * @param s This is the size of the ring.
	 */
	public Ring (Colour c, Size s) {
		colour = c;
		size = s;
	}
	
	/**
	 * Getter for colour property of the ring object.
	 * @return The colour of the ring.
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * Getter for size property of the ring object.
	 * @return The size of the ring.
	 */
	public Size getSize() {
		return size;
	}

}
