
public class Zombies {
    public int row;
    public int col;
    
    public Zombies(int rows, int cols){
        this.row = rows;
        this.col = cols;
    }
    
    public boolean equals(Object o){
        Zombies z = (Zombies) o;
        if(this.row == z.row && this.col == z.col){
            return true;
        }
        else{
            return false;
        }
    }
}
