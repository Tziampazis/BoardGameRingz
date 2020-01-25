package model;

/**
 * The Colour enumeration contains colours of rings and bases that players owns.
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public enum Colour {

	/**
	 * Purple colour
	 */
	PURPLE(),
	/**
	 * Red colour
	 */
	RED(), 
	/**
	 * Green colour
	 */
	GREEN(), 
	/**
	 * Yellow colour
	 */
	YELLOW();

	/**
	 * This method returns the int representation of the current object state (colour).
	 * @return int Returns an int representing the colour. (0 = null; 1 = red; 2 = green; 3 = yellow; 4 = purple;)
	 */
	public int colourToInt() {
		switch(this) {
		case RED: 
			return 1;
		case GREEN: 
			return 2;
		case YELLOW: 
			return 3;
		case PURPLE: 
			return 4;
		default: 
			return 0;		
		}
	}

	/**
	 * This method returns the string representation of the current object state (colour).
	 * @return String Returns a string representing the colour.
	 */
	public String toString(){
		switch(this){
		case PURPLE : return "P";
		case RED 	: return "R";
		case GREEN 	: return "G";
		case YELLOW	: return "Y";
		default : return null;
		}		
	}
}
