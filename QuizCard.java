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

public class QuizCard {
    String question;
    String answer;
    
    
    public QuizCard (String Q, String A) {
        question = Q;
        answer = A;

    }
    
    public String getQuestion (){
        return question;
    }
    
    public String getAnswer (){
        return answer; 
    }
}
