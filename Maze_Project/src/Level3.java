import java.util.*;


public class Level3{    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String ANSI_BLUE = "\u001B[44m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    public static UnionFind<String> uf;
    public static Maze_level3 maze;
    public static  Random generator=new Random();
    public static Scanner sc = new Scanner(System.in);
    static Position[] zombiePosition;
    public static void level3(int movement)
    {
        int choice = generator.nextInt(8);
        int current_row = 0;
        int current_col = 0;
        System.out.print("Enter probability of a wall (0.0 - 1.0) >> ");
        double prob = sc.nextDouble();
        do   
        {
             maze = new Maze_level3(10,25, prob );
                zombie_set(movement);
                exit_set();
                map_set();
                uf = new UnionFind<String>();
                findRegions();
        }
        
        while(!uniqueRegion());      
           maze.drawMaze(current_row,current_col);    
           while(true){
           System.out.println("Please Enter Your Next Move (U/D/L/R):" );
                    Scanner scan = new Scanner(System.in);
                    String move_order = scan.nextLine();
                    switch(move_order){
                        case "U":
                            current_row--;
                            maze.drawMaze(current_row,current_col);
                            break;
                        case "D":
                            current_row++;
                            maze.drawMaze(current_row,current_col);
                            break;
                        case "L":
                            current_col--;
                            maze.drawMaze(current_row,current_col);
                            break;
                        case "R":
                            current_col++;
                            maze.drawMaze(current_row,current_col);
                            break;
                        default:
                            System.out.println("Please Enter Your Next Move (ALL CAPITAL LETTERS)");
                    }  
          //  moving_zombie(index,row,col,choice);
            System.out.println("\nPART I: Regions found");
            if(current_row == maze.map[0] && current_col == maze.map[1]){
            maze.drawMazeSetsInColor(uf);
            System.out.println("\n*** PART II: Regions with floodfill from top to bottom of maze. (if any here) ***");}
            if(current_row == maze.exit[0] && current_col == maze.exit[1]){
         System.out.println("Congratulations ! You finished Level 3.");
         System.exit(0);
     }
           }
        }
     
    public static boolean checkpos(int r,int c){
        if(maze.maze[r][c] == false){
            return true;// it is reachble
        }
        return false;
        
    }
    
    
    
    public static void playermove(){
            Scanner scan=new Scanner(System.in);
            String move=scan.nextLine();
            if (move== "u"){
                int newrow = maze.player[0];
                int newcol = maze.player[1];
                if (checkpos( newrow, newcol-1)){
                maze.player[0] = newrow;
                maze.player[1] = newcol-1;
            }
            }
            else if (move== "d"){
                int newrow = maze.player[0];
                int newcol = maze.player[1];
                if (checkpos( newrow, newcol+1)){
                maze.player[0] = newrow;
                maze.player[1] = newcol-1;
            }
    }
           else if (move== "l"){
                int newrow = maze.player[0];
                int newcol = maze.player[1];
                if (checkpos( newrow-1, newcol)){
                maze.player[0] = newrow;
                maze.player[1] = newcol-1;
            }
            }
   else if (move== "r"){
                int newrow = maze.player[0];
                int newcol = maze.player[1];
                if (checkpos( newrow+1, newcol)){
                maze.player[0] = newrow;
                maze.player[1] = newcol-1;
            }
    
    
    
    
   }
    }
    public static void findRegions(){
    //{
      // int r = maze.player[0] in c = maze.player[1] ==> checkpos(r,c+1) { maze.player[0]  = r and maze.player[1] = c+1 
//System.out.println("your code goes here");
        for(int i = 0;i < maze.maze.length;i++){
            for(int j = 0; j < maze.maze[0].length; j++){
                if(maze.maze[i][j] == false){
                    uf.add(i + "," + j);
                }
            }
        }
        for(int i = 0;i < maze.maze.length;i++){
            for(int j = 0; j < maze.maze[0].length; j++){
                if(maze.maze[i][j] == false){
                    int cell_id = uf.find(i + "," + j);
                    Integer cell_up_id = uf.find((i-1)+","+j);
                    if(cell_up_id != null){
                        uf.union(cell_id,cell_up_id);
                    }
                    cell_id = uf.find(i + "," + j);
                    Integer cell_left_id = uf.find(i + "," + (j-1));
                    if(cell_left_id != null){
                        uf.union(cell_id,cell_left_id);
                    }
                }
            }
}
       
    }
    
    public static boolean uniqueRegion(){
        int r = maze.map[0];
        int c = maze.map[1];
        
        int region = -1;
        for(int i = 0; i < maze.row; i++){
            for(int j= 0; j<maze.col; j++){
                if(maze.maze[0][0] == false && maze.maze[r][c] == false && maze.maze[maze.row -1][maze.col - 1] == false){
                    int id_player = uf.find(0+","+0);
                    int id_map = uf.find(r+","+c);
                    int id_exit = uf.find((maze.row-1)+","+(maze.col-1));
                    if((id_player == id_map && id_map == id_exit) && region != id_player){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void zombie_set(int count){
        for(int i = 0; i< count; i++){
        int row = generator.nextInt(maze.row); //maze.row-1
        int col= generator.nextInt(maze.col); //maze.col-1
        
        while(maze.maze[row][col] == true){
            row = generator.nextInt(maze.row);
             col= generator.nextInt(maze.col);
        }
        
        maze.maze[row][col] = false;
        maze.zombie.put(i, new Zombies(row,col));
        }
    }
    
    public static void exit_set(){
        //for(int i = 0; i< count; i++){
        int row = maze.row-1;
        int col = maze.col-1;
        
        
        maze.maze[row][col] = false;
        maze.exit[0] = row;
        maze.exit[1] = col;
        //maze.zombie.put(i, new Zombies(row,col));
        //}
    }
    
     public static void map_set(){
        //for(int i = 0; i< count; i++){
        int row = generator.nextInt(maze.row);
        int col = generator.nextInt(maze.col);
        
         while(maze.maze[row][col] == true){
            row = generator.nextInt(maze.row);
             col= generator.nextInt(maze.col);
        }
        
        maze.maze[row][col] = false;
        maze.map[0] = row;
        maze.map[1] = col;
        //maze.zombie.put(i, new Zombies(row,col));
        //}
    }
     
     public static void choice_zombie(int count){
         for(int i = 0; i < count; i++){
             int directions = generator.nextInt(8); 
             Zombies zombie = maze.zombie.get(i);
             while(moving_zombie(i,zombie.row,zombie.col,directions)){
                 directions = generator.nextInt(8);
             }
         }
     }
     
     public static boolean moving_zombie(int index, int row, int col, int choice){
         if(choice == 0){ //move up
                 int rows = row - 1;// checking th erandom direction if it is viable to got htere 
                 int cols = col;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
             }
         else if(choice == 1){ //move up
                 int rows = row + 1;
                 int cols = col;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 2){ //move up
                 int rows = row;
                 int cols = col-1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 3){ //move up
                 int rows = row;
                 int cols = col +1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 4){ //move up
                 int rows = row - 1;
                 int cols = col - 1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 5){ //move up
                 int rows = row - 1;
                 int cols = col + 1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }else if(choice == 6){ //move up
                 int rows = row + 1;
                 int cols = col - 1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 7){ //move up
                 int rows = row + 1;
                 int cols = col + 1;
                 if(maze.maze[rows][cols] == true && (maze.map[0] == row && maze.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         
         return true;
     }
}
    


