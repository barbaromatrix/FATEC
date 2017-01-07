package br.com.fatecpg.classes;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz 
{
    private static ArrayList<Question> questions = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    private static final String qst[] = 
    {  
       "Quanto é 1 + 1?", "Quanto é 2 + 2?", "Quanto é 3 + 3?", "Quanto é 4 + 4?", 
       "Quanto é 5 + 5?", "Quanto é 6 + 6?", "Quanto é 7 + 7?"
    };
    
    private static final String ans[] = 
    { 
        "2", "4", "6", "8", "10", "12", "14" 
    };
    private static final String alt[][] = 
    { 
        { "1", "2", "3", "4", "5" }, 
        { "2", "3", "4", "5", "6" },
        { "6", "5", "4", "3", "7" },
        { "9", "10", "2", "8", "4" },
        { "9", "10", "11", "12", "13" },
        { "7", "8", "12", "11", "10" },
        { "9", "14", "10", "11", "12" }
    };
    
    /* Construtor não funciona em static (????????) */
    
    public static void addToQuiz()
    {
        if(questions.size() < 1)
        {
            for(int i = 0; i < qst.length; i++)
            {
                Question q = new Question();

                q.setQuestion(qst[i]);
                q.setAnswer(ans[i]);
                q.setAlternatives(alt[i]);

                questions.add(q);
            }
        }
    }
    
    public static ArrayList<Question> getQuestions(){ return questions; }
    public static ArrayList<Pessoa> getPessoas(){ return pessoas; }
    
    public static void setShuffle(){ Collections.shuffle(questions); }
    
    public static double validateQuiz(String answers[])
    {        
        int iCorrects = 0;
        
        for(int i = 0; i < questions.size(); i++)
        {
            Question q = questions.get(i);
            
            if(q.getsAnswer().equals(answers[i]))
                iCorrects++;
        }
        
        double dGrade = 100 * (double) iCorrects / (double) questions.size();
        
        return dGrade;
    }
}
