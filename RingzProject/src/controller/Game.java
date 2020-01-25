package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import model.*;

public class Game extends Observable  {

	
    private Board board;
    private List<Player> listofCurrentPlayers;
    private List<Player> listofAllPlayers;
    private boolean gameOver = true;
    /*@private invariant gameOver == true || gameOver == false;*/
    private Random rand;
    /*@private invariant rand >= 0 && rand <=3*/
    private int numOfPlayers;
    /*@private invariant numOfPlayers >= 2 && numOfPlayers <=4*/
	private List<Player> observers;
    
    public Game(int numOfPlayers,List<Player> players){
    	board = new Board();
    	rand = new Random();
    	this.numOfPlayers = numOfPlayers;
    	
    	this.listofAllPlayers = new ArrayList<Player>(players);
    	this.listofCurrentPlayers = new ArrayList<Player>(players);
    }
    
    public void play(){
    	int current;
    	int firstround =0;
    	current = rand.nextInt(numOfPlayers);
    	while(current<0 && current>3){
    		current = rand.nextInt(numOfPlayers);
    	}
    	if(firstround==0){//determine the starting base
			getListOfCurrentPlayers().get(current).addStartBase(board);
			setChanged();
    		notifyObservers(board.toString());
    		firstround++;
		} 	
    	
    	//System.out.println(board.toString());
    	while(gameOver){
    		current++;
    		current = current % getNumOfPlayers();
    		System.out.println("current : " + current + "  Name : "+getListOfCurrentPlayers().get(current).getName()+ " getNumofPlayers:" + getNumOfPlayers() );
    		setChanged();
    		notifyObservers(board.toString());
    		getListOfCurrentPlayers().get(current).makeMove(getBoard());
    		for(Ring r : listofCurrentPlayers.get(current).getRings()){
    			System.out.println("ring : " + r.getColour() + " con size "+ r.getSize() + " of " + listofCurrentPlayers.get(current).getName() );
    		}
    		if(!getListOfCurrentPlayers().get(current).canStillMakeMoveRing(board) && !getListOfCurrentPlayers().get(current).canStillMakeMoveBases(board)){
    			System.out.println("No more valid moves for Player : "+ getListOfCurrentPlayers().get(current).getName()+ " removing player from the game! " );
    			System.out.println("player list left : " + getListOfCurrentPlayers().get(current).getRings().isEmpty());
    			removePlayer(getListOfCurrentPlayers().get(current));
    			setNumOfPlayers(getListOfCurrentPlayers().size());
    			System.out.println("size of list: " + getListOfCurrentPlayers().size());
    			gameOverPlayers();
    		}
    		
		//	System.out.println(board.toString());
			if(getNumOfPlayers()==0){
				gameOverPlayers();
			}
    	}
    	System.out.println("\nPrinting Resutls : \n");
    	
    	
    	Player pl = getResults();
    	if(pl != null){
    		System.out.println(getBoard().isWinner());
	    	for(Player p : getListOfAllPlayers()){
	    		if(p == pl){
	    			System.out.println("Winner" + p.getName()+" with colors : " + p.getColours());
	    		}
	    	}
	    }else{
    		System.out.println("The game is a tie");
    	}

    }
    
    /*@pure
     */
   public Board getBoard(){
	   return this.board;
   }
   /*@pure
    */
   public List<Player> getListOfCurrentPlayers(){
	   return this.listofCurrentPlayers;
   }
   /*@pure
    */
   public List<Player> getListOfAllPlayers(){
	   return this.listofAllPlayers;
   }
   /*@pure
    */
   public int getNumOfPlayers(){
	   return this.numOfPlayers;
   }
   /*@requires n >= 0 && n <=4
    *@ensures getNumOfPlayers() == n
    */
   public void setNumOfPlayers(int n){
	   this.numOfPlayers = n;
   }
   /*@requires pl != null
    *@ensures getListOfCurrentPlayers() ==  pl
    */
   public void setCurrentPlayerList(List<Player> pl){
	   this.listofCurrentPlayers = pl;
   }
   /*@requires pl != null
    *@ensures getListOfAllPlayers() ==  pl
    */
   public void setAllPlayerList(List<Player> pl){
	   this.listofAllPlayers = pl;
   }   
   
