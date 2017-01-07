package br.com.fatecpg.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz 
{
    private static ArrayList<Question> questions = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    public static ArrayList<Question> questions_list = new ArrayList<>();
    
    private static ArrayList<Question> generate() {
        int n1, n2;
        Question q;
        String[] alternativas;
        
        for(int i = 0; i < 100; i++){
            n1 = (int) (Math.random() * 100);
            n2 = (int) (Math.random() * 100);
            
            // Alternativas
            alternativas = new String[4];
            alternativas[0] = String.valueOf(n1 + n2);
            alternativas[1] = String.valueOf(n1 + (int)(Math.random() * 100));
            alternativas[2] = String.valueOf((int)(Math.random() * 100) + (int)(Math.random() * 100));
            alternativas[3] = String.valueOf(n2 + (int)(Math.random() * 100));
            
            // Alternativas random
            Collections.shuffle(Arrays.asList(alternativas));
            
            q = new Question(
               "Quanto é " + n1 + "+" + n2 + "?",
               String.valueOf(n1+n2),
               alternativas
            );
            
            questions_list.add(q);
        }
        
        return questions_list;
    }
    
    public static void addToQuiz()
    {
        questions_list.clear();
        questions.clear();
        generate();
        
        Collections.shuffle(questions_list);
        
        if(questions.size() <= 0) {
            int controle[] = new int[10];
            try {
                int n1;
                while(questions.size() < 10) {
                    n1 = (int)(Math.random() * 100);
                    if(!Arrays.asList(controle).contains(n1)) {
                        questions.add(questions_list.get(n1));
                        controle[questions.size()] = n1;
                    }
                }
                Arrays.asList(controle).clear();
            } catch (IndexOutOfBoundsException e) {
                //throw new IndexOutOfBoundsException(); 
            }
        }
    }
    
    public static ArrayList<Question> getQuestions(){ 
        return questions; 
    }
    
    public static ArrayList<Pessoa> getPessoas(){ 
        return pessoas; 
    }
    
    public static void setShuffle(){ 
        Collections.shuffle(questions); 
    }
    
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
