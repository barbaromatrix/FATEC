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
        //double cenoura[] = {1};
        
        Media m = new Media();
        
        
        String cenoura[] = {"[160;164[", "[164;168["};
        double[][] loco = new double[cenoura.length][2];
        String[] split;
        
        for (int i = 0; i < cenoura.length; i++)
        {
            cenoura[i] = cenoura[i].replace("[", "");
            split = cenoura[i].split(";");
            loco[i][0] = Double.valueOf(split[0]);
            loco[i][1] = Double.valueOf(split[1]);
        }
        double[] frequencia = {1, 5};
        System.out.println(m.media(loco, frequencia));
        
  }
}
