/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class Board {
    JFrame frame ;
    JTextField title ;
    JButton [] button ;
    JLabel titlE ; 
    JPanel titlePanel ;
    Boolean isIt ;
    ArrayList <JButton> buttonList;
    JPanel gridPanel;
    JPanel mainPanel;
    
    public Board () {
        button = new JButton [9];
        buttonList = new ArrayList ();
        
        frame = new JFrame ();
        
        JMenuBar bar = new JMenuBar();
        JMenu File = new JMenu ("File");
        JMenuItem newGame = new JMenuItem ("New");
        newGame.addActionListener(new NewGame ());
        File.add(newGame);
        bar.add(File);
        
        mainPanel = new JPanel ();
        mainPanel.setLayout(new BoxLayout (mainPanel, BoxLayout.Y_AXIS));
        
        GridLayout layout = new GridLayout (3,3);
        gridPanel = new JPanel (layout);
        

        
        titlE = new JLabel ();
        titlE.setFont(new Font ("SansSerif", Font.BOLD, 22));
        titlE.setText("TiC tAc ToE"); // add which players turn it is by extension to current title!!
        
        
       
        frame.setJMenuBar(bar);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        go();
        
        
        
    
   
    //this was kept seperate from the constructor to make creating a new game easier process
    private void go (){
        for (int i = 0; i <9 ; i++){
            button[i]= new JButton();
            button[i].addActionListener(new ButtonListener());
            button[i].setFont(new Font ("Verdana", Font.BOLD, 46));
            buttonList.add(button[i]);
            gridPanel.add(button[i]);
        
        }
        
        mainPanel.add(titlE);
        mainPanel.add(gridPanel);
        frame.getContentPane().add(mainPanel);
        
        choosePlayer();
    
    }
    
    public class ButtonListener implements ActionListener {

    @Override
        public void actionPerformed(ActionEvent e) {
            for (JButton c : buttonList ){
                if(e.getSource()== c && isIt){
                    c.setText("X");
                    isIt = false;
                    titlE.setText("TiC tAc ToE : O turn");
                    buttonList.remove(c);
                    break;
                    
                }else if (e.getSource()==c && isIt != true){
                    c.setText("O");
                    isIt = true;
                    titlE.setText("TiC tAc ToE : X turn");
                    buttonList.remove(c);
                  
                    break;
                }
            }
         checkGame();  
        }
       
        
    
    }
   
    
    public final void choosePlayer (){
        int rand = (int) (Math.random()*2);
        if (rand ==0){
            isIt = true;
            titlE.setText("TiC tAc ToE : X turn");
       
        }
        if (rand== 1 || rand ==2){
            isIt = false;
            titlE.setText("TiC tAc ToE : O turn");
        }
    
    }
    
    //logical check to see if a X or O has won 
    public void checkGame(){
      //horizontal X check  
      if ("X".equals(button[0].getText()) && "X".equals(button[1].getText()) && "X".equals(button[2].getText())){
          button[0].setBackground(Color.blue);
          button[1].setBackground(Color.blue);
          button[2].setBackground(Color.blue);
          xWins();
      }
      if ("X".equals(button[3].getText()) && "X".equals(button[4].getText()) && "X".equals(button[5].getText())){
          button[3].setBackground(Color.blue);
          button[4].setBackground(Color.blue);
          button[5].setBackground(Color.blue);
          xWins();
      }
      if ("X".equals(button[6].getText()) && "X".equals(button[7].getText()) && "X".equals(button[8].getText())){
          button[6].setBackground(Color.blue);
          button[7].setBackground(Color.blue);
          button[8].setBackground(Color.blue);
          xWins();
      }
      
      
      //horizontal O check
      if ("O".equals(button[0].getText()) && "O".equals(button[1].getText()) && "O".equals(button[2].getText())){
          button[0].setBackground(Color.pink);
          button[1].setBackground(Color.pink);
          button[2].setBackground(Color.pink);
          oWins();
      }
      if ("O".equals(button[3].getText()) && "O".equals(button[4].getText()) && "O".equals(button[5].getText())){
          button[3].setBackground(Color.pink);
          button[4].setBackground(Color.pink);
          button[5].setBackground(Color.pink);
          oWins();
      }
      if ("O".equals(button[6].getText()) && "O".equals(button[7].getText()) && "O".equals(button[8].getText())){
          button[6].setBackground(Color.pink);
          button[7].setBackground(Color.pink);
          button[8].setBackground(Color.pink);
          oWins();
      }
      
      
      
      
      
      
      //vertical X check
      if ("X".equals(button[0].getText()) && "X".equals(button[3].getText()) && "X".equals(button[6].getText())){
          button[0].setBackground(Color.blue);
          button[3].setBackground(Color.blue);
          button[6].setBackground(Color.blue);
          xWins();
      }
      if ("X".equals(button[1].getText()) && "X".equals(button[4].getText()) && "X".equals(button[7].getText())){
          button[1].setBackground(Color.blue);
          button[4].setBackground(Color.blue);
          button[7].setBackground(Color.blue);
          xWins();
      }
      if ("X".equals(button[2].getText()) && "X".equals(button[5].getText()) && "X".equals(button[8].getText())){
          button[2].setBackground(Color.blue);
          button[5].setBackground(Color.blue);
          button[8].setBackground(Color.blue);
          xWins();
      }
      
      
      
     // vertical O check
      if ("O".equals(button[0].getText()) && "O".equals(button[3].getText()) && "O".equals(button[6].getText())){
          button[0].setBackground(Color.pink);
          button[3].setBackground(Color.pink);
          button[6].setBackground(Color.pink);
          oWins();
      }
      if ("O".equals(button[1].getText()) && "O".equals(button[4].getText()) && "O".equals(button[7].getText())){
          button[1].setBackground(Color.pink);
          button[4].setBackground(Color.pink);
          button[7].setBackground(Color.pink);
          oWins();
      }
      if ("O".equals(button[2].getText()) && "O".equals(button[5].getText()) && "O".equals(button[8].getText())){
          button[2].setBackground(Color.pink);
          button[5].setBackground(Color.pink);
          button[8].setBackground(Color.pink);
          oWins();
      }
      
      
      //diagonal X check
      if ("X".equals(button[0].getText()) && "X".equals(button[4].getText()) && "X".equals(button[8].getText())){
          button[0].setBackground(Color.blue);
          button[4].setBackground(Color.blue);
          button[8].setBackground(Color.blue);
          xWins();
      }
      if ("X".equals(button[2].getText()) && "X".equals(button[4].getText()) && "X".equals(button[6].getText())){
          button[2].setBackground(Color.blue);
          button[5].setBackground(Color.blue);
          button[8].setBackground(Color.blue);
          xWins();
      }
      
      //diagonal O check 
      if ("O".equals(button[0].getText()) && "O".equals(button[4].getText()) && "O".equals(button[8].getText())){
          button[0].setBackground(Color.blue);
          button[4].setBackground(Color.blue);
          button[8].setBackground(Color.blue);
          oWins();
      }
      if ("O".equals(button[2].getText()) && "O".equals(button[4].getText()) && "O".equals(button[6].getText())){
          button[2].setBackground(Color.blue);
          button[4].setBackground(Color.blue);
          button[6].setBackground(Color.blue);
          oWins();
      }
      
      
      
//      for (int i = 0; i <3 ; i++){
//          int p = i*3;
//          if ("X".equals(button[p]) && "X".equals(button[(p+1)]) && "X".equals(button[(p+2)])){
//              button[p].setBackground(Color.blue);
//              button[p+1].setBackground(Color.blue);
//              button[p+2].setBackground(Color.blue);
//      
//            }
//    
//         }
    }  
    
    
    public void xWins (){
        titlE.setText("X HAS WON TRY AGAIN");
        for (JButton b : buttonList){
            //so that no other buttons can be used after someone has won
            b.setEnabled(false);
            
        }
    }
    
    
    
    public void oWins (){
        titlE.setText("O HAS WON TRY AGAIN");
        for (JButton b : buttonList){
            //so that no other buttons can be used after someone has won
            b.setEnabled(false);
            
        }
    
    }
    
    

    public class NewGame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i=0; i<9 ; i++){
                gridPanel.remove(button[i]);
            }
            go();
      
        }
    
    
    }
    //this is a test
}
