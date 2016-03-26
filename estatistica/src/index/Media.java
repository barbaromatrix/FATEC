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
        double soma = soma(elementos, elementos.length - 1);
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
        
        return soma/soma(frequencia, frequencia.length - 1);
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
            somaParcial = (soma(elementos[i], elementos[i].length - 1)/2) * frequencia[i];
            soma += somaParcial;
        }
        
        double media = soma / soma(frequencia, frequencia.length - 1);
        
        return media;
    }
    
    /*
    fórmula da media = limite inferior + ((((0,5 * sumFrequencia) - frequenciaAcumuladaAcima) * h)/ frequenciaDaClasse)
    */
    
    /**
     * 
     * @param f
     * @param controle
     * @return soma recursiva do vetor f
     */
    public double soma(double[] f, int controle)
    {
        if(controle == 0) return f[0];
        
        return f[controle] + soma(f, controle - 1);
    }
}