/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.util.ArrayList;

/**
 *
 * @author barbaromatrix
 */
public class index {
    public static void main(String[] args) {
        Media m = new Media();
        /*double cenoura[] = {0, 1, 2, 3, 4, 5, 6, 7};
        double frequencia[] = {45, 52, 48, 55, 30, 10, 8, 2};*/        
        
        String elementos[] = {"[180;200[", "[200;220[", "[220;240[", "[240;260[", "[260;280["};
        double[][] elementosSeparados = new double[elementos.length][2];
        String[] split;
        
        for (int i = 0; i < elementos.length; i++)
        {
            elementos[i] = elementos[i].replace("[", "");
            split = elementos[i].split(";");
            elementosSeparados[i][0] = Double.valueOf(split[0]);
            elementosSeparados[i][1] = Double.valueOf(split[1]);
        }
        double[] frequencia = {4, 18, 10, 5, 3};
        System.out.println(m.media(elementosSeparados, frequencia));
        
  }
}
