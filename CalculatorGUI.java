/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author shivam
 */
public class CalculatorGUI {
    JTextField textField = new JTextField();
    JFrame frame = new JFrame ();
    JPanel panel = new JPanel ();
    JButton [] number_Button = new JButton [10];
    JButton [] operator = new JButton[4];
    JButton [] function_Button = new JButton[4];
    JButton addButton,subButton,divButton,mulButton;
    JButton decButton,eqButton,delButton,clrButton;
    
    //opNum1 is for assinging a button text a value to do the sum 
    //opsNum3 ensures that an operator is not the first input when using the calculator (ie:+6 wont wont work but 0+6 will)
    int opNum1,opNum3;
    
    //eqlB is used to implement the equalActionListener only after a number button is pressed
    //this was used to circumvent the original equalbutton problem if an equalbutton was pressed consecutively after another
    int eqlB =2;
    
    //buttonPrs is used for the logic behind doSum(), only when a second button is pressed, the calculations of the first 2 numbers are done
    //and concatinated at the new button pressed
    int buttonPrs =0;
    
    //numBP is to ensure that when reassingin operatorActionListeners it is only done once
    int numBP=2;
    
    //this is a counter implemented in both number and operator actionListeners as a check to stop error eg:(16+=)(does not have a number after+)
    int counter;
    
    
    
    public static void main(String [] args){
        CalculatorGUI g = new CalculatorGUI ();
        
    }
    public CalculatorGUI (){
        frame = new JFrame();
        frame.setSize(425, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.lightGray);
        
        panel = new JPanel (new GridLayout (4,4));
        panel.setBackground(Color.lightGray);
        panel.setBounds(50, 150, 300, 300);
        
        Font f2 = new Font ("INK_FREE", Font.BOLD, 22);
        panel.setFont(f2);
        for (int i = 0; i<10; i++){
            number_Button[i]= new JButton(String.valueOf(i));
            number_Button[i].addActionListener(new Button());
            
        
        
        }
        //operator button
        addButton = new JButton ("+");
        addButton.addActionListener(new opButton());
        operator[0] = addButton;
        
        subButton = new JButton("-");
        subButton.addActionListener(new opButton());
        operator[1] = subButton;
        
        divButton = new JButton("/");
        divButton.addActionListener(new opButton());
        operator[2] = divButton;        
        
        mulButton = new JButton ("x");
        mulButton.addActionListener(new opButton());
        operator[3] = mulButton;
        
        //functional button
        delButton = new JButton ("DELETE");
        delButton.setBounds(50, 500, 125, 50);
        delButton.addActionListener(new funcButton());
        function_Button[0] = delButton;
        
        clrButton = new JButton("CLEAL");
        clrButton.setBounds(225, 500, 125, 50);
        clrButton.addActionListener(new funcButton());
        function_Button[1]= clrButton;
        
        eqButton = new JButton("=");
        eqButton.addActionListener(new funcButton());
        function_Button[2] = eqButton;
        //need to adjust actionListener
        
        decButton = new JButton (".");
        decButton.addActionListener(new funcButton());
        function_Button[3] = decButton;
        
        panel.add(number_Button[1]);
        panel.add(number_Button[2]);
        panel.add(number_Button[3]);
        panel.add(addButton);
        panel.add(number_Button[4]);
        panel.add(number_Button[5]);
        panel.add(number_Button[6]);
        panel.add(subButton);
        panel.add(number_Button[7]);
        panel.add(number_Button[8]);
        panel.add(number_Button[9]);
        panel.add(divButton);
        panel.add(decButton);
        panel.add(number_Button[0]);
        panel.add(eqButton);
        panel.add(mulButton);
        
        
        
        textField.setFont(f2);
        textField.setEditable(false);
        textField.setBounds(50, 50, 300, 50);
        textField.setBackground(Color.WHITE);
        
        
        
        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    
    }
    //this method allows me to implements actionsListeners to operator buttons 
    //and ensure there is a operator after a number but not after another operator
    //also fixes the issue of operator only being able to be clicked once
    
