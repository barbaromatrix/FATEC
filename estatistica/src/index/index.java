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
        double frequencia[] = {45, 52, 48, 55, 30, 10, 8, 2};
        
        System.out.println(m.media(frequencia, frequencia));*/
        
        String[] elementos = {"[2;8[", "[8;14[", "[14;20[", "[20;26[", "[26;32["};
        
        double[][] elementosSeparados = new double[elementos.length][2];
        String[] split;
        
        for (int i = 0; i < elementos.length; i++)
        {
            elementos[i] = elementos[i].replace("[", "");
            split = elementos[i].split(";");
            elementosSeparados[i][0] = Double.valueOf(split[0]);
            elementosSeparados[i][1] = Double.valueOf(split[1]);
        }
        double[] frequencia = {10,9,21,7,3};
        
        PieChart demo = new PieChart("Projeto aplicado", "Estatística");
        demo.pack();
        demo.setVisible(true);
        
  }
}
