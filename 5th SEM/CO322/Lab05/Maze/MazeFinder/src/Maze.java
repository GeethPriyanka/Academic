/*
Author: KPGP Wimalasiri
E No: E/14/403
Subject code : CO322 (Data Structures And Algorithms) 
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



class Maze {

    private int [][] maze;
    public static int n=0;
    private static final int sampleSize = 100000; 
    public boolean setPrint = false;
    Block blk;
    ArrayList<Block> al = new ArrayList<Block>();

    public Maze() {
	int [][] tmp = {{0,0,1,1,1},
			{1,0,1,1,0},
			{0,0,0,1,1},
			{0,0,0,0,1},
			{1,1,1,0,0}};
        
	maze = tmp;
    }
    
    public Maze(int size){              //overriding the Maze contructor for testing part(probability test)
        
        Random rand = new Random();
        
        maze = new int [size][size];
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                maze[i][j] = rand.nextInt(2);       //randomly generate 0 or 1 
            }
        }
        maze [0][0] = 0;                //making starting point accessible 
        maze [size-1][size-1] = 0;      //making the destination accessible
        
    }

    public void show() {                        //printing the maze
	for(int i=0; i < maze.length; i++) {
	    System.out.printf("{");
	    for(int j=0; j < maze[i].length; j++)
		System.out.printf("%d%s", maze[i][j],
		       j != maze[i].length - 1 ? ", ": " }\n");
	}
    }


    public boolean findPath(int x, int y, int X, int Y) {

    	if(x==X && y==Y){               //reached the destination
    		return true;
    	}else{
    		maze[x][y] = 2;

    		if(y-1>=0 && maze[x][y-1]==0 && findPath(x,y-1,X,Y)){       //check for upward move
    			return true;
    		}
    		if(y+1<=4 && maze[x][y+1]==0 && findPath(x,y+1,X,Y)){       //check for downward move
    			return true;
    		}
    		if(x-1>=0 && maze[x-1][y]==0 && findPath(x-1,y,X,Y)){       //check for left side move
    			return true;
    		}
    		if(x+1<=4 && maze[x+1][y]==0 && findPath(x+1,y,X,Y)){        //check for right side move 
    			return true;
    		}
    		
    		return false;
    		
    	}
	
    }

    public void showPath(int x, int y, int X, int Y) {
        if(x==X && y==Y){               // reaching the destination
            blk = new Block(x,y,n);     //creating a block with coordinate data
            n++;                        //incrementing the block number
            al.add(blk);                // adding a new block
            setPrint = true;            // coordinates can be printed as it reached the destination
            return;
        }else{
            maze[x][y] = 1;
            blk = new Block(x,y,n);         //creating a block with coordinate data
            n++;                            //incrementing the block number
            al.add(blk);                    // adding a new block
            if(y-1>=0 && maze[x][y-1]==0){      //check for upward move
                showPath(x,y-1,X,Y);
            }
            if(y+1<=4 && maze[x][y+1]==0){      //check for downward move
                showPath(x,y+1,X,Y);
            }
            if(x-1>=0 && maze[x-1][y]==0){      //check for left side move
                showPath(x-1,y,X,Y);
            }
            if(x+1<=4 && maze[x+1][y]==0){      //check for right side move 
                showPath(x+1,y,X,Y);
            } 
            if(!al.isEmpty()){
                al.remove(n-1);
                n--;
            }
            
    	}

        if(setPrint){
            
            System.out.println("---------Coordinates of the Path----------");
            System.out.println();
            for(Block blk: al){
                System.out.println(blk.getYCoordinates()+" "+blk.getXCoordinates());
            }
            System.out.println(Y+" "+X);
            System.out.println();
            System.out.println("------------------------------------------");
            setPrint = false;
        }
        
    }
    
    static float getProbability(Maze [] mazeList, int mazeSize){
        int counter=0;
        float probability;
        boolean status;
        for(int i=0;i<sampleSize;i++){
            status = mazeList[i].findPath2(0, 0, mazeSize-1, mazeSize-1);
            if(status){
                counter++;          // if there is a path counter will incerase
            }
        }
        //System.out.println("Counter is :"+counter);
        probability = (float)counter/sampleSize;        //division is explicitly casted for float
        return probability;
    }
    
    private boolean findPath2(int x, int y, int X, int Y) {         // find path 2 is for probability test
    	if(x==X && y==Y){
    		return true;            // reaching the destination
    	}else{
    		maze[x][y] = 2;

    		if(y-1>=0 && maze[x][y-1]==0 && findPath2(x,y-1,X,Y)){      //check for upward move
    			return true;
    		}
    		if(y+1<=Y && maze[x][y+1]==0 && findPath2(x,y+1,X,Y)){      //check for downward move
    			return true;
    		}
    		if(x-1>=0 && maze[x-1][y]==0 && findPath2(x-1,y,X,Y)){      //check for left side move
    			return true;
    		}
    		if(x+1<=X && maze[x+1][y]==0 && findPath2(x+1,y,X,Y)){      //check for right side move 
    			return true;
    		}
    		
    		return false;
    		
    	} 
    }
    
    
    public static void main(String [] args) {
	Maze m = new Maze();            //maze for findPath function
        Maze m2 = new Maze();           //maze for showPath function
        float probability;
        int mazeSize=20;            //one side length of square maze
        
	m.show();                   //printing the maze
        System.out.println();
	if(m.findPath(0,0, 4, 4)) {         //check whether there is a path
	    System.out.println("There is a path");
            System.out.println();
	    m2.showPath(0,0,4,4);       //showing path coordinates
            System.out.println();
	}
	else
	    System.out.println("There is no path");
        
        
        Maze [] mazeList = new Maze[sampleSize];        //creating Maze list pointers for test
        
        for(int i=0;i<sampleSize;i++){
            mazeList[i] = new Maze(mazeSize);           //creating the Maze list by overriding the maze constructor
        }
    	
        probability = getProbability(mazeList,mazeSize);        //getting the probability of having a path in mazes of maze list
        
        System.out.println("Probability of having a path on "+mazeSize+"x"+mazeSize+" maze is :"+probability);
        System.out.println("Sample size is :"+sampleSize);
        System.out.println();
        
     }

    
}