    public void addButton (){
        //numBP ensures that only the first number pressed after an operator button is pressed, assigns a actionListener to the operator_Buttons 
        //and not for every subsequent number button pressed
        if (numBP <2){
            for (int i=0 ; i<4; i++){
                operator[i].addActionListener(new opButton());
            }
        }
        if (eqlB <2){
            function_Button[2].addActionListener(new funcButton());
        
        }
        
    
    }
 
    
    public class Button implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //what does numbp mean??
            //this numBP is incremented by 1 each time a button is pressed and is used in addButton as a check
            numBP++;
            eqlB ++;
            opNum3++;
            counter++;
            for (int i =0; i<10; i++){
                if (e.getSource().equals(number_Button[i])){
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                    addButton();
                    break;
                    
                    
                    
                    
                }
                
            }
            
            
            
        }
    
    
    }
    
    
    public class opButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //below variable is to help with the logic of doing sums (only after second operator button is pressed does it do a sum)
            
            if (opNum3 >0){
                numBP =0;
                buttonPrs++;
                
                for (int i = 0; i<4; i++){
                if (e.getSource().equals(operator[i])){
                    if (buttonPrs==2){
                        doSum();
                    
                    }
                    String t = operator[i].getText();
                    textField.setText(textField.getText().concat(t));
                    //the below actionlistener is for "."button
                    if (function_Button[3].getActionListeners()== null){
                        
                        function_Button[3].addActionListener(new funcButton());
                    }
                    
                    
                    if (operator[i].getText().equals("+")){
                        opNum1=1;
                    }
                    if (operator[i].getText().equals("-")){
                        opNum1=2;
                    }
                    if (operator[i].getText().equals("/")){
                        opNum1=3;
                    }
                    if (operator[i].getText().equals("x")){
                        opNum1=4;
                    }
                    //error had occured here (forloop for removing) becasue i was trying to iterate through the array and simply removing the assigned actionListener
                    //instead i iterated through each operator in the array and request a list of actionListeners which are iterated through and removed
                    //this was implemented to stop operator buttons being clicked more than once
                    for (int j=0; j<4; j++){
                        for (ActionListener al : operator[j].getActionListeners()){
                            operator[j].removeActionListener(al);
                        }
                    
                    
            
                    }

                  }
                    
                }
                counter =0;
  
            }
        }
    
    }
    
    
    public class funcButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //del button
            if (e.getSource().equals(function_Button[0])){
                int strLen = textField.getText().length();
                String t = textField.getText().substring(0, strLen-1);
                textField.setText(t);
                if (buttonPrs==1){
                    buttonPrs=0;
                }
                
            }
            //clr button
            if (e.getSource().equals(function_Button[1])){
                textField.setText("");
                opNum1=0;
                eqlB=0;
                opNum3=0;
                buttonPrs=0;
                numBP = 2;
            
            }
            //equal button
            if (e.getSource().equals(function_Button[2])){
                doSum();
                eqlB=0;
                buttonPrs =0;
                for (ActionListener al : function_Button[2].getActionListeners()){
                     function_Button[2].removeActionListener(al);
                     
                
                
                }
                   

            }
            
            
            if (e.getSource().equals(function_Button[3])){
                textField.setText(textField.getText().concat("."));
                for (ActionListener al : function_Button[3].getActionListeners()){
                    function_Button[3].removeActionListener(al);
                }
            }
            
        }
    
    }
    public void doSum(){
       if (opNum1>0 && counter>0){
           
           if (opNum1==1){
            add();
            }
            if (opNum1==2){
            minus();
            }
            if (opNum1==3){
            div();
            }
            if (opNum1==4){
            mul();
            }
           
       }
           
    
    
    }
    
    public void add (){
        String [] t = textField.getText().split("\\+");
        double eql = (Double.valueOf(t[0])+ (Double.valueOf(t[1])) );
        textField.setText(String.valueOf(eql));
        buttonPrs =1;
            
    
    }
    public void minus (){
        String [] t = textField.getText().split("\\-");
        double eqls = (Double.valueOf(t[0])-(Double.valueOf(t[1])) );
        textField.setText(String.valueOf(eqls));
        buttonPrs =1;
    
    }
    public void div (){
        String [] t = textField.getText().split("\\/");
        double eql = (Double.valueOf(t[0])/ (Double.valueOf(t[1])) );
        textField.setText(String.valueOf(eql));
        buttonPrs =1;
    
    }
    public void mul (){
    
        String [] t = textField.getText().split("x");
        Double r = (Double.valueOf(t[0]))*(Double.valueOf(t[1]));
        textField.setText(String.valueOf(r));
        buttonPrs =1;
    }
    
    
}
