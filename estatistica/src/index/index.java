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
public class index {
    public static void main(String[] args) {
        Media m = new Media();
        /*double cenoura[] = {0, 1, 2, 3, 4, 5, 6, 7};
        double frequencia[] = {45, 52, 48, 55, 30, 10, 8, 2};*/        
        
        String elementos[] = {"[150;154[", "[154;158[", "[158;162[", "[162;166[", "[166;170[", "[170;174["};
        double[][] elementosSeparados = new double[elementos.length][2];
        String[] split;
        
        for (int i = 0; i < elementos.length; i++)
        {
            elementos[i] = elementos[i].replace("[", "");
            split = elementos[i].split(";");
            elementosSeparados[i][0] = Double.valueOf(split[0]);
            elementosSeparados[i][1] = Double.valueOf(split[1]);
        }
        double[] frequencia = {4, 9, 11, 8, 5, 3};
        //System.out.println(m.soma(frequencia, 1, 0));
        System.out.println(m.mediana(elementosSeparados, frequencia));
        
  }
}
