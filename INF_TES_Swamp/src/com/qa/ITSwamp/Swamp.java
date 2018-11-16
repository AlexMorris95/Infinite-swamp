package com.qa.ITSwamp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.qa.sacnners.Lecture;

public class Swamp {
	public  int xloc;
	public  int yloc;
	public  int xtreasure;
	public  int ytreasure;
	public int Pos;
	//int xdisplace;
	//int ydisplace;
	float totdist;
	float xdisplace;
	float ydisplace;

	public static void main(String[] args) {
	Swamp swampy= new Swamp();
	swampy.start();
	
	
	}
	
	public void start() {
		Random rand = new Random();

	ArrayList<String> fluff = new ArrayList<>();
      fluff.add("The swamp seems more forgiving here but you reamin on guard");
      fluff.add("AAARRRGGH WHAT WAS THAT? A giant splash erupts behind you as if something had crashed to the water behind you.");
      fluff.add(" The fog encroaches further in , you can barely see you hand infront of you face");
      fluff.add(" An ominous caw of a raven calls somewhere above you , your sense of dispair grows");
      fluff.add("You can just about make out the sun shining throught the fog, if only you knew what time it was it could have helped");
      fluff.add("Its unusually cold here, the water leaches your strength");
      System.out.println(fluff.get(rand.nextInt(fluff.size()-0 +1)));
		
		// nextInt as provided by Random is exclusive of the top value so you need to add 1 
		int xtreasure  = rand.nextInt((9 - 0) + 1) ;
		int ytreasure  = rand.nextInt((9 - 0) + 1) ;
		//int xloc = rand.nextInt((9 - 0) + 1) ;
		//int yloc = rand.nextInt((9 - 0) + 1) ;
		// System.out.println(xtreasure);
		Swamp dir = new Swamp();
		
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		while ((xtreasure!=xloc) && (ytreasure!=yloc))
		{
			       
	    String travel =(dir.input());
	    dir2grid (travel); // recompute position
	    System.out.println("");
		disttoo();          // recompute distance to treasure
		 System.out.println("You watch changes to " + totdist + " as you move");

	    System.out.println(fluff.get(rand.nextInt(fluff.size()-0)));
	    System.out.println("Your location x " + xloc);
	    System.out.println("Your location y " + yloc);
	    System.out.println(xtreasure);
	    System.out.println(ytreasure);

		}
		
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		System.out.println("But wait whats this? a trasure chest?! Gold! rubies! saphires! and... a map you can finaly leave this accursed swamp ");
		
		//dir2grid dg= new dir2grid()
		//dir2grid(dir.input());
	}

	public String input() {
		Scanner sc = new Scanner(System.in);
		String Direction = sc.nextLine();

		return Direction;
	}

	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
public void dir2grid(String direction) 
{     
	//int this.xloc=xloc;
	//int this.yloc=yloc;
	
	if (direction.equals("n")) {
		yloc = yloc + 1;
				if (yloc == 10) 
				   {yloc = 0;} 
	} else if (direction.equals("s"))  {
		yloc = yloc - 1;
		   if (yloc == -1) 
		      {yloc = 9;} 
	}
    else if (direction.equals("e")) {
    	
    	xloc=xloc + 1 ;
    			if (xloc == 10) 
				   {xloc = 0;} 
    }
    else if (direction.equals("w")) {
    	xloc=xloc - 1 ;
    			if (xloc == -1) 
				   {xloc = 9;} 
	}
 }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public void disttoo() {
		xdisplace = Math.min(Math.abs(10 - (xloc - xtreasure)), Math.abs(xtreasure - xloc));
		ydisplace = Math.min(Math.abs(10 - (yloc - ytreasure)), Math.abs(ytreasure - yloc));
		System.out.println(xdisplace);
		System.out.println(ydisplace); 
	 totdist = (float) Math.sqrt((xdisplace * xdisplace)+ (ydisplace * ydisplace));
	}
}