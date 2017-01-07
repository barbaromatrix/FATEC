package br.com.fatecpg.classes;

public class Pessoa 
{
    private String nome;
    private int iTestCount = 0;
    private double dLastGrade = 00;
    private double dGradeSum = 00;
    
    public double getGradeAverage(){ 
        return ( this.dGradeSum / (double) this.iTestCount); 
    }
   
    public double getLastGrade(){ 
        return this.dLastGrade; 
    }
    
    public void setLastGrade(double lastGrade){ 
        this.dLastGrade = lastGrade; 
    }
    
    public void setGradeSum(double gradeSum){ 
        this.dGradeSum = gradeSum; 
    }
    
    public double getGradeSum(){ 
        return this.dGradeSum; 
    }
    
    public int getTestCount(){ 
        return this.iTestCount; 
    }
    
    public void setTestCount(int testCount){ 
        this.iTestCount = testCount; 
    }
    
    public String getNome(){ 
        return this.nome; 
    }
    
    public void setNome(String nome){ 
        this.nome = nome; 
    }
}
