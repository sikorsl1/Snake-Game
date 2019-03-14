package snakegame;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SnakeGame extends JFrame {

    public SnakeGame(){
        initUserInterface();
    }
    
    private void initUserInterface(){
        Map Mapa = new Map();
        
        add(Mapa);
        setResizable(false);
        pack();
        
        setTitle("SnakeGame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
       EventQueue.invokeLater(()->{
       JFrame frame = new SnakeGame();
       frame.setVisible(true);
       });
    } 
}
