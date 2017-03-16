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
public class Automovel {
    String cor;
    String modelo;
    double velocidadeAtual;
    double velocidadeMaxima;

    public Automovel(String cor, String modelo, double velocidadeAtual, double velocidadeMaxima) {
        this.cor = cor;
        this.modelo = modelo;
        this.velocidadeAtual = velocidadeAtual;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
    
    /**
     * Responsável por inicializar o carro
     */
    public void ligar() {
        System.out.println("O carro está ligado");
    }
    
    /**
     * Aumenta a velocidade do carro
     * @param quantidade 
     */
    public void acelera(double quantidade) {
        this.velocidadeAtual = this.velocidadeAtual + quantidade;
    }
    
    
    public int pegaMarcha() {
        if(this.velocidadeAtual < 0) {
            return -1;
        }
        if (this.velocidadeAtual > 0 && this.velocidadeAtual <= 40) {
            return 1;
        }
        
        if (this.velocidadeAtual > 40 && this.velocidadeAtual <= 60) {
            return 2;
        }
        
        if (this.velocidadeAtual > 60 && this.velocidadeAtual <= 80) {
            return 3;
        }
        
        if (this.velocidadeAtual > 80 && this.velocidadeAtual <= 100) {
            return 4;
        }
        
        return 5;
    }
}
