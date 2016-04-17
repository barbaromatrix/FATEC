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
public class Funcoes {

    public Funcoes() {
    }
    
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
     * @return 
     */
    public double moda(double[][] elementos, double[] frequencia)
    {
        int i = findClass(frequencia, 0.5);
        double moda = elementos[i][0];
        System.out.println(frequencia.length);
        if( i > 1 )
        {
            moda += ((frequencia[i] - frequencia[i - 1]) / ((frequencia[i] - frequencia[i - 1]) + (frequencia[i] - frequencia[i + 1]))) * (elementos[i][1] - elementos[i][0]);
        }else{
            moda += (frequencia[i] / ((frequencia[i]) + (frequencia[i]))) * (elementos[i][1] - elementos[i][0]);
        }
        
        return moda;
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @param valorQuartil
     * @return 
     */
    public double quartil(double[][] elementos, double[] frequencia, int valorQuartil)
    {
        double pct;
        switch(valorQuartil)
        {
            case 1:
                pct = 0.25;
                break;
            case 2:
                pct = 0.5;
                break;
            case 3:
                pct =  0.75;
                break;
            default:
                pct = 1;
                break;
        }
        
        int i = findClass(frequencia, pct);
        double quartil = elementos[i][0];
        
        if ( i > 0 ){
            quartil += ((((pct * soma(frequencia, frequencia.length - 1)) - soma(frequencia, (i - 1), 0)) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }else{
            quartil += ((((pct * soma(frequencia, frequencia.length - 1)) - 0) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }
       
        return quartil;
    }
    
    public double decil(double[][] elementos, double[] frequencia, int valorDecil)
    {
        double pct;
        switch(valorDecil)
        {
            case 1:
                pct = 0.1;
                break;
            case 2:
                pct = 0.2;
                break;
            case 3:
                pct =  0.3;
                break;
            case 4:
                pct =  0.4;
                break;
            case 5:
                pct =  0.5;
                break;
            case 6:
                pct =  0.6;
                break;
            case 7:
                pct =  0.7;
                break;
            case 8:
                pct =  0.8;
                break;
            case 9:
                pct =  0.9;
                break;
            default:
                pct = 1;
                break;
        }
        
        int i = findClass(frequencia, pct);
        
        double decil = elementos[i][0];
        
        if ( i > 0 )
        {
            decil += ((((pct * soma(frequencia, frequencia.length - 1)) - soma(frequencia, (i - 1), 0)) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }else{
            decil += ((((pct * soma(frequencia, frequencia.length - 1)) - 0) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }
       
        return decil;
    }
    
    /**
     * 
     * @param elementos
     * @param frequencia
     * @param valorPercentil
     * @return 
     */
    public double percentil(double[][] elementos, double[] frequencia, double valorPercentil)
    {
        int i = findClass(frequencia, valorPercentil);
        double percentil = elementos[i][0];
        if( i > 0 )
        {
            percentil += ((((valorPercentil * soma(frequencia, frequencia.length - 1)) - soma(frequencia, (i - 1), 0)) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }else{
            percentil += ((((valorPercentil * soma(frequencia, frequencia.length - 1)) - 0 ) * (elementos[i][1] - elementos[i][0])) / frequencia[i]);
        }
        return percentil;
    }
    
    public double desvioMedio(double[][] elementos, double[] frequencia)
    {
        // DV = Somatória de ((Xi - x) * frequencia_da_classe) / soma_de_frequencia
        double dm = 0;
        double aux;
        
        for(int i = 0; i < frequencia.length; i++)
        {
            //dm += ((soma(elementos[i], elementos[i].length - 1) / 2) - media(elementos[i], frequencia)) * frequencia[i];
            aux = ((soma(elementos[i], elementos[i].length - 1) / 2) - media(elementos, frequencia));
            
            if(aux < 0)
            {
                dm += (aux * ((-1) * frequencia[i]));
            }else{
                dm += (aux * frequencia[i]);
            }
        }
        
        dm /= soma(frequencia, frequencia.length - 1);
        return dm;
    }
    
    public double desvioPadrao(double[][] elementos, double[] frequencia)
    {
        double dp = 0;
        for(int i = 0; i < frequencia.length; i++)
        {
            dp += Math.pow( ( (soma(elementos[i], elementos[i].length - 1) / 2 ) - media(elementos, frequencia)),2) * frequencia[i];
        }
        
        dp /= soma(frequencia, frequencia.length - 1);
        dp = Math.sqrt(dp);
        return dp;
    }
    
    public double coeficienteVariacao(double desvioPadrao, double media)
    {
        return desvioPadrao / media;
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
     * @param frequencia
     * @param type
     * @return 
     */
    public int findClass(double frequencia[], double type)
    {
        int i = 0;
        boolean flag = false;
        
        while ( i < frequencia.length && flag == false ) {
            if ( ( soma( frequencia, frequencia.length - 1 ) * type ) <= ( soma( frequencia, i, 0 ) ) ) {
                flag = true;
                
            } else {
                i++;
            }
        }
        
        System.out.println(i);
        return i;
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
    
    public double[][] retornaArrayDoubleArrumado(String[] elementos)
    {
        String[] split;
        double[][] elementosSeparados = new double[elementos.length][2];
        for (int i = 0; i < elementos.length; i++)
        {
            elementos[i] = elementos[i].replace("[", "");
            split = elementos[i].split(";");
            elementosSeparados[i][0] = Double.valueOf(split[0]);
            elementosSeparados[i][1] = Double.valueOf(split[1]);
        }
        
        return elementosSeparados;
    }
    
    /**
     *
     * @param elemento
     * @return
     */
    public double[] retornaVetorDoubleArrumado(String[] elemento)
    {
        double[] elementos = new double[elemento.length];
        
        for(int i = 0; i < elementos.length; i++)
        {
            elementos[i] = Double.parseDouble(elemento[i]);
        }
        
        return elementos;
    }
}
