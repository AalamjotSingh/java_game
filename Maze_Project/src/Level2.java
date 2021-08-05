import java.util.*;

public class Level2 {
    public static Maze_level2 maze = new Maze_level2(19, 50);
    public static Random generator = new Random();
    public static Queue<String> q = new LinkedList<>(); 
    
 
    public static void level2(int movement) {
        int row = generator.nextInt(19);
        int col = generator.nextInt(50);
        maze.getStart(row,col);
        
        int exit_row = generator.nextInt(19);
        int exit_col = generator.nextInt(50);
        maze.getExit(exit_row, exit_col);
        maze.buildMaze(row, col, exit_row, exit_col);
        char target = ' ';
        maze.draw_level2Maze(row,col,exit_row,exit_col,target);
        

        while(true){
            System.out.println("Enter coordinates for flood fill (Ex: AC or ACC)> " );
            
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            char a = input.charAt(0);
            int a_n = (int)a - 65;
            int b_n = 0;
            
            if(input.length() == 2){
                char b = input.charAt(1);
                b_n = (int)b - 65;
            }
            if(input.length() == 3){
                char b = input.charAt(1);
                b_n = (int)b - 39;
            }
            
            int current_row = a_n;
            int current_col = b_n;

        System.out.println(current_row + "," + current_col);
        
        
        fill(current_row,current_col);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        maze.draw_level2Maze(row,col,exit_row,exit_col,target);
        movement++;
        }
  
    }
   public static void fill(int row,int col){
        String s = row + "," + col;
        char target = maze.maze[row][col];
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
        maze.maze[row][col] = '.';
        
        
        if(row != 0){
            if(maze.maze[row - 1][col] == target){
                s = (row-1) + "," + col;
                q.add(s);
            }
        }
        if(row !=18){
            if(maze.maze[row + 1][col] == target){
                s = (row+1) + "," + col;
                q.add(s);
            }
        }
        
        if(col != 18){
            if(maze.maze[row][col + 1] == target){
                s = row + "," + (col+1);
                q.add(s);
            }
        }
        if(col != 0){
            if(maze.maze[row][col - 1] == target){
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
        target = maze.maze[row][col];
        
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
        maze.maze[row][col] = '.';
        
        
        if(row != 0){
            if(maze.maze[row - 1][col] == target){
                s = (row-1) + "," + col;
                q.add(s);
            }
        }
        if(row !=18){
            if(maze.maze[row + 1][col] == target){
                s = (row+1) + "," + col;
                q.add(s);
            }
        }
        
        if(col != 18){
            if(maze.maze[row][col + 1] == target){
                s = row + "," + (col+1);
                q.add(s);
            }
        }
        if(col != 0){
            if(maze.maze[row][col - 1] == target){
                s = row + "," + (col-1);
                q.add(s);
            }
        }
        }
   }
}