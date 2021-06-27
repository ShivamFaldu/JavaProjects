/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

/**
 *
 * @author shivam
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuizCardPlayer {
   // 2:button (next card)
    private JLabel label;
    private JFrame main ;
    private ArrayList <QuizCard> cardList = new ArrayList();
    private int cardIndex ;
    private QuizCard R ;
    private Boolean isAnswer ;
    private JTextArea text;
    private JButton button;
    
    public static void main (String [] args){
        QuizCardPlayer p = new QuizCardPlayer ();
        p.go();
    }
    
    
    public void go (){
        main = new JFrame ("Card Player");
        text = new JTextArea("", 6,6);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        label = new JLabel ("Question");
        
        
        button = new JButton ("Next Card");
        button.addActionListener(null);
        button.setSize(30, 30);
        
        JPanel qNa = new JPanel();
        qNa.setLayout(new BoxLayout (qNa, BoxLayout.Y_AXIS));
        qNa.add(label);
        qNa.add(text);
        qNa.add(button);
        
        
        JMenuBar list = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem ("Load");
        load.addActionListener(new loader ());
        file.add(load);
        list.add(file);
        

        main.setJMenuBar(list);
        
        main.add(qNa);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
        main.setSize(500, 600);
        
    }
    private class buttonLister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isAnswer){
                String answer = R.getAnswer();
                text.setText(answer);
                isAnswer = false;
                button.setText("Next Card");
            }else if(cardIndex < cardList.size()){
                
                showCard();
            
            }else {
                System.out.println("you have no more cards");
                text.setText("Sorry you have no more cards");
            }
            
        }
    
    
    }
    private class loader implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser choose = new JFileChooser ();
            choose.showOpenDialog(main);
            loadCard(choose.getSelectedFile());
        }
    
    }
    private void loadCard (File file){
        try {
            BufferedReader reader = new BufferedReader (new FileReader (file));
            String line = null;
            while ((line = reader.readLine()) != null){
                makeCard(line);
            }
            
        
        reader.close();
        }catch (Exception e){
            System.out.println("couldnt find the file ");
            e.printStackTrace();
        }
        showCard();
        
    }
   
    

    private void makeCard (String card){
        String [] results = card.split("/");
        QuizCard Q = new QuizCard (results[0], results[1]);
        cardList.add(Q);
        System.out.println("Card has been made");
    
    }
    private void showCard (){
        R = (QuizCard) cardList.get(cardIndex);
        cardIndex++;
        String question = R.getQuestion();
        text.setText(question);
        isAnswer = true;
        button.setText("show me the money");
        
        
        
    }
}
