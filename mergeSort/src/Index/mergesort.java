/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Index;

/**
 *
 * @author barbaromatrix
 */
public class mergesort {
    public static void merge(int[] array, int inicio, int fim) {
	if (fim <= inicio) {
		return;
	}
        
        //Divido o vetor em 2 para saber a quantidade de termos
	int meio = (inicio + fim) / 2;
        
        //I haven't undestood at all
        merge(array, inicio, meio);
	merge(array, meio + 1, fim);
        
        //Crio o primeiro vetor para comparar a primeira parte
	int[] A = new int[meio - inicio + 1];
        System.out.println("meio:" + meio);
        
        //Crio o primeiro vetor para comparar a segunda parte
	int[] B = new int[fim - meio];
        
        //Adiciono nos vetores
	for (int i = 0; i <= meio - inicio; i++) {
		A[i] = array[inicio + i];
	}
	for (int i = 0; i <= fim - meio - 1; i++) {
		B[i] = array[meio + 1 + i];
	}
        
        //Variáveis de controle
	int i = 0;
	int j = 0;
        
        //For para iteração sobre elementos
	for (int k = inicio; k <= fim; k++) {
            // Verifico se 
            if (i < A.length && j < B.length) 
            {
                //Faço a comparação do primeiro vetor com o segundo, para saber qual é maior
		if (A[i] < B[j]) {
			array[k] = A[i++];
		} else {
			array[k] = B[j++];
                }
            }
            //
            else if (i < A.length) 
            {
		array[k] = A[i++];
            } 
            else  
            { //era else if (j < B.length)
		array[k] = B[j++];
            }
        }
        System.out.print(" | ");
        for(int ar : array)
        {
            System.out.print("This: " + ar + " -- ");
        }
}
    
    public static void main(String[] args){
        int[] item = {1, 3, 2, 6, 9};
        merge(item, 0, item.length - 1);
    }
}
