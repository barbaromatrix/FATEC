/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

/**
 *
 * @author barbaromatrix
 */
public class Media {
    
    public Media(){}
    
    /**
     * 
     * @param elementos
     * @return Média simples de um conjunto de elementos
     */
    public double media(double[] elementos)
    {
        double soma = soma(elementos, elementos.length - 1, 0);
        return soma / elementos.length;
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @return Média simples de um conjunto de elementos com x frequência
     */
    public double media(double[] elementos, double[] frequencia)
    {
        double soma = 0;
        for (int i = 0; i < elementos.length; i++) {
            soma += (elementos[i] * frequencia[i]);
        }
        
        return soma/soma(frequencia, frequencia.length - 1, 0);
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @return média de x intervalos de classe de um conjunto de dados
     */
    public double media(double[][] elementos, double[] frequencia)
    {
        double soma = 0, somaParcial = 0;
        for (int i = 0; i < elementos.length; i++) {
            somaParcial = (soma(elementos[i], elementos[i].length - 1, 0)/2) * frequencia[i];
            soma += somaParcial;
        }
        
        double media = soma / soma(frequencia, frequencia.length - 1, 0);
        
        return media;
    }
        
    /**
     * 
     * @param elementos
     * @return A mediana simples de elementos sem intervalo de classe
     */
    public double mediana(double[] elementos)
    {
        return (elementos.length % 2 == 0) ? ((elementos[(elementos.length / 2) - 1] + elementos[(elementos.length/2)])/2) : elementos[elementos.length / 2];
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @return a moda de um conjunto de elementos
     */
    public double moda(double[] elementos, double[] frequencia)
    {
        double max = 0;
        int place = 0;
        for (int i = 0; i < frequencia.length; i++) 
        {
            if(frequencia[i] > max)
            {
                max = frequencia[i];
                place = i;
            }
        }
        return elementos[place];
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @return mediana de um intervalo de classe de x elementos
     */
    public double mediana(double[][] elementos, double[] frequencia)
    {  
    /*
    fórmula da mediana = limite inferior + ((((0,5 * sumFrequencia) - frequenciaAcumuladaAcima) * h)/ frequenciaDaClasse)
    */
        
        double media = media(elementos, frequencia);
        return media;
    }
    
    /**
     * 
     * @param f
     * @param controle
     * @return soma recursiva do vetor f que soma todo o vetor
     */
    public double soma(double[] f, int controle)
    {
        if(controle == 0) return f[0];
        
        return f[controle] + soma(f, controle - 1);
    }
    /**
     * 
     * @param f
     * @param controle => Elemento limite de comparação => escape da recursividade
     * @param passagem => Elemento x do vetor que é incrementado
     * @return Uma soma qualquer com limite
     */
    public double soma(double[] f, int controle, int passagem)
    {
        if (passagem == controle) return f[passagem];
        
        return soma(f, controle, passagem + 1) + f[passagem];
    }
}