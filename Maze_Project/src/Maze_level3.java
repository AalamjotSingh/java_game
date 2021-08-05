import java.util.*;
public class Maze_level3 {
    

    Random generator=new Random();

    public boolean[][] maze;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";    
    
    public static final String BG_ANSI_BLACK = "\u001B[40m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_WHITE = "\u001B[47m";    
    
    public static final String[] colors = new String[] {    
                                                            BG_ANSI_RED,
                                                            BG_ANSI_GREEN,
                                                            BG_ANSI_YELLOW,
                                                            BG_ANSI_BLUE,
                                                            BG_ANSI_PURPLE,
                                                            BG_ANSI_CYAN } ;
    
    
    HashMap<Integer, Zombies> zombie = new HashMap<>();
    int[] player = new int[2];
    int[] exit = new int[2];
    int[] map = new int[2];
    int row;
    int col;
    // create  a 
    public Maze_level3(int rows, int cols, double prob)
    {
        row = rows;
        col = cols;
        maze = new boolean[rows][cols];
        create(prob);
    }
    
    private void create(double prob)
    {
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
          /*      if(i==0&&j==0){
                    maze
                }
                if(){
                    
                }*/
                if ( Math.random()<prob ) maze[i][j] = true;
            }
        }
    }
    
    public void drawMaze(int row,int col)
    {
        
        
        //int m = 0; int a[],int b[]
         //int r=generator.nextInt();
         {
        /*int zombie_pos_x[]=new int[4];
        int zombie_pos_y[]=new int[4];
        for(int i=0;i<4;i++){
            int zombie_row = generator.nextInt(21);
           int  zombie_col = generator.nextInt(70); 
           zombie_pos_x[i]=zombie_row;
           zombie_pos_y[i]=zombie_col;
        }*/
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++){
                if(maze[i][j] == true){
                    System.out.print(BG_ANSI_WHITE + "# " +ANSI_RESET );
                }
                else{
                    if(zombie.containsValue(new Zombies(i,j))){
                        System.out.print(BG_ANSI_PURPLE + "Z " + ANSI_RESET);
                    }
                    if(i == row && j == col){
                        if(maze[i][j] == false){
                            System.out.print(BG_ANSI_BLUE + "@" + ANSI_RESET);
                          }
                        else{
                            System.out.println("Oh No. You Hit The Wall~~~");
                            break;
                        }  
                }
                    else if(i == map[0] && j == map[1]){
                        System.out.print(BG_ANSI_YELLOW + "M " + ANSI_RESET);
                    }
                    else if(i == exit[0] && j == exit[1]){
                        System.out.print(BG_ANSI_RED + "E " + ANSI_RESET);
                    }
                    else{
                        System.out.print(BG_ANSI_WHITE + ". " + ANSI_RESET);
                    }
                }
            }
            System.out.println();
        }
    }
         
    }
    
    
    
    
    public void drawMazeSetsInColor(UnionFind uf)
    {
        String[] use_color = new String[ maze.length * maze[0].length];
        String color;
        
        int color_loop = 0;
        
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {   
                Integer in_set = uf.find(i+","+j);
                if ( in_set != null )
                {
                    color = use_color[in_set];
                    if ( color == null )
                    {
                        color = colors[ color_loop++ % colors.length ];
                        use_color[in_set] = color;
                    }
                    
                } else color = BG_ANSI_WHITE;
                
                    
                    
                System.out.printf( color + "%-3s" + ANSI_RESET, in_set==null ? "#" : in_set);
            }
            System.out.println();
        }
    }
    
 /*   public void getZombiePosition(int coin_row,int coin_col){
        //while(maze[coin_row][coin_col] == true){
        
        int zombie_pos_x[]=new int[4];
        int zombie_pos_y[]=new int[4];
        for(int i=0;i<=4;i++){
            int zombie_row = generator.nextInt(21);
           int  zombie_col = generator.nextInt(70); 
           zombie_pos_x[i]=zombie_row;
           zombie_pos_y[i]=zombie_row;
}
    }
*/
        public void draw_Zombie(int x,int y, int a[], int b[]){
           for(int i=0;i<a.length;i++){
               for(int j=0;j<b.length;j++){
               if(x==i && y==j)
               {
                   System.out.print('Z');
               }
           }
           }
           
      
        
    
  {
                            
                        }
                            
                        }
                            
                        }
               
                    
                    
                    
                    
                    

