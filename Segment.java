package snakegame;

public class Segment {
    public int coordinateX;
    public int coordinateY;
    
    public Segment(int x, int y){
        this.coordinateX = x;
        this.coordinateY = y;
    }
   
    public void set_coordinateX(int x){
        this.coordinateX = x;
    }
    public void set_coordinateY(int y){
        this.coordinateX = y;
    }
    
}
