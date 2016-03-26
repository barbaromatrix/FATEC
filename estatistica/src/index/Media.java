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
    public double media(double[] elementos) {
        double soma = soma(elementos, elementos.length - 1);
        return soma / elementos.length;
    }
    
    /**
     * 
     * @param elementos
     * @return Média simples de um conjunto de elementos com x frequência
     */
    public double media(double[] elementos, double[] frequencia){
        double soma = soma(elementos, elementos.length - 1);
        return soma/soma(frequencia, frequencia.length - 1);
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @return média de x intervalos de classe de um conjunto de dados
     */
    public double media(double[][] elementos, double[] frequencia){
        double soma = 0;
        for (int i = 0; i < elementos.length; i++) {
            soma += soma(elementos[i], elementos.length - 1);
        }
        
        double media = soma / soma(frequencia, frequencia.length - 1);
        
        return media;
    }
    
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