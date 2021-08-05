


import java.util.*;
public class Maze_Project_Driver {

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
    
    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();
    public static int directionsNum = 4;                  
    public static Stack<FromTo> positions = new Stack();   
    public static ArrayList<Integer> directions = new ArrayList<>(); 
    public static Queue<String> q = new LinkedList<>(); 
    
    public static Maze_level1 maze = new Maze_level1(21, 70); 
    
    public static Maze_level2 maze2 = new Maze_level2(19, 50);
    
    public static UnionFind<String> uf;
    public static Maze_level3 maze3;
    public static  Random generator=new Random();
    public static Scanner sc = new Scanner(System.in);
    public static Position[] zombiePosition;

    public static void main(String[] args) {
        int movement = 1;
        System.out.println("*********************************************");
        System.out.println("*          COMP 2230 DATA STRUCTURES        *");
        System.out.println("*             FINAL PROJECT                 *");
        System.out.println("*********************************************");
        while(true){
        System.out.println("Which level do you want to start at? (1-4):");
        String level = scan.nextLine();
        switch(level){
            //level 1
            case "1":
                int current_row = rand.nextInt(21);  
                int current_col = rand.nextInt(70);
                String current_pos =current_row+","+current_col;   

                evaluateEnvironment(current_pos); 
                int coin_row1 = rand.nextInt(21);  
                int coin_col1 = rand.nextInt(70);
                maze.getCoinPosition(coin_row1,coin_col1);
     
                int coin_row2 = rand.nextInt(21);  
                int coin_col2 = rand.nextInt(70);
                maze.getCoinPosition(coin_row2,coin_col2);
     
                int exit_row = rand.nextInt(21);
                int exit_col = rand.nextInt(70);
                maze.getExit(exit_row,exit_col);
     
                boolean collectedCoin1 = false;
                boolean collectedCoin2 = false;
     
                maze.drawLevel_1_Maze(current_row,current_col,coin_row1,coin_col1,coin_row2,coin_col2,exit_row,exit_col,collectedCoin1,collectedCoin2);
     
                int score = 0;

                while(true){
                    System.out.println();
                    System.out.println("Please Enter Your Next Move (U/D/L/R):" );
                    Scanner scan = new Scanner(System.in);
                    String move_order = scan.nextLine();
                    switch(move_order){
                        case "U":
                            current_row--;
                            if(current_row == coin_row1 && current_col == coin_col1 && !collectedCoin1){
                                score++;
                                collectedCoin1 = true;
                            }
                            else if(current_row == coin_row2 && current_col == coin_col2 && !collectedCoin2){
                                score++;
                                collectedCoin2 = true;
                            }
                            maze.drawLevel_1_Maze(current_row,current_col,coin_row1,coin_col1,coin_row2,coin_col2,exit_row,exit_col, collectedCoin1, collectedCoin2);
                            break;
                        case "D":
                            current_row++;
                            if(current_row == coin_row1 && current_col == coin_col1 && !collectedCoin1){
                            score++;
                            collectedCoin1 = true;
                            }
                            else if(current_row == coin_row2 && current_col == coin_col2 && !collectedCoin2){
                                score++;
                                collectedCoin2 = true;
                            }
                            maze.drawLevel_1_Maze(current_row,current_col,coin_row1,coin_col1,coin_row2,coin_col2,exit_row,exit_col, collectedCoin1, collectedCoin2);
                            break;
                        case "L":
                            current_col--;
                            if(current_row == coin_row1 && current_col == coin_col1 && !collectedCoin1){
                                score++;
                                collectedCoin1 = true;
                            }
                            else if(current_row == coin_row2 && current_col == coin_col2 && !collectedCoin2){
                                score++;
                                collectedCoin2 = true;
                            }
                            maze.drawLevel_1_Maze(current_row,current_col,coin_row1,coin_col1,coin_row2,coin_col2,exit_row,exit_col, collectedCoin1, collectedCoin2);
                            break;
                        case "R":
                            current_col++;
                            if(current_row == coin_row1 && current_col == coin_col1 && !collectedCoin1){
                                score++;
                                collectedCoin1 = true;
                            }
                            else if(current_row == coin_row2 && current_col == coin_col2 && !collectedCoin2){
                                score++;
                                collectedCoin2 = true;
                            }
                            maze.drawLevel_1_Maze(current_row,current_col,coin_row1,coin_col1,coin_row2,coin_col2,exit_row,exit_col, collectedCoin1, collectedCoin2);
                            break;
                        default:
                            System.out.println("Please Enter Your Next Move (ALL CAPITAL LETTERS)");
                    }  
                    if(current_row == exit_row && current_col == exit_col && score == 2){
                    System.out.println("Congratulations ! You finished Level 1.");
                    break;
                    }
                }
                
                
            // level 2    
            case "2":
                Level2.level2(movement);

            //level 3
            case "3":
               Level3.level3(movement);
               break;
                
            // level 4    
            case "4":
                kruskalMaze k = new kruskalMaze();
                k.createMaze();

                for (int i = 0; i < 10; ++i) {
                    k.placeStuff(i, "Coins");
                }
                for (int i = 0; i < 2; ++i) {
                    k.placeStuff(i, "Zombies");
                }
                k.placePlayer();
                k.makeExit();
                System.out.println("Ready to play!\n");
                k.play();
                break;
            default:
                System.out.println("Invalid input, system closed.");
                break;
        }
    }
    } 
    
    
    
    
    
