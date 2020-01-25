package model;

import java.util.ArrayList;
import java.util.List;

public class RingzAndBases {

	public static final int NUM_RINGS = 12;
    public static final int NUM_MAX_COLOURS = 2;
    public static final int NUM_SIZES = 4;
    public static final int NUM_MAX_BASES = 4;
    
	
	
		private List<Ring> redring;
	    private List<Ring> greenring;
	    private List<Ring> yellowring;
	    private List<Ring> purplering;
	    private List<Base> redbase;
	    private List<Base> greenbase;
	    private List<Base>yellowbase;
	    private List<Base> purplebase;
	    private List<Colour> colourp1;
	    private List<Colour> colourp2;
	    private List<Colour> colourp3;
	    private List<Colour> colourp4;
	    private List<List<Colour>> colors;
	    private Size[] size;
	    
	    public RingzAndBases(){
	    	redring = new ArrayList<Ring>(NUM_RINGS);
	    	yellowring = new ArrayList<Ring>(NUM_RINGS);
	    	purplering = new ArrayList<Ring>(NUM_RINGS);
	    	greenring = new ArrayList<Ring>(NUM_RINGS);
	    	redbase = new ArrayList<Base>(NUM_MAX_BASES);
	    	yellowbase = new ArrayList<Base>(NUM_MAX_BASES);
	    	purplebase = new ArrayList<Base>(NUM_MAX_BASES);
	    	greenbase = new ArrayList<Base>(NUM_MAX_BASES);
	    	
	    	colourp1 = new ArrayList<Colour>(NUM_MAX_COLOURS);
	    	colourp2 = new ArrayList<Colour>(NUM_MAX_COLOURS);
	    	colourp3 = new ArrayList<Colour>(NUM_MAX_COLOURS);
	    	colourp4 = new ArrayList<Colour>(NUM_MAX_COLOURS);
	    	colors = new ArrayList<List<Colour>>();
	    	
	    	size = new Size[NUM_SIZES];
	    	size[0] = Size.LEVEL1;
	    	size[1] = Size.LEVEL2;
	    	size[2] = Size.LEVEL3;
	    	size[3] = Size.LEVEL4;
	    }
	    
	    /*@ensures getRedRings().size() == 12
	     *@ensures redbases.size() == 3
	     */
	    public void createRed(){
		    for(int i =0;i<3;i++){
		    	for(int k =0;k<4;k++){
		    		this.redring.add(new Ring(Colour.RED,size[k]));
		    	}
		    }
		    for(int i =0;i<3;i++){
		    	this.redbase.add(new Base(Colour.RED));
		    }
	    }
	    
