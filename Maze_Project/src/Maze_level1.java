import java.util.*;

public class Maze_level1 {

    public boolean[][] maze;
    
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
    
    public static Random generator = new Random(); 
     
    public Maze_level1(int rows, int cols)
    {
        maze = new boolean[rows][cols];
        for(int i=0; i<maze.length; i++)
            for(int j=0; j<maze[0].length; j++)
                maze[i][j] = true;
    }
    
    public void getCoinPosition(int coin_row,int coin_col){
        while(maze[coin_row][coin_col] == true){
            coin_row = generator.nextInt(21);
            coin_col = generator.nextInt(70); 
        }
    }
    public void getExit(int exit_row,int exit_col){
        while(maze[exit_row][exit_col] == true){
            exit_row = generator.nextInt(21);
            exit_col = generator.nextInt(70); 
        }
    }
    
    public void getOneCoin(int row,int col,int coin_row,int coin_col,int exit_row,int exit_col){
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(i == row && j == col){
                    System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                }
                else if(i == coin_row && j == coin_col){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }
    public void revealExit(int row,int col,int exit_row,int exit_col){
         for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(i == row && j == col){
                    System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                }
                else if(i == exit_row && j == exit_col){
                    System.out.print(ANSI_RED + "E" + ANSI_RESET);
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public void drawLevel_1_Maze(int row,int col,int coin_row1,int coin_col1,int coin_row2,int coin_col2,int exit_row,int exit_col,boolean collectedCoin1,boolean collectedCoin2 )
    {

        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(i == row && j == col){
                    if(maze[i][j] == false){
                        System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                    }
                    else{
                        System.out.println("Oh No. You Hit The Wall~~~");
                        break;
                    }  
                }
                else if(i == coin_row1 && j == coin_col1 && !collectedCoin1){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == coin_row2 && j == coin_col2 && !collectedCoin2){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == exit_row && j == exit_col && collectedCoin1 && collectedCoin2){
                    System.out.print(ANSI_RED + "E" + ANSI_RESET);
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }
    public void Up(int row,int col,int coin_row1,int coin_col1,int coin_row2,int coin_col2,int exit_row,int exit_col,boolean collectedCoin1,boolean collectedCoin2){
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if((i) == row && j == col){
                    if(maze[i][j] == false){
                        System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                    }
                    else{
                        System.out.println("Oh No. You Hit The Wall~~~");
                        break;
                    }     
                }
                else if(i == coin_row1 && j == coin_col1 && collectedCoin1 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == coin_row2 && j == coin_col2 && collectedCoin2 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET );
                }
            }
            System.out.println();
        }  
    }
    public void Down(int row,int col,int coin_row1,int coin_col1,int coin_row2,int coin_col2,int score,int exit_row,int exit_col,boolean collectedCoin1,boolean collectedCoin2){
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if((i) == row && j == col){
                    if(maze[i][j] == false){
                        System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                    }
                    else{
                        System.out.println("Oh No. You Hit The Wall~~~");
                        break;
                    }
                }
                else if(i == coin_row1 && j == coin_col1 && collectedCoin1 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == coin_row2 && j == coin_col2 && collectedCoin2 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(score >= 1){
                    if(i == exit_row && j == exit_col){
                        System.out.print(ANSI_RED + "E" + ANSI_RESET);
                    }
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET );
                }
            }
            System.out.println();
        }
    }
    
    public void Left(int row,int col,int coin_row1,int coin_col1,int coin_row2,int coin_col2,int score,int exit_row,int exit_col,boolean collectedCoin1,boolean collectedCoin2){
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(i == row && (j) == col){
                    if(maze[i][j] == false){
                        System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                    }
                    else{
                        System.out.println("Oh No. You Hit The Wall~~~");
                        break;
                    }
                }
                else if(i == coin_row1 && j == coin_col1 && collectedCoin1 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == coin_row2 && j == coin_col2 && collectedCoin2 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(score >= 1){
                    if(i == exit_row && j == exit_col){
                        System.out.print(ANSI_RED + "E" + ANSI_RESET);
                    }
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET );
                }
            }
            System.out.println();
        }  
    }
    public void Right(int row,int col,int coin_row1,int coin_col1,int coin_row2,int coin_col2,int score,int exit_row,int exit_col,boolean collectedCoin1,boolean collectedCoin2){
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(i == row && (j) == col){
                    if(maze[i][j] == false){
                        System.out.print(ANSI_BLUE + "@" + ANSI_RESET);
                    }
                    else{
                        System.out.println("Oh No. You Hit The Wall~~~");
                        break;
                    }
                }
                else if(i == coin_row1 && j == coin_col1 && collectedCoin1 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(i == coin_row2 && j == coin_col2 && collectedCoin2 == false){
                    System.out.print(ANSI_YELLOW + "C" + ANSI_RESET);
                }
                else if(score >= 1){
                    if(i == exit_row && j == exit_col){
                        System.out.print(ANSI_RED + "E" + ANSI_RESET);
                    }
                }
                else{
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_GREEN + "." + ANSI_RESET );
                }
            }
            System.out.println();
        }  
    }  
}