 // Level 1 methods  
public static void randomizePos(ArrayList<Integer> list){  
     for (int i =0; i<directionsNum; i++){
        list.add(i);
     }
     Collections.shuffle(list); 
}

public static void evaluateEnvironment(String currentPos){ 
    String[] current = currentPos.split(",");  

    String currentRow = current[0];     
    int current_row = Integer.parseInt(currentRow);

    String currentCol = current[1];       
    int current_col = Integer.parseInt(currentCol);

    randomizePos(directions);
    for (int i =0; i<directionsNum;i++){  
        int direction = directions.remove(0);  
        if(direction == 0){    
            try{
                int to_row = current_row-2; 
                int to_col = current_col;
                if(maze.maze[to_row][to_col]==true){       
                    FromTo record = new FromTo(current_row,current_col,to_row,to_col);
                    positions.push(record);
                }
            } catch (ArrayIndexOutOfBoundsException e){}
        }
        else if (direction == 1){ 
            try{
                int to_row = current_row;
                int to_col = current_col+2;
                if(maze.maze[to_row][to_col]==true){               
                    FromTo record = new FromTo(current_row,current_col,to_row,to_col);
                    positions.push(record);
                }
            } catch (ArrayIndexOutOfBoundsException e){}
        }
        else if (direction == 2){  
            try{
                int to_row = current_row;
                int to_col = current_col-2;    
                if(maze.maze[to_row][to_col]==true){         
                    FromTo record = new FromTo(current_row,current_col,to_row,to_col);
                    positions.push(record); 
                }
            } catch (ArrayIndexOutOfBoundsException e){}
        }
        else{                              
            try{
                    int to_row = current_row+2;
                    int to_col = current_col;
                if(maze.maze[to_row][to_col]==true){              
                    FromTo record = new FromTo(current_row,current_col,to_row,to_col);
                    positions.push(record); 
                }
            } catch (ArrayIndexOutOfBoundsException e){}
        }
    }  
    drawLine();
 }

public static void drawLine(){  
     FromTo record = positions.pop();  
     int from_row = record.from_row;
     int from_col = record.from_col;
     int to_row = record.to_row;
     int to_col = record.to_col;
     if(maze.maze[to_row][to_col] == true || positions.isEmpty()){ 
        if(from_col == to_col){ 
            int  row_difference = from_row - to_row;
            if(row_difference<0){  
                maze.maze[from_row][from_col] = false;
                maze.maze[from_row+1][from_col] = false;
                maze.maze[to_row][to_col] = false;

                String current = to_row+","+to_col;
                if(!positions.isEmpty()){ 
                    evaluateEnvironment(current);
                }
            }
            else if(row_difference>0){ 
                maze.maze[from_row][from_col] = false;
                maze.maze[from_row-1][from_col] = false; 
                maze.maze[to_row][to_col] = false;
                String current = to_row+","+to_col;
                if(!positions.isEmpty()){ 
                    evaluateEnvironment(current);
                }
            }          
        }
        else if(from_row == to_row){   
            int col_difference = from_col - to_col;
            if (col_difference<0){   
                maze.maze[from_row][from_col] = false;
                maze.maze[from_row][from_col+1] = false; 
                maze.maze[to_row][to_col] = false;
                String current = to_row+","+to_col;
                if(!positions.isEmpty()){
                    evaluateEnvironment(current);
                }
            }
            else if(col_difference>0){   
                maze.maze[from_row][from_col] = false;
                maze.maze[from_row][from_col-1] = false;
                maze.maze[to_row][to_col] = false;
                String current = to_row+","+to_col;
                if(!positions.isEmpty()){
                    evaluateEnvironment(current);
                }
            }        
        }
     }
     else{ 
         drawLine(); 
     }
 }

// Level 2 methods

public static void fill(int row,int col){
        String s = row + "," + col;
        char target = maze2.maze[row][col];
        char boundary;
        if(target == '_'){
            boundary = ' ';
        }
        if(target == ' '){
            boundary = '_';
        }
        if(target == '@'){
            boundary = '_';
        }
        if(target == 'E'){
            boundary = ' ';
        }
        maze2.maze[row][col] = '.';
        
        
        if(row != 0){
            if(maze2.maze[row - 1][col] == target){
                s = (row-1) + "," + col;
                q.add(s);
            }
        }
        if(row !=18){
            if(maze2.maze[row + 1][col] == target){
                s = (row+1) + "," + col;
                q.add(s);
            }
        }
        
        if(col != 18){
            if(maze2.maze[row][col + 1] == target){
                s = row + "," + (col+1);
                q.add(s);
            }
        }
        if(col != 0){
            if(maze2.maze[row][col - 1] == target){
                s = row + "," + (col-1);
                q.add(s);
            }
        }
        while (!q.isEmpty()){
            String str = q.remove();
            String[] current = str.split(",");
            String currentRow = current[0];
            row = Integer.parseInt(currentRow);
            String currentCol = current[1];
            col = Integer.parseInt(currentCol);
        
            
            s = row + "," + col;
        target = maze2.maze[row][col];
        
        if(target == '_'){
            boundary = ' ';
        }
        if(target == ' '){
            boundary = '_';
        }
        if(target == '@'){
            boundary = '_';
        }
        if(target == 'E'){
            boundary = ' ';
        }
        maze2.maze[row][col] = '.';
        
        
        if(row != 0){
            if(maze2.maze[row - 1][col] == target){
                s = (row-1) + "," + col;
                q.add(s);
            }
        }
        if(row !=18){
            if(maze2.maze[row + 1][col] == target){
                s = (row+1) + "," + col;
                q.add(s);
            }
        }
        
        if(col != 18){
            if(maze2.maze[row][col + 1] == target){
                s = row + "," + (col+1);
                q.add(s);
            }
        }
        if(col != 0){
            if(maze2.maze[row][col - 1] == target){
                s = row + "," + (col-1);
                q.add(s);
            }
        }
        }
   }

// level 3 methods
 public static boolean checkpos(int r,int c){
        if(maze3.maze[r][c] == false){
            return true;// it is reachble
        }
        return false;
        
    }
    
    
    
    public static void playermove(){
            Scanner scan=new Scanner(System.in);
            String move=scan.nextLine();
            if (move== "u"){
                int newrow = maze3.player[0];
                int newcol = maze3.player[1];
                if (checkpos( newrow, newcol-1)){
                maze3.player[0] = newrow;
                maze3.player[1] = newcol-1;
            }
            }
            else if (move== "d"){
                int newrow = maze3.player[0];
                int newcol = maze3.player[1];
                if (checkpos( newrow, newcol+1)){
                maze3.player[0] = newrow;
                maze3.player[1] = newcol-1;
            }
    }
           else if (move== "l"){
                int newrow = maze3.player[0];
                int newcol = maze3.player[1];
                if (checkpos( newrow-1, newcol)){
                maze3.player[0] = newrow;
                maze3.player[1] = newcol-1;
            }
            }
   else if (move== "r"){
                int newrow = maze3.player[0];
                int newcol = maze3.player[1];
                if (checkpos( newrow+1, newcol)){
                maze3.player[0] = newrow;
                maze3.player[1] = newcol-1;
            }
    
    
    
    
   }
    }
    public static void findRegions(){
    //{
      // int r = maze.player[0] in c = maze.player[1] ==> checkpos(r,c+1) { maze.player[0]  = r and maze.player[1] = c+1 
//System.out.println("your code goes here");
        for(int i = 0;i < maze3.maze.length;i++){
            for(int j = 0; j < maze3.maze[0].length; j++){
                if(maze3.maze[i][j] == false){
                    uf.add(i + "," + j);
                }
            }
        }
        for(int i = 0;i < maze3.maze.length;i++){
            for(int j = 0; j < maze3.maze[0].length; j++){
                if(maze3.maze[i][j] == false){
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
        int r = maze3.map[0];
        int c = maze3.map[1];
        
        int region = -1;
        for(int i = 0; i < maze3.row; i++){
            for(int j= 0; j<maze3.col; j++){
                if(maze3.maze[0][0] == false && maze3.maze[r][c] == false && maze3.maze[maze3.row -1][maze3.col - 1] == false){
                    int id_player = uf.find(0+","+0);
                    int id_map = uf.find(r+","+c);
                    int id_exit = uf.find((maze3.row-1)+","+(maze3.col-1));
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
        int row = generator.nextInt(maze3.row); //maze.row-1
        int col= generator.nextInt(maze3.col); //maze.col-1
        
        while(maze3.maze[row][col] == true){
            row = generator.nextInt(maze3.row);
             col= generator.nextInt(maze3.col);
        }
        
        maze3.maze[row][col] = false;
        maze3.zombie.put(i, new Zombies(row,col));
        }
    }
    
    public static void exit_set(){
        //for(int i = 0; i< count; i++){
        int row = maze3.row-1;
        int col = maze3.col-1;
        
        
        maze3.maze[row][col] = false;
        maze3.exit[0] = row;
        maze3.exit[1] = col;
        //maze.zombie.put(i, new Zombies(row,col));
        //}
    }
    
     public static void map_set(){
        //for(int i = 0; i< count; i++){
        int row = generator.nextInt(maze3.row);
        int col = generator.nextInt(maze3.col);
        
         while(maze.maze[row][col] == true){
            row = generator.nextInt(maze3.row);
             col= generator.nextInt(maze3.col);
        }
        
        maze3.maze[row][col] = false;
        maze3.map[0] = row;
        maze3.map[1] = col;
        //maze.zombie.put(i, new Zombies(row,col));
        //}
    }
     
     public static void choice_zombie(int count){
         for(int i = 0; i < count; i++){
             int directions = generator.nextInt(8); 
             Zombies zombie = maze3.zombie.get(i);
             while(moving_zombie(i,zombie.row,zombie.col,directions)){
                 directions = generator.nextInt(8);
             }
         }
     }
     
     public static boolean moving_zombie(int index, int row, int col, int choice){
         if(choice == 0){ //move up
                 int rows = row - 1;// checking th erandom direction if it is viable to got htere 
                 int cols = col;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
             }
         else if(choice == 1){ //move up
                 int rows = row + 1;
                 int cols = col;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 2){ //move up
                 int rows = row;
                 int cols = col-1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 3){ //move up
                 int rows = row;
                 int cols = col +1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 4){ //move up
                 int rows = row - 1;
                 int cols = col - 1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 5){ //move up
                 int rows = row - 1;
                 int cols = col + 1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }else if(choice == 6){ //move up
                 int rows = row + 1;
                 int cols = col - 1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         else if(choice == 7){ //move up
                 int rows = row + 1;
                 int cols = col + 1;
                 if(maze3.maze[rows][cols] == true && (maze3.map[0] == row && maze3.map[1] == cols)){
                     return true;
                 }
                 else{
                     maze3.zombie.replace(index, new Zombies(rows,cols));
                     return false;
                 }
         }
         
         return true;
     }
    
}
