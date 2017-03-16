/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio_1_package;

/**
 *
 * @author Fatec
 */
public class TestaCarro {
    public static void main(String[] args) {
        Automovel veiculo = new Automovel("Verde", "Bugatti", 150, 360);
        
        veiculo.ligar();
        
        veiculo.acelera(30);
        
        System.out.println("A velocidade atual é de: " + veiculo.getVelocidadeAtual());
    }
}