   /*@requires player != null && player instanceof Player
    *@ensures \result getListOfCurrentPlayers().size() == \old(getListOfCurrentPlayers().size()) -1
    *@ensures \result !getListOfCurrentPlayers().contains(player);
    */
   /**
    * This method remove the player from the current player List that they left with no rings to play.
    */
   private void removePlayer(Player player){
	   this.listofCurrentPlayers.remove(player);
   }
  
   /*@ensures getListOfCurrentPlayers().isEmpty() ==> gemeOver() == false
    */
   /**
    * this method check whether the list of currentPlayers is all empty. That means all the players have placed 
    * all their rings and there is no move left. 
    */
   private void gameOverPlayers(){
	   if(getListOfCurrentPlayers().isEmpty()){
		   this.gameOver = false;
	   }
   }
   /*@ensures \result player || null
    * 
    */
   /**
	*This method calculates the winner of the game based on the results of the method getBoard().isWinner()
    * @return List<Player> 
    * @return null
    */
   private Player getResults(){
	   Map<String,Integer> map = getBoard().isWinner();
	   if(map == null) {
		   System.out.println("Winner is null");
		   return null;
	   }
	   System.out.println("winner is not null");
	  // int fl = getBoard().isWinner().length;
	   List<String> winnerColour ;
	 	   
			  //Check up for only 1 color
			   if(getListOfAllPlayers().size() == 4){
				   winnerColour = new ArrayList<String>();
				   int max = Collections.max(map.values());
					System.out.println("Max Values " +max);
					for(String k : map.keySet()){
						if(map.get(k) == max){
							winnerColour.add(k);
						}
					}
					if(winnerColour.size() != 1){
						return null;
					}
				   for(Player p : getListOfAllPlayers()){
					   for(String c : winnerColour){
						   if(p.getColours().size() ==  1){
							   System.out.println("color : " + c);
							   if(c ==  p.getColours().get(0).toString()){
								   return p;
							   }
						   }
						   break;
					   }
				   }
				}else if(getListOfAllPlayers().size() == 3){
					winnerColour = new ArrayList<String>();
					map.remove("P",map.get("P"));
					System.out.println(map);
					int max = Collections.max(map.values());
					int count=0;
					System.out.println("Max Values " +max);
					for(String k : map.keySet()){
						if(map.get(k) == max){
							winnerColour.add(k);
						}
						if(count == 3){
							break;
						}
						count++;
					}
					System.out.println("WinnerSize is : " + winnerColour.size());
					if(winnerColour.size() == 1){
						for(Player p : getListOfAllPlayers()){
							p.getColours().remove(Colour.PURPLE);
				   			if(p.getColours().get(0).toString().equals(winnerColour.get(0))){
				   				return p;
				   			}
				   		}
					}else{
						return null;
					}
					
			   	}else if(getListOfAllPlayers().size() == 2){
			   		winnerColour = new ArrayList<String>();
			   		System.out.println("IN 2 Pl" + winnerColour.size());

			   		int max = Collections.max(map.values());
			   		int maxp1 =0;
			   		int maxp2 =0;
					System.out.println("Max Values " +max);
					for(Colour k : getListOfAllPlayers().get(0).getColours()){
						maxp1 = maxp1 +map.get(k.toString());
					}
					for(Colour k : getListOfAllPlayers().get(1).getColours()){
						maxp2 = maxp2 +map.get(k.toString());
					}
					System.out.println("maxp1 : " + maxp1 + " maxp2 :" +maxp2);
					if(maxp1>maxp2){
						return getListOfAllPlayers().get(0);
					}else if(maxp2 > maxp1){
						return getListOfAllPlayers().get(1);
					}else{
						return null;
					}
			   	}
		   
			   return null;
	   }
    //every move in a territory should be checked here

   public void addObserver(Observer o) {
       this.observers.add((Player) o);
   }
		
   
}