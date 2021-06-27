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
import java.io.IOException;
import java.util.ArrayList;





public class quizCardBuilder {
    private ArrayList <QuizCard> cardList = new ArrayList () ;
    private JTextArea questionArea;
    private JTextArea answerArea;
    private JFrame mainFrame;
    int cardNo ;
    JButton button ;
    JButton button2;
    JPanel main;
    public static void main (String [] args){
        quizCardBuilder test = new quizCardBuilder ();
        test.go();
    }
    
    public void go (){
        mainFrame = new JFrame ("Quiz builder");
        
     
        
     
        questionArea = new JTextArea ("",6,6);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
 
        JLabel Q = new JLabel ("Question");
     
        
     
        JLabel A = new JLabel ("Answer");     
        answerArea = new JTextArea("",6,6);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);
     
        
        button = new JButton ("Next Card");
        button.addActionListener(new NextCard ());
        
        JMenuBar mainMenu = new JMenuBar ();
        JMenu file = new JMenu("file");
        JMenuItem newItem = new JMenuItem ("NEW");
        newItem.addActionListener(new NewCard ());
        JMenuItem saveItem = new JMenuItem ("SAVE");
        saveItem.addActionListener(new SaveCard());
        file.add(newItem);
        file.add(saveItem);
        mainMenu.add(file);
        
        
        main = new JPanel ();
        main.setLayout(new BoxLayout (main, BoxLayout.Y_AXIS));
        main.add(Q);
        main.add(questionArea);
        main.add(A);
        main.add(answerArea);
        main.add(button);
        mainFrame.getContentPane().add(main);
        
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        
        
        
        
    }
    public void clearCards (){
        questionArea.setText("");
        answerArea.setText("");
    }
    public void endBuilder(){
        button.addActionListener(new EndBuilder());
        
    }
    
    public class EndBuilder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            QuizCardPlayer play = new QuizCardPlayer ();
            play.go();
            mainFrame.setVisible(false);
        }
    
    }
    
    private class NextCard implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e){
            QuizCard card = new QuizCard (questionArea.getText(), answerArea.getText());
            cardList.add(card);
            clearCards();
            cardNo ++;
            if (cardNo == 1){
                endBuilder();
            }
            
        
        }
    
    }
    class SaveCard implements ActionListener {
      
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileSave = new JFileChooser ();
            fileSave.showOpenDialog(mainFrame);
            saveCard(fileSave.getSelectedFile());
            
            
        }
    }
    class NewCard implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           cardList.clear();
           clearCards();
        }
    
    }
    public void saveCard (File file){
        try {
            FileWriter fileR = new FileWriter ("Cards.TXT");
            BufferedWriter writer = new BufferedWriter(fileR);
            for (QuizCard A : cardList){
                writer.write(A.getQuestion() + ("/"));
                writer.write(A.getAnswer()+ ("\n"));
                    
            }
            writer.close();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    
    }
    
    
}
