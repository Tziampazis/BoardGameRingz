package model;

/**
 * The Size enumeration contains size of rings that players owns. The sizes are represented as levels from 1 to 4.
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public enum Size {

	/**
	 * Level1 size
	 */
	LEVEL1(), 
	/**
	 * Level2 size
	 */
	LEVEL2(), 
	/**
	 * Level3 size
	 */
	LEVEL3(), 
	/**
	 * Level4 size
	 */
	LEVEL4();

	/**
	 * This method returns the int representation of the current object state (size).
	 * @return int Returns an int representing the level(size). (0 = null; 1 = level1; 2 = level2; 3 = level3; 4 = level4;)
	 */
	public int sizeToInt() {
		switch(this) {
		case LEVEL1: 
			return 1;
		case LEVEL2: 
			return 2;
		case LEVEL3: 
			return 3;
		case LEVEL4: 
			return 4;
		default: 
			return 0;		
		}
	}

	/**
	 * This method returns the string representation of the current object state (size).
	 * @return String Returns a string representing the size.
	 */
	public String toString() {
		switch(this) {
		case LEVEL1: 
			return "level1: small";
		case LEVEL2: 
			return "level2: medium";
		case LEVEL3: 
			return "level3: large";
		case LEVEL4: 
			return "level4: extra large";
		default: 
			return "";		
		}
	}
}
