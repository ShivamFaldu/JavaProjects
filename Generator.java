/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WordGenerator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author shivam
 */
public class Generator {
    JTextArea word_List;
    
    JList list_Generated;
    
    JLabel generated_Word;
    
    public static void main(String [] args){
        Generator g = new Generator ();
        g.Generator();
    
    
    }
    
    public void Generator (){
        JFrame frame = new JFrame ();

        JPanel mainPanel = new JPanel ();
        mainPanel.setLayout(new BorderLayout());
        
        Font f = new Font ("SANS_SERIF", Font.ROMAN_BASELINE,45);
        JLabel title = new JLabel ("Random Word Generator", SwingConstants.CENTER);
        title.setFont(f);
        mainPanel.add(BorderLayout.NORTH, title);
        
        
        JPanel centerPanel = new JPanel ();
        centerPanel.setLayout(new GridBagLayout());
        Font f2 = new Font ("SANS_SERIF", Font.BOLD,22);
        JButton word_Generator = new JButton ("Generate");
        word_Generator.addActionListener(new WordGenerator ());
        word_Generator.setFont(f2);
        word_Generator.setFocusable(false);
        word_List = new JTextArea (10,8);
        word_List.setLineWrap(true);
        word_List.setWrapStyleWord(true);
        word_List.setFont(f2);
        
        JScrollPane scroll_Bar = new JScrollPane (word_List);
        scroll_Bar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_Bar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
//        list_Generated = new JList();
//        list_Generated.setFont(f2);
//        list_Generated.setListData(list);
//        
        generated_Word = new JLabel ();
        generated_Word.setFont(f2);
        generated_Word.setText("Your word will appear here");
        
        centerPanel.add(scroll_Bar);
        centerPanel.add(word_Generator);
        centerPanel.add(generated_Word);
        mainPanel.add(BorderLayout.CENTER, centerPanel);
        
        frame.getContentPane().add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 500);
        frame.toFront();
        
    
    }
    
    
    
    public class WordGenerator implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          if (word_List!=null){
              
              String lists = word_List.getText();
              String [] list = lists.split("\n");
              randomiseWord(list);
              
          
          }
            
           
            
           
//            for (int i=0; i<list.length; i++){
//                System.out.println(list[i]);
//            }
            
        }
        
    
    }
    public void randomiseWord (String [] wordList){
        
        int no_Words = wordList.length;
        int rand = (int) (Math.random() * no_Words);
        generated_Word.setText(wordList[rand]);
    
    }
}
