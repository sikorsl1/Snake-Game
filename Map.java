package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Math.abs;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{
    
    private final int MAP_WIDTH = 400;
    private final int MAP_HEIGHT = 400;
    public Snake SnakeToDraw;
    private Timer timer;
    private final int DELAY = 70;
    private Random Rand;
    private int apple_coordinateX;
    private int apple_coordinateY;
    
    public Map(){
        initMap(); 
    }
    
    private void initMap(){
        apple_coordinateX=100;
        apple_coordinateY=100;
        Rand = new Random();
        addKeyListener(new Control());
        startSnake(MAP_WIDTH/2,MAP_HEIGHT/2);
        setBackground(Color.black);
        setFocusable(true);
        
        setPreferredSize(new Dimension(MAP_WIDTH, MAP_HEIGHT));
        startGame();
    }
    
    private void startGame(){
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void startSnake(int x, int y){
        SnakeToDraw = new Snake(x,y);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    
        for(int i=0;i<SnakeToDraw.SnakeList.size();i++){
            g2d.setColor(Color.white);
            g2d.fillRect(SnakeToDraw.SnakeList.get(i).coordinateX, SnakeToDraw.SnakeList.get(i).coordinateY, 10, 10);
            g2d.setColor(Color.red);
            g2d.fillOval(apple_coordinateX, apple_coordinateY, 20, 20);
        }
    }
    
    private boolean isCollision(){
        for(int i=2;i<SnakeToDraw.SnakeList.size();i++){
            if(abs(SnakeToDraw.SnakeList.get(0).coordinateX - SnakeToDraw.SnakeList.get(i).coordinateX)<10&&
               abs(SnakeToDraw.SnakeList.get(0).coordinateY - SnakeToDraw.SnakeList.get(i).coordinateY)<10){
               return false;
            }
        }
        return true;
    }
    
    private void locateApple(){
        apple_coordinateX = abs(Rand.nextInt()%(MAP_WIDTH-60)+30);
        apple_coordinateY = abs(Rand.nextInt()%(MAP_HEIGHT-60)+30);
    }
    
    private boolean isAppleEaten(){
        if(abs(SnakeToDraw.SnakeList.get(0).coordinateX - apple_coordinateX)<20&&
           abs(SnakeToDraw.SnakeList.get(0).coordinateY - apple_coordinateY)<20)
           return true;
        return false;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (SnakeToDraw.SnakeList.get(0).coordinateX>0&&
            SnakeToDraw.SnakeList.get(0).coordinateX<MAP_WIDTH-10&&
            SnakeToDraw.SnakeList.get(0).coordinateY>0&&
            SnakeToDraw.SnakeList.get(0).coordinateY<MAP_HEIGHT-10&&
            isCollision()) {
            
            if(isAppleEaten()){
                SnakeToDraw.eating(new Segment(250,250));
                locateApple();
            }
            
            SnakeToDraw.move();
        }

        repaint();
    }
    
    public class Control extends KeyAdapter{
        public Control(){
        }
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
        
            switch(key){
                case KeyEvent.VK_RIGHT:{
                    SnakeToDraw.change_direction(0);
                    break;
                }
                case KeyEvent.VK_LEFT:{
                    SnakeToDraw.change_direction(1);
                    break;
                }
                default:
                    break;
            }
        } 
    }
    
}
