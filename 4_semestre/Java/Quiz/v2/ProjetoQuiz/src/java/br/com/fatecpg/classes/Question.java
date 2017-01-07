package br.com.fatecpg.classes;

public class Question 
{
    private String sQuestion;
    private String sAnswer;
    private String[] sAlternatives;

    public Question() {
    }

    public Question(String sQuestion, String sAnswer, String[] sAlternatives) {
        this.sQuestion = sQuestion;
        this.sAnswer = sAnswer;
        this.sAlternatives = sAlternatives;
    }
    
    public String getQuestion() { 
        return sQuestion; 
    }

    public void setQuestion(String sQuestion) { 
        this.sQuestion = sQuestion; 
    }

    public String getsAnswer() { 
        return sAnswer; 
    }

    public void setAnswer(String sAnswer) { 
        this.sAnswer = sAnswer; 
    }

    public String[] getAlternatives() { 
        return sAlternatives; 
    }

    public void setAlternatives(String[] sAlternatives) { 
        this.sAlternatives = sAlternatives; 
    }
}
