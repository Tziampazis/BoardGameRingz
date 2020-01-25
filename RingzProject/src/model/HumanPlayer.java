package model;

import java.util.List;
import java.util.Observable;
import java.util.Scanner;

/**
 * The HumanPlayer class is the class that extends Player and gets the move from a real person using input methods. The command
 * that the player needs to introduce is coded using an int array and is passing through a scanner that is keyboard in our case.
 * 
 * @author Christodoulos Tziampazis & Mihai Marin
 * @version 1.0
 * @since 2018-01-15
 */
public class HumanPlayer extends Player{

	Scanner scannerLine;

	/**
	 * Constructor that calls the constructor of the player using super.
	 * @param name The name of the player.
	 * @param bases Bases of the player.
	 * @param rings Rings of the player.
	 * @param colours Colours of the player.
	 */
	public HumanPlayer(String name, List<Base> bases, List<Ring> rings, List<Colour> colours) {
		super(name, bases, rings, colours);
	}

	/**
	 * This method asks the player to imput his choice. First the prompt of the request is configured, then
	 * a verification of the introduced values is made, until the choice is valid. 
	 */
	public int[] determineMove(Board board) {
		List<Colour> c = getColours();
		String prompt;
		if(c.size() == 2) {
			prompt = ">" + this.getName() + " (" + c.get(0).colourToInt() + ":" + c.get(0) + ", " + c.get(1).colourToInt() + ":" + c.get(1) + ")" + 
					", what is you choice?\n Give the answer like this : <Piece> <Colour> <Size> <Index>.\n"
					+ " <Piece> can be 0 (Base) or 1 (Ring).\n"
					+ " <Colour> can be 1 (Red) or 2 (Green) or 3 (Yellow) or 4 (Purple).\n"
					+ " <Size> can be 0 (Base) or 1 (Level1) or 2 (Level2) or 3 (Level3) or 4 (Level4).\n"
					+ " <Index> can be between 0 and 24.\n>";
		} else {
			prompt = ">" + this.getName() + " (" + c.get(0).colourToInt() + ":" + c.get(0) + ")" + 
					", what is you choice?\n Give the answer like this : <Piece> <Colour> <Size> <Index>.\n"
					+ " <Piece> can be 0 (Base) or 1 (Ring).\n"
					+ " <Colour> can be 1 (Red) or 2 (Green) or 3 (Yellow) or 4 (Purple).\n"
					+ " <Size> can be 0 (Base) or 1 (Level1) or 2 (Level2) or 3 (Level3) or 4 (Level4).\n"
					+ " <Index> can be between 0 and 24.\n>";
		}
		int[] choice = readInt(prompt);
		boolean valid = false;
		int piece = choice[0];
		int colour = choice[1];
		int size = choice[2];
		int index = choice[3];
		if(piece == 0) {
			Base base = new Base(intToColour(colour));
			valid = board.isValidMoveBase(base, index) && hasColour(intToColour(colour)) && hasBase(intToColour(colour));
		} else if(piece == 1) {
			Ring ring = new Ring(intToColour(colour), intToSize(size));
			valid = board.isValidMoveRing(ring, index) && hasColour(intToColour(colour)) && hasRing(intToColour(colour), intToSize(size));
		}

		while (!valid) {
			System.out.println("ERROR: Move ( " + piece + " " + colour + " " + size + " " + index + " ) is not valid.");
			choice = readInt(prompt);
			piece = choice[0];
			colour = choice[1];
			size = choice[2];
			index = choice[3];

			if(piece == 0) {
				Base base = new Base(intToColour(colour));
				valid = board.isValidMoveBase(base, index) && hasColour(intToColour(colour)) && hasBase(intToColour(colour));
			} else if(piece == 1) {
				Ring ring = new Ring(intToColour(colour), intToSize(size));
				valid = board.isValidMoveRing(ring, index) && hasColour(intToColour(colour)) && hasRing(intToColour(colour), intToSize(size));
			}
		}
		return choice;	
	}

	/**
	 * This method asks player to input his choice for the starting base until his choice is valid.
	 */
	public int determineStartBase(Board board) {
		boolean valid = false;
		String prompt = ">" + this.getName() + 
				", what is you choice for starting base?\n Give the answer like this: <Index>.\n"
				+ " Index can be: 6,7,8,11,12,13,16,17,18.\n>";
		int choice = readOneInt(prompt);
		valid =  board.canPlaceStartBase(choice);
		while(!valid) {
			System.out.println(" ERROR: Move (" + choice + ") is not valid.\n Index should be: 6,7,8,11,12,13,16,17,18." );
			choice = readOneInt(prompt);
			valid = board.canPlaceStartBase(choice);
		}
		//scannerLine.close();
		return choice;
	}

	/**
	 * This method initializes the scanner and asks the user for one int.
	 * @param prompt The message that appears on screen when requesting an int.
	 * @return An int representing the index of the teritory where start base should be.
	 */
	private int readOneInt(String prompt) {
		int i =0;
		boolean intRead = false;

		scannerLine = new Scanner(System.in);
		do {
			System.out.print(prompt);
			try (Scanner scan = new Scanner(scannerLine.nextLine());) {
				if (scan.hasNextInt()) {
					i = scan.nextInt();
					intRead = true;
				} else {
					System.out.println(" ERROR: Give the answer like this : <Index>.");

					//TODO create invalid input exception
					//	throw new InvalidInputException();
				}
			}
		} while (!intRead);
		//line.close();
		return i; 
	}

	/**
	 * This method initializes the scanner and asks the user for a move.
	 * @param prompt The message that appears on screen when requesting the move.
	 * @return An int array representing the encoded move.
	 */
	private int[] readInt(String prompt)/* throws InvalidInputException */{
		int p = 0;
		int c = 0;
		int s = 0;
		int i = 0;

		boolean intRead = false;

		scannerLine = new Scanner(System.in);
		do {
			System.out.print(prompt);
			try (Scanner scan = new Scanner(scannerLine.nextLine());) {
				if (scan.hasNextInt()) {
					p = scan.nextInt();
				} 
				if (scan.hasNextInt()) {
					c = scan.nextInt();
				} 
				if (scan.hasNextInt()) {
					s = scan.nextInt();
				} 
				if (scan.hasNextInt()) {
					i = scan.nextInt();
					intRead = true;
				} else {
					System.out.println("ERROR: Give the answer like this : <Piece> <Colour> <Size> <Index>.");

					//TODO create invalid input exception
					//	throw new InvalidInputException();
				}
			}
		} while (!intRead);
		//scan.close();
		//scannerLine.close();
		int[] choice = {p, c, s, i};
		return choice;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}