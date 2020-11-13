package wordCross;
public class Pattern {
private int [][] scrabble; //Scrabble Board in chars

private int SIZE; //size of Board. For scrabble, SIZE=15

Pattern(int size){ //initializer
	this.SIZE = size;
	this.scrabble = (new int[SIZE][SIZE]);
	this.reset(); //sets all characters to regular square, "o"
	drawScrabble();
	//this.print();
}
	
public void print() { //print board at any moment
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++) {
			System.out.print(String.valueOf(this.getScrabble()[i][j])+"  "); //display each char one by one
			if (j==this.SIZE-1) 
				System.out.println(""); //go down a line if the row is over
			else continue;}
		
}


public void reset() { 
	for (int i=0; i<this.SIZE; i++)
		for (int j=0; j<this.SIZE; j++)
			scrabble[i][j] = 0;
}


public void drawScrabble() { //invoke this method to draw a valid Scrabble board at once
this.draw_all_V(this.middle());
this.draw_X_as_VV();
this.draw_scattered_2L();
this.draw_scattered_3W();
}


private int middle() //middle of the board- single index
{ return middle(this.SIZE); }

private int middle(int size) //middle of V pattern- absolut here equals 0, it's "peak", "pointed part"
{ return size/2; }




private void draw_X_as_VV() { //part of drawing X. X, ><, as > and <. Draws from up 0 row, down to bottom row, by going left>-right<-left>-right<-left>-right<....
	int j;
	int absolut;
	for (int i=0+1; i<this.SIZE-1; i++) //Vs don't 'touch' edges of Board
	{	absolut= java.lang.Math.abs(i-this.middle(this.SIZE));
		if (absolut==0) continue; //double assigning problem at square(middle(),middle()) solved by omitting it 
	
		//left half of the X,  V-shape. Draw >
		j=this.middle(this.SIZE)- absolut;	
		scrabble[j][i] = (assign_type_V(absolut));
		
		//right half of the X, of V-shape. Draw <
		j=this.SIZE-1-j;
		scrabble[j][i] = (assign_type_V(absolut));
		
	
	}
}




public void draw_all_V (int size) {
	int j;
	int absolut;
	for (int i=(this.SIZE-size)/2+1; i<(size+this.SIZE)/2-1; i++)
		{absolut = java.lang.Math.abs(i-(this.SIZE-size)/2-this.middle(size));
		
		  j=this.middle(size)-absolut;
		  scrabble[i][j] = (assign_type_V(absolut)); //left
		  scrabble[j][i] = (assign_type_V(absolut)); //up
		
		  j=this.SIZE-1-j;
		  scrabble[i][j] = (assign_type_V(absolut)); //right
		  scrabble[j][i] = (assign_type_V(absolut)); //down
}

}

public void draw_scattered_3W () { //scattered squares "multiply word score by 3" 
	for (int i=0; i<this.SIZE; i+=this.middle())
		for (int j=0; j<this.SIZE; j+=this.middle())
				  scrabble[i][j] = (assign_type_scattered_3W(i,j));}
	
	


public void draw_scattered_2L () { //scattered squares "multiply letter score by 2" 
	int [] I = {0,this.SIZE-1}; //first [] => up and down border of Board, OR second [] => left and right border 
	int [] J = {this.middle(this.middle()),I[1]-this.middle(this.middle())}; //3 positions away from left and right borders
		for (int i: I) 
		for (int j: J)
		{scrabble[i][j] = (assign_type_scattered_2L());
		scrabble[j][i] =(assign_type_scattered_2L());}
}



private int assign_type_V(int absolut) {
	//absolut for small V-pattern: 21012 and 3 more mirrors
	//absolut for X-pattern: 654321123456 and 1 mirror //no 0, because double assigning conflict at 0

	
	if (absolut<2)
		return  2;//Type.doubleLetter;
	else if (absolut==2)
		return 3;//Type.tripleLetter;
	else //if (absolut<7)
		return 5;//Type.doubleWord;
	
}

private int assign_type_scattered_3W(int position_x, int position_y)//A = TRIPLE WORD SCORE, B= DOUBLE word SCORE
{
	if (position_x==this.middle() && position_y==this.middle())
		return 5;//Type.doubleWord;
	else
		return 25;/*Type.tripleWord;*/ }

private int assign_type_scattered_2L () 	//D= DOUBLE LETTER SCORE
{ return 2; /*Type.doubleLetter;*/ }



public int [][] getScrabble() {
	return scrabble;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	long startTime = System.nanoTime();
 Pattern pattern = new Pattern(9);
 pattern.drawScrabble();
 
 long endTime = System.nanoTime();
 long result = endTime - startTime;
 //Runtime runtime = Runtime.getRuntime();
 
 System.out.println(result);
 //////
 startTime = System.nanoTime();
 Pattern pattern2 = new Pattern(81);
 pattern2.drawScrabble();
 
  endTime = System.nanoTime();
  result = endTime - startTime;
 //Runtime runtime = Runtime.getRuntime();
 
 System.out.println(result);

 startTime = System.nanoTime();
 Pattern pattern3 = new Pattern(729);
 pattern2.drawScrabble();
 
  endTime = System.nanoTime();
  result = endTime - startTime;
 //Runtime runtime = Runtime.getRuntime();
 
 System.out.println(result);
 
 
 startTime = System.nanoTime();
 Pattern pattern4 = new Pattern(6561);
 pattern2.drawScrabble();
 
  endTime = System.nanoTime();
  result = endTime - startTime;
 //Runtime runtime = Runtime.getRuntime();
 
 System.out.println(result);
 


 
 
}
}