	    public void createGreen(){
	    	for(int i =0;i<3;i++){
	    		for(int k =0;k<4;k++){
	    			this.greenring.add(new Ring(Colour.GREEN,size[k]));
	    		}
	    	}
	    	for(int i =0;i<3;i++){
	    		this.greenbase.add(new Base(Colour.GREEN));
	    	}
		
	    }
	    public void createYellow(){
	    	for(int i =0;i<3;i++){
	    		for(int k =0;k<4;k++){
	    			this.yellowring.add(new Ring(Colour.YELLOW,size[k]));		
	    		}
	    	}
	    	for(int i =0;i<3;i++){
	    		this.yellowbase.add(new Base(Colour.YELLOW));
	    	}
		
	    }
	    public void createPurple(){
	    	for(int i =0;i<3;i++){
	    		for(int k =0;k<4;k++){
	    			this.purplering.add(new Ring(Colour.PURPLE,size[k]));
	    		}
	    	}
	    	for(int i =0;i<3;i++){
	    		this.purplebase.add(new Base(Colour.PURPLE));
	    	}
		
	    }
	   /*@requires numofPlayers >=2 && numofPlayers <=4
	    *@ensures numofPlayers == 2 ==> List<List<Ring>> suplist.size() == 2 || numofPlayers == 3 ==> List<List<Ring>> suplist.size() == 3 ||
	    *numofPlayers == 4 ==> List<List<Ring>> suplist.size() == 4 || numofPlayers <2 || numofPlayers >4 ==> \result null
	    */
	   public List<List<Ring>> determineRingColours(int numofPlayers){
		   List<Ring> list1 = new ArrayList<>();
		   List<Ring> list2 = new ArrayList<>();
		   List<Ring> list3 = new ArrayList<>();
		   List<Ring> list4 = new ArrayList<>();
		   List<List<Ring>> suplist = new ArrayList<>(2);
		   if(numofPlayers==2){
			   for(Ring r : redring){
				   list1.add(r);
			   }
			   for(Ring r : greenring){
				   list1.add(r);
			   }
			   colourp1.add(Colour.RED);
			   colourp1.add(Colour.GREEN);
			   for(Ring r : yellowring){
				   list2.add(r);
			   }
			   for(Ring r : purplering){
				   list2.add(r);
			   }
			   colourp2.add(Colour.YELLOW);
			   colourp2.add(Colour.PURPLE);
			   colors.add(colourp1);
			   colors.add(colourp2);

			   suplist.add(list1);
			   suplist.add(list2);
			   return suplist;
		   }else if(numofPlayers==3){
			   int i;
			   for(Ring r : redring){
				   list1.add(r);
			   }
			   for(Ring r : greenring){
				   list2.add(r);
			   }
			   for(Ring r : yellowring){
				   list3.add(r);
			   }
			   i=0;
			   for(Ring r : purplering){
				   list1.add(r);
				   if(i==3){
					   break;
				   }
				   i++;
			   }
			   i=0;
			   for(Ring r : purplering){
				   list2.add(r);
				   if(i==3){
					   break;
				   }
				   i++;
			   }
			   i=0;
			   for(Ring r : purplering){
				   list3.add(r);
				   if(i==3){
					   break;
				   }
				   i++;
			   }
			   colourp1.add(Colour.RED);
			   colourp1.add(Colour.PURPLE);
			   colourp2.add(Colour.GREEN);
			   colourp2.add(Colour.PURPLE);
			   colourp3.add(Colour.YELLOW);
			   colourp3.add(Colour.PURPLE);
			   colors.add(colourp1);
			   colors.add(colourp2);
			   colors.add(colourp3);
			
			   suplist.add(list1);
			   suplist.add(list2);
			   suplist.add(list3);
			   return suplist;
		   }else if(numofPlayers==4){
			   for(Ring r : redring){
				   list1.add(r);
			   }
			   for(Ring r : greenring){
				   list2.add(r);
			   }
			   for(Ring r : yellowring){
				   list3.add(r);
			   }
			   for(Ring r : purplering){
				   list4.add(r);
			   }
			   colourp1.add(Colour.RED);
			   colourp2.add(Colour.GREEN);
			   colourp3.add(Colour.YELLOW);
			   colourp4.add(Colour.PURPLE);
			   colors.add(colourp1);
			   colors.add(colourp2);
			   colors.add(colourp3);
			   colors.add(colourp4);
			   suplist.add(list1);
			   suplist.add(list2);
			   suplist.add(list3);
			   suplist.add(list4);
			   return suplist;
		   }else{
			   return null;
		   }
	   }
	   /*@requires numofPlayers >=2 && numofPlayers <=4
	    *@ensures numofPlayers == 2 ==> List<List<Ring>> suplist.size() == 2 || numofPlayers == 3 ==> List<List<Ring>> suplist.size() == 3 ||
	    *numofPlayers == 4 ==> List<List<Ring>> suplist.size() == 4 || numofPlayers <2 || numofPlayers >4 ==> \result null
	    */
	   public List<List<Base>> determineBaseColours(int numofPlayers){
		   List<Base> list1 = new ArrayList<>();
		   List<Base> list2 = new ArrayList<>();
		   List<Base> list3 = new ArrayList<>();
		   List<Base> list4 = new ArrayList<>();
		   List<List<Base>> suplist = new ArrayList<>();
		   if(numofPlayers==2){
			   for(Base r : redbase){
				   list1.add(r);
			   }
			   for(Base r : greenbase){
				   list1.add(r);
			   }
			   for(Base r : yellowbase){
				   list2.add(r);
			   }
			   for(Base r : purplebase){
				   list2.add(r);
			   }		   
			   suplist.add(list1);
			   suplist.add(list2);
			   return suplist;
		   }else if(numofPlayers==3){
			   for(Base r : redbase){
				   list1.add(r);
			   }
			   for(Base r : greenbase){
				   list2.add(r);
			   }
			   for(Base r : yellowbase){
				   list3.add(r);
			   }
			  
			   list1.add(purplebase.get(0));
			  
			   list2.add(purplebase.get(1));
			   
			   list3.add(purplebase.get(2));
			   
		   
			   suplist.add(list1);
			   suplist.add(list2);
			   suplist.add(list3);
			   return suplist;
		   }else if(numofPlayers==4){
			   for(Base r : redbase){
				   list1.add(r);
			   }
			   for(Base r : greenbase){
				   list2.add(r);
			   }
			   for(Base r : yellowbase){
				   list3.add(r);
			   }
			   for(Base r : purplebase){
				   list4.add(r);
			   }
			   suplist.add(list1);
			   suplist.add(list2);
			   suplist.add(list3);
			   suplist.add(list4);
			   return suplist;
		   }else{
			   return null;
		   }
	   }

	   
	   
	   //GETTERS
	   /*@pure
	    * 
	    */
	   public List<Ring> getGreenring(){
	   	return this.greenring;
	   }
	   /*@pure
	    * 
	    */
	   public List<Ring> getYellowring(){
		   	return this.yellowring;
	   }
	   /*@pure
	    * 
	    */
	   public List<Ring> getRedring(){
		   	return this.redring;
	   }
	   /*@pure
	    * 
	    */
	   public List<Ring> getPurplering(){
		   	return this.purplering;
	   }
	   /*@pure
	    * 
	    */
	   public List<Colour> getColP1(){
		   return this.colourp1;
	   }
	   /*@pure
	    * 
	    */
	   public List<Colour> getColP2(){
		   	return this.colourp2;
	   }
	   /*@pure
	    * 
	    */
	   public List<Colour> getColP3(){
		   	return this.colourp3;
	   }
	   /*@pure
	    * 
	    */
	   public List<Colour> getColP4(){
		   	return this.colourp4;
	   }
	   /*@pure
	    * 
	    */
	   public List<List<Colour>> getColList(){
		   return this.colors;
	   }
}
