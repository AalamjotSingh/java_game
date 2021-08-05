import java.util.*;
public class Maze_level2 {

    public char[][] maze;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String ANSI_BLUE = "\u001B[44m";
    
    public static Random generator = new Random(); 
    
    public Maze_level2(int rows, int cols)
    {
        maze = new char[rows][cols];
    }
    
    public void buildMaze(int row, int col, int exit_row, int exit_col){
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                if(i == row && j == col){
                    maze[i][j] = '@';
                }
                if(i == exit_row && j == exit_col){
                    maze[i][j] = 'E';
                }
                else{
                    int num = generator.nextInt(2);
                    if(num == 0){
                        maze[i][j] = '_';
                    }
                    else{
                        maze[i][j] = ' ';
                    }
                }
            }
        }
    }
    public void draw_level2Maze(int row,int col,int exit_row,int exit_col,char target)
    {
        char a = 'A';
        System.out.println("                           ABCDEFGHIJKLMNOPQRSTUVWX");
        System.out.println(" ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX");
        
        for(int i=0; i<maze.length; i++)
        {
            System.out.print(Character.toString(a));
            for(int j=0; j<maze[0].length; j++){
                if(maze[i][j] == '@'){
                    System.out.print(BG_ANSI_GREEN + maze[i][j] + ANSI_RESET);
                }
                if(maze[i][j] == 'E'){
                    System.out.print(ANSI_BLUE + maze[i][j] + ANSI_RESET);
                }
                if(maze[i][j] == '_'){
                    System.out.print(ANSI_BLUE + maze[i][j] + ANSI_RESET);
                }
                if(maze[i][j] == ' '){
                    System.out.print(BG_ANSI_GREEN + maze[i][j] + ANSI_RESET);
                }
                if(maze[i][j] == '.'){
                    if(target == '_'){
                        System.out.print(BG_ANSI_GREEN + ' ' + ANSI_RESET);
                    }
                    if(target == ' '){
                        System.out.print(ANSI_BLUE + '_' + ANSI_RESET);
                    }
                }
  
            }
            System.out.print(Character.toString(a));
            a++;
            System.out.println();
        }
        System.out.println(" ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX");
    }
    public void getStart(int row, int col){
        while(maze[row][col] == '_'){
            row = generator.nextInt(19);
            col = generator.nextInt(50); 
        }
    }
    public void getExit(int exit_row,int exit_col){
        while(maze[exit_row][exit_col] == ' '){
            exit_row = generator.nextInt(19);
            exit_col = generator.nextInt(50); 
        }
    }

}