package snakegame;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public List<Segment> SnakeList;
    public int move_direction;//0-up 1-right 2-down 3-left
    
    public Snake(Segment Start){
        SnakeList = new ArrayList();
        SnakeList.add(Start);
    }
    
    public Snake(int x, int y){
        Segment Start = new Segment(x,y);
        SnakeList = new ArrayList();
        SnakeList.add(Start);
        move_direction = 0;
        
    }
    
    public void eating(Segment Apple){
        Apple.coordinateX = SnakeList.get(this.SnakeList.size()-1).coordinateX;
        Apple.coordinateY = SnakeList.get(this.SnakeList.size()-1).coordinateY;
        SnakeList.add(Apple);
    }
    
    public void change_direction(int new_direction){
        switch(new_direction){
            case 1:{//right
                move_direction = (move_direction + 1)%4;
                break;
            }
            case 0:{//left
                move_direction = (move_direction + 3)%4;
                break;
            }
            default:{
                break;
            }
        }
    }
    
    public void move(){
        //change_direction(new_direction);
        
        for(int i=SnakeList.size()-1;i>0;i--){
            SnakeList.get(i).coordinateX = SnakeList.get(i-1).coordinateX;
            SnakeList.get(i).coordinateY = SnakeList.get(i-1).coordinateY;
        }
        
        switch(move_direction){
            case 0:{
                SnakeList.get(0).coordinateY = SnakeList.get(0).coordinateY+10;
                break;
            }
            case 1:{
                SnakeList.get(0).coordinateX = SnakeList.get(0).coordinateX+10;
                break;
            }
            case 2:{
                SnakeList.get(0).coordinateY = SnakeList.get(0).coordinateY-10;
                break;
            }
            case 3:{
                SnakeList.get(0).coordinateX = SnakeList.get(0).coordinateX-10;
                break;
            }
            default:
                break;
        }
        //for(int i=1;i<SnakeList.size();i++){
            //SnakeList.get(i).coordinateX = SnakeList.get(i-1).coordinateX;
            //SnakeList.get(i).coordinateY = SnakeList.get(i-1).coordinateY;
        //}
    }
    
}
