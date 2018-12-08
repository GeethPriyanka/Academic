
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
        
                        /*
                        {{0,0,1,1,1},
			{1,0,1,1,0},
			{0,0,0,1,1},
			{0,0,0,0,1},
			{1,1,1,0,0}}
                        */
					
	maze = tmp;
    }
    
    public Maze(int size){
        
        Random rand = new Random();
        
        maze = new int [size][size];
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                maze[i][j] = rand.nextInt(2);
            }
        }
        maze [0][0] = 0;
        maze [size-1][size-1] = 0;
        
    }

    public void show() {
	for(int i=0; i < maze.length; i++) {
	    System.out.printf("{");
	    for(int j=0; j < maze[i].length; j++)
		System.out.printf("%d%s", maze[i][j],
		       j != maze[i].length - 1 ? ", ": " }\n");
	}
    }


    public boolean findPath(int x, int y, int X, int Y) {

    	if(x==X && y==Y){
    		return true;
    	}else{
    		maze[x][y] = 2;

    		if(y-1>=0 && maze[x][y-1]==0 && findPath(x,y-1,X,Y)){
    			return true;
    		}
    		if(y+1<=4 && maze[x][y+1]==0 && findPath(x,y+1,X,Y)){
    			return true;
    		}
    		if(x-1>=0 && maze[x-1][y]==0 && findPath(x-1,y,X,Y)){
    			return true;
    		}
    		if(x+1<=4 && maze[x+1][y]==0 && findPath(x+1,y,X,Y)){
    			return true;
    		}
    		
    		return false;
    		
    	}
	//return false;//Fix me
    }

    public void showPath(int x, int y, int X, int Y) {
        if(x==X && y==Y){
            blk = new Block(x,y,n);
            n++;
            al.add(blk);
            setPrint = true;
            return;
        }else{
            maze[x][y] = 1;
            blk = new Block(x,y,n);
            n++;
            al.add(blk);
            if(y-1>=0 && maze[x][y-1]==0){
                showPath(x,y-1,X,Y);
            }
            if(y+1<=4 && maze[x][y+1]==0){
                showPath(x,y+1,X,Y);
            }
            if(x-1>=0 && maze[x-1][y]==0){
                showPath(x-1,y,X,Y);
            }
            if(x+1<=4 && maze[x+1][y]==0){
                showPath(x+1,y,X,Y);
            } 
            if(!al.isEmpty()){
                al.remove(n-1);
                n--;
            }
            
    	}

        if(setPrint){
            
            System.out.println("Coordinates");

            for(Block blk: al){
                System.out.println(blk.getYCoordinates()+" "+blk.getXCoordinates());
            }
            System.out.println(Y+" "+X);
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
                counter++;
            }
        }
        //System.out.println("Counter is :"+counter);
        probability = (float)counter/sampleSize;
        return probability;
    }
    
    private boolean findPath2(int x, int y, int X, int Y) {
    	if(x==X && y==Y){
    		return true;
    	}else{
    		maze[x][y] = 2;

    		if(y-1>=0 && maze[x][y-1]==0 && findPath2(x,y-1,X,Y)){
    			return true;
    		}
    		if(y+1<=Y && maze[x][y+1]==0 && findPath2(x,y+1,X,Y)){
    			return true;
    		}
    		if(x-1>=0 && maze[x-1][y]==0 && findPath2(x-1,y,X,Y)){
    			return true;
    		}
    		if(x+1<=X && maze[x+1][y]==0 && findPath2(x+1,y,X,Y)){
    			return true;
    		}
    		
    		return false;
    		
    	} 
    }
    
    
    public static void main(String [] args) {
	Maze m = new Maze();
        Maze m2 = new Maze();
        float probability;
        int mazeSize=20;
        
	m.show();
	if(m.findPath(0,0, 4, 4)) {
	    System.out.println("There is a path");
	    m2.showPath(0,0,4,4);
            System.out.println();
	}
	else
	    System.out.println("There is no path");
        
        
        Maze [] mazeList = new Maze[sampleSize];
        
        for(int i=0;i<sampleSize;i++){
            mazeList[i] = new Maze(mazeSize);
        }
    	
        probability = getProbability(mazeList,mazeSize);
        
        System.out.println("Probability is :"+probability);
        
     }

    
}
