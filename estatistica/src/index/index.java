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
        double cenoura[] = {1,2,3,4,5};
        Media m = new Media();
        
        System.out.println(m.media(cenoura));
        /*
        String cenoura[] = {"[160;164[", "[164;168["};
        String[][] loco = new String[cenoura.length][2];
        String[] split;
        
        for (int i = 0; i < cenoura.length; i++)
        {
            cenoura[i] = cenoura[i].replace("[", "");
            split = cenoura[i].split(";");
            loco[i][0] = split[0];
            loco[i][1] = split[1];
        }
        */
        //System.out.println(m.soma(cenoura, cenoura.length - 1));
  }
}
