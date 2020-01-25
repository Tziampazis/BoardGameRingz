package model;

/**
 * This is the class for a territory on the board. A territory can have either a base or multiple rings of different sizes.
 *
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public class Territory {

	/**
	 * The base on the territory.
	 */
	private Base base;
	/**
	 * The ring of size level1 on the territory.
	 */
	private Ring ringlevel1;
	/**
	 * The ring of size level2 on the territory.
	 */
	private Ring ringlevel2;
	/**
	 * The ring of size level3 on the territory.
	 */
	private Ring ringlevel3;
	/**
	 * The ring of size level4 on the territory.
	 */
	private Ring ringlevel4;

	/**
	 * Constructor that initializes the base and rings to null. That means that the territory is empty.
	 */
	public Territory() {
		base = null;
		ringlevel1 = null;
		ringlevel2 = null;
		ringlevel3 = null;
		ringlevel4 = null;
	}

	/**
	 * Getter for base on the territory.
	 * @return The base on the territory. Returns null if there is no base.
	 */
	public Base getBase() {
		return base;
	}

	/**
	 * Setter for base on the territory.
	 * @param base The base that needs to be placed on this territory.
	 */
	public void setBase(Base base) {
		this.base = base;
	}

	/**
	 * Verifier for base on the territory. The colour of the base doesnt matter.
	 * @return The boolean value that verifies if a base was placed. (0 = no; 1 = yes)
	 */
	public boolean hasBase() {
		return !(base == null);
	}

	/**
	 * Verifier for base of a given colour on the territory.
	 * @param colour The colour of the base that needs to be verified with the one on the territory.
	 * @return The boolean value that verifies if a base of the colour specified as parameter was placed. (0 = no; 1 = yes)
	 */
	public boolean hasBase(Colour colour) {
		return hasBase() && base.getColour() == colour;
	}

	/**
	 * Getter for ring with size level1 on the territory.
	 * @return The ring with size 1 on the territory. Returns null if there is no ring with this size.
	 */
	public Ring getRingLevel1() {
		return ringlevel1;
	}

	/**
	 * Setter for ring with size level1 on the territory.
	 * @param ring The ring that needs to be placed on this territory.
	 */
	public void setRingLevel1(Ring ring) {
		this.ringlevel1 = ring;
	}

	/**
	 * Verifier for ring with size level1 on the territory. The colour of the ring doesnt matter.
	 * @return The boolean value that verifies if a ring size level1 was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel1() {
		return ringlevel1 != null;
	}

	/**
	 * Verifier for ring with size level1 of a given colour on the territory.
	 * @param colour The colour of the ring that needs to be verified with the ring on the territory.
	 * @return The boolean value that verifies if a ring with size level1 of the colour specified as parameter was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel1(Colour colour) {
		return hasRingLevel1() && ringlevel1.getColour() == colour;
	}

	/**
	 * Getter for ring with size level2 on the territory.
	 * @return The ring with size 2 on the territory. Returns null if there is no ring with this size.
	 */
	public Ring getRingLevel2() {
		return ringlevel2;
	}

	/**
	 * Setter for ring with size level2 on the territory.
	 * @param ring The ring that needs to be placed on this territory.
	 */
	public void setRingLevel2(Ring ring) {
		this.ringlevel2 = ring;
	}

	/**
	 * Verifier for ring with size level2 on the territory. The colour of the ring doesnt matter.
	 * @return The boolean value that verifies if a ring size level2 was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel2() {
		return ringlevel2 != null;
	}

	/**
	 * Verifier for ring with size level2 of a given colour on the territory.
	 * @param colour The colour of the ring that needs to be verified with the ring on the territory.
	 * @return The boolean value that verifies if a ring with size level2 of the colour specified as parameter was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel2(Colour colour) {
		return hasRingLevel2() && ringlevel2.getColour() == colour;
	}

	/**
	 * Getter for ring with size level3 on the territory.
	 * @return The ring with size 3 on the territory. Returns null if there is no ring with this size.
	 */
	public Ring getRingLevel3() {
		return ringlevel3;
	}

	/**
	 * Setter for ring with size level3 on the territory.
	 * @param ring The ring that needs to be placed on this territory.
	 */
	public void setRingLevel3(Ring ring) {
		this.ringlevel3 = ring;
	}

	/**
	 * Verifier for ring with size level3 on the territory. The colour of the ring doesnt matter.
	 * @return The boolean value that verifies if a ring size level3 was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel3() {
		return ringlevel3 != null;
	}

	/**
	 * Verifier for ring with size level3 of a given colour on the territory.
	 * @param colour The colour of the ring that needs to be verified with the ring on the territory.
	 * @return The boolean value that verifies if a ring with size level3 of the colour specified as parameter was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel3(Colour colour) {
		return hasRingLevel3() && ringlevel3.getColour() == colour;
	}

	/**
	 * Getter for ring with size level4 on the territory.
	 * @return The ring with size 4 on the territory. Returns null if there is no ring with this size.
	 */
	public Ring getRingLevel4() {
		return ringlevel4;
	}

	/**
	 * Setter for ring with size level4 on the territory.
	 * @param ring The ring that needs to be placed on this territory.
	 */
	public void setRingLevel4(Ring ring) {
		this.ringlevel4 = ring;
	}

	/**
	 * Verifier for ring with size level4 on the territory. The colour of the ring doesnt matter.
	 * @return The boolean value that verifies if a ring size level4 was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel4() {
		return ringlevel4 != null;
	}

	/**
	 * Verifier for ring with size level4 of a given colour on the territory.
	 * @param colour The colour of the ring that needs to be verified with the ring on the territory.
	 * @return The boolean value that verifies if a ring with size level4 of the colour specified as parameter was placed. (0 = no; 1 = yes)
	 */
	public boolean hasRingLevel4(Colour colour) {
		return hasRingLevel4() && ringlevel4.getColour() == colour;
	}

	/**
	 * Verifier for ring of any size on the territory.
	 * @return The boolean value that verifies if the territory has at least one ring on one of the ring sizes.
	 */
	public boolean hasRing() {
		return hasRingLevel1() || hasRingLevel2() || hasRingLevel3() || hasRingLevel4();
	}

	/**
	 * Verifier for ring of a given size on the territory.
	 * @param size The size of the ring that has to be checked.
	 * @return The boolean value that verifies if the territory has a ring with the specified size.
	 */
	public boolean hasRing(Size size) {
		switch (size) {
		case LEVEL1:
			return hasRingLevel1();
		case LEVEL2:
			return hasRingLevel2();
		case LEVEL3:
			return hasRingLevel3();
		case LEVEL4:
			return hasRingLevel4();
		default:
			return false;
		}
	}

	/**
	 * Verifier for ring of a given colour on the territory.
	 * @param colour The colour of the ring that has to be checked.
	 * @return The boolean value that verifies if the territory has at least one ring with the specified colour.
	 */
	public boolean hasRing(Colour colour) {
		return hasRingLevel1(colour) || hasRingLevel2(colour) || hasRingLevel3(colour) || hasRingLevel4(colour);
	}

	/**
	 * Method that checks whether the territory is empty or not.
	 * @return The boolean value that verifies if the territory has a base or a ring on it.
	 */
	public boolean isOccupied() {
		return hasBase() || hasRing();
	}

	/**
	 * Method that checks wheter the territory has a piece ( base or ring) of a given colour.
	 * @param colour The colour that need to be checked.
	 * @return The boolean value that verifies if the territory has a base or a ring with the specified colour on it.
	 */
	public boolean isOccupiedBy(Colour colour) {
		return hasBase(colour) || hasRing(colour);
	}

	/**
	 * Method that sets a ring on the territory. It takes into account the size of the ring.
	 * @param ring The ring that has to be set on the given territory.
	 */
	public void setRing(Ring ring) {
		Size size = ring.getSize();
		switch (size) {
		case LEVEL1:
			setRingLevel1(ring);
			break;
		case LEVEL2:
			setRingLevel2(ring);
			break;
		case LEVEL3:
			setRingLevel3(ring);
			break;
		case LEVEL4:
			setRingLevel4(ring);
			break;
		default:
			return;
		}
	}

	/**
	 * Method that checks whether the territory has all rings set. That means that no ring property of the territory should be null.
	 * @return The boolean value that checks if theres a ring of each size.
	 */
	public boolean hasAllRings() {
		return hasRing(Size.LEVEL1) && hasRing(Size.LEVEL2) && hasRing(Size.LEVEL3) && hasRing(Size.LEVEL4);
	}

	/**
	 * Method that checks whether the territory is full. A territory is full when it has a base or when it has all rings set.
	 * @return The boolean value that checks if theres a base or a ring of each size.
	 */
	public boolean isFull() {
		return hasAllRings() || hasBase();
	}

	/**
	 * Method that returns the color that wins this territory.
	 * Colour c wins the territory with 4 rings if all 4 rings or 3 are colour c or 2 rings are colour c and the other 2 rings are different colours;
	 * with 3 rings if all 3 rings or 2 are colour c; with 2 rings if both are colour c; with 1 ring if that is colour c.
	 * The method first creates an array of ints that counts how many times each colour occurs within the rings. The index of this array represents a colour
	 * 0 is red; 1 is green; 2 is yellow; 3 is purple. Then it sums up the values of this array to find how many rings are on this territory.
	 * Then it checks the rules mentioned above .
	 * @return The colour that owns the majority on this territory. If there is a tie, it returns null.
	 */
	public Colour isOwnedBy() {
		int[] countColours = new int[4];
		for(int i = 0; i < 4; i++) {
			countColours[i] = 0;
			if(hasRingLevel1(intToColour(i+1))) {
				countColours[i]++;
			}
			if(hasRingLevel2(intToColour(i+1))) {
				countColours[i]++;
			}
			if(hasRingLevel3(intToColour(i+1))) {
				countColours[i]++;
			}
			if(hasRingLevel4(intToColour(i+1))) {
				countColours[i]++;
			}
		}
		int total = countColours[0] + countColours[1] + countColours[2] + countColours[3];
		if(total == 1) {
			for(int i = 0; i < 4; i++) {
				if(countColours[i] == 1) {
					return intToColour(i+1);
				}
			}
		} else if(total == 2) {
			for(int i = 0; i < 4; i++) {
				if(countColours[i] == 2) {
					return intToColour(i+1);
				}
			}
		} else if(total == 3) {
			for(int i = 0; i < 4; i++) {
				if(countColours[i] == 3 || countColours[i] == 2) {
					return intToColour(i+1);
				}
			}
		} else if(total == 4) {
			for(int i = 0; i < 4; i++) {
				if(countColours[i] == 4 || countColours[i] == 3 || 
						(countColours[i] == 2 && countColours[(i + 1) % 4] != 2 && countColours[(i + 2) % 4] != 2
						&& countColours[(i + 3) % 4] != 2)) {
					return intToColour(i+1);
				}
			}
		}
		return null;
	}

	/**
	 * Method that converts an integer to a colour. Used for the array in method isOwnedBy().
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

}
