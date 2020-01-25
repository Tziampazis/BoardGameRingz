package controller;

import java.util.ArrayList;
import java.util.List;

import exceptions.IllegalArgumentsException;
import model.Base;
import model.Colour;
import model.ComputerPlayer;
import model.HumanPlayer;
import model.Player;
import model.Ring;
import model.RingzAndBases;

public class RingzMain {
	
	public static void main(String[] args) {
		
		
		int numOfPlayers = args.length;
		try{
		checkArgs(numOfPlayers);
		RingzAndBases rnb = new RingzAndBases();
		rnb.createRed();
		rnb.createGreen();
		rnb.createPurple();
		rnb.createYellow();
		
		List<Player> observers = new ArrayList<>();
		Game game = new Game(numOfPlayers,determinePlayerRings(args, rnb));
		for(Player p : observers){
			game.addObserver(p);
		}
		game.play();
		}catch(IllegalArgumentsException e){
			System.out.println(e.getMessage());
		}
	}


	/*@requires ringNbases != null && nameofPlayers != null && nameofPlayers.length >= 2 && nameofPlayers.length <= 4
	 */
	/**
	 * This method accept as arguments an array of the name of the Players and an instance of the object game. The game is needed 
	 * so that we can get the required rings for the players
	 * @param nameofPlayers
	 * @param ringsNbases
	 * @return a List of Players created for the game
	 */
	public static List<Player> determinePlayerRings(String[] nameofPlayers,RingzAndBases ringsNbases){
		List<Player> players = null ;
		Player player ;
		String[] names ;
		List<List<Ring>> objRing;
		List<List<Base>> objBase;
		List<List<Colour>> objColour;
		int counterfor =0;
		int countN =0;
		int countH =0;


		//Getting the number of Human or Computer players
		for(int i=0;i<nameofPlayers.length;i++){
			if(nameofPlayers[i].equals("-C")){
				countN++;
			}else{
				countH++;
			}
		}
		
		names = new String[countH];
		//getting the names for the human players
		if(countH!=0){
			for(int i=0;i<countH;i++){
				if(!nameofPlayers[i].equals("-C")){
					names[i] = nameofPlayers[i];
				}
				
			}
		}
		System.out.println("N : "+ countN + " H : " + countH + " names[] : " +names.length);
		//Creating the players
		if(nameofPlayers.length< 2 || nameofPlayers.length > 4){
			return null;
		}else if(nameofPlayers.length == 2){
			System.out.println("In 2");
			players = new ArrayList<Player>(2);
			objRing = ringsNbases.determineRingColours(2);//this will return a list containing 2 lists of rings
			objBase = ringsNbases.determineBaseColours(2);
			objColour = ringsNbases.getColList();
			
			if(countN != 0  || countH != 0){
				if(countN!=0){
					for(int i=0;i<countN;i++){
						player = new ComputerPlayer("-N"+i,objBase.get(counterfor),objRing.get(counterfor),objColour.get(counterfor));
						if(i-1 != countN){
							counterfor++;
						}
						players.add(player);
					}
				}
				if(countN != 2){
					for(int i =0;i<names.length;i++){
						player = new HumanPlayer(names[i], objBase.get(counterfor),objRing.get(counterfor), objColour.get(counterfor));
						if(i-1 != countH){
							counterfor++;
						}
						players.add(player);
					}
				}
			}
		}else if(nameofPlayers.length == 3){
			System.out.println("In 3");
			players = new ArrayList<Player>(3);
			objRing = ringsNbases.determineRingColours(3);//this will return a list containing 2 lists of rings
			objBase = ringsNbases.determineBaseColours(3);
			objColour = ringsNbases.getColList();
			if(countN != 0 || countH != 0){
				if(countN!=0){
					for(int i=0;i<countN;i++){
						player = new ComputerPlayer("-N"+i, objBase.get(counterfor), objRing.get(counterfor), objColour.get(counterfor));
						if(i-1 != countN){
							counterfor++;
						}
						players.add(player);
					}
				}
				if(countN != 3){
					for(int i =0;i<names.length;i++){
						player = new HumanPlayer(names[i],  objBase.get(counterfor),objRing.get(counterfor), objColour.get(counterfor));
						if(i-1 != countH){
							counterfor++;
						}
						players.add(player);
					}
				}
			}
		}else if(nameofPlayers.length == 4){
			System.out.println("in 4");
			players = new ArrayList<Player>(4);
			objRing = ringsNbases.determineRingColours(4);//this will return a list containing 2 lists of rings
			objBase = ringsNbases.determineBaseColours(4);
			objColour = ringsNbases.getColList();
			if(countN != 0 || countH != 0){
				if(countN!=0){
					for(int i=0;i<countN;i++){
						player = new ComputerPlayer("-N"+i, objBase.get(counterfor), objRing.get(counterfor), objColour.get(counterfor));
						if(i-1 != countN){
							counterfor++;
						}
						players.add(player);
					}
				}
				if(countN != 4){
					for(int i =0;i<names.length;i++){
						player = new HumanPlayer(names[i],  objBase.get(counterfor), objRing.get(counterfor), objColour.get(counterfor));
						if(i != countH){
							counterfor++;
							
						}
						players.add(player);
					}
				}
			}
		}
		return players;
	}
	public static void checkArgs(int args) throws IllegalArgumentsException{
		if(args >4 || args < 2){
			throw new IllegalArgumentsException(args);
		}
	}
}
	

