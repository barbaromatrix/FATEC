/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.util.Arrays;

/**
 *
 * @author barbaromatrix
 */
public class index {
    public static void main(String[] args) {
        /*double cenoura[] = {1,2,3};
        double frequencia[] = {1, 2,3};*/
        Media m = new Media();
        
        String elementos[] = {"[98;102[", "[98;102["};
        double[][] elementosSeparados = new double[elementos.length][2];
        String[] split;
        
        for (int i = 0; i < elementos.length; i++)
        {
            elementos[i] = elementos[i].replace("[", "");
            split = elementos[i].split(";");
            elementosSeparados[i][0] = Double.valueOf(split[0]);
            elementosSeparados[i][1] = Double.valueOf(split[1]);
        }
        double[] frequencia = {10, 10};
        System.out.println(m.media(elementosSeparados, frequencia));
        
  }
}
