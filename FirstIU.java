/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WordGenerator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class FirstIU {
    JFrame frame ;
    //make sure to remove..................................
    public static void main (String [] args){
        FirstIU t = new FirstIU();
        t.go();
        
    
    }
    
    public void go (){
        
        frame = new JFrame();
        
        
        
        JLabel title = new JLabel ("Welcome to the Random Word Generator");
        JButton button = new JButton ("Lets Begin");
        button.setFocusable(false);
        button.setSize(5, 5);
        
       
        
        
        JMenuBar bar = new JMenuBar ();
        JMenu file = new JMenu ("File");
        JMenuItem item = new JMenuItem ("Load");
        file.add(item);
        bar.add(file);
        
        frame.setJMenuBar(bar);
        
       
        
        frame.add(title, BorderLayout.NORTH);
        frame.add(button, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    
    
    }
    public class Load implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    
    }
    
    public class Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.toBack();
            
            
        }
    
    
    }
    
    
    
}
