/*

Crie um programa principal que crie um objeto fila chamado Numeros e insira 20 números e depois separe esses números entre par e ímpar, coloque os pares em outro objeto filaPar e os ímpares em outro objeto filaImpar.
Obs. Utiliza a classe filaPont para isso.

*/

#include <cstdlib>
#include <iostream>

using namespace std;

class No{
  
  /*
  Classe responsável por criar os nós entre os elementos que compõem os nós da fila.
  
  |-----------No-------------|        |-----------No---------------|
  | NO |  dado |  proxNo |---|--------|-> NO |  dado |  proxNo |   |
  |--------------------------|        |----------------------------|
  */
  public:
    No *proxNo; // Referência para o outro endereço de memória
    int dado; // Valor armazenado;
      
    No(  )
    {
      proxNo = NULL;
    }
  
  bool ultimoNo( )
  {
    return ( proxNo == NULL );
  }
  
};

class filaPont{
  
  public:
  // Variáveis utilizadas para fazer o controle dos elementos da Fila
    No *inicio;
    No *fim;
  
    filaPont()
    {
      inicio = NULL;
      fim = NULL;
    }
  
  bool filaVazia()
  {
    return ( inicio == NULL );
  }
  
  void insere( int valor )
  {
    No *novoDado = new No(); // Permanece na memória
    
    novoDado->dado = valor; // Atribui um valor para o atributo valor dessa instância de No
    if( filaVazia() )
      inicio = novoDado; // atribui o endereço de memória para da variável novoDado para inicio
    else
      fim->proxNo = novoDado; // Armazena no atributo proxNo de No o endereço do objeto anterior
    
    fim = novoDado; // Atualiza o endereço de memória do ponteiro fim - controle.
  }
  
  
  int retira(  ) // Retira SEMPRE da primeira posição da fila
  {
    int valorRetirado = -1; // Caso a fila esteja vazia, retorna -1
    No *proximoValorDaFila = NULL;
    
    if( !filaVazia() )
    {
      valorRetirado = inicio->dado; // Pega o valor que está sendo excluído da fila
      proximoValorDaFila = inicio->proxNo; // variável auxiliar para guardar o endereço do próximo elemento
      
      delete inicio; // Deleta o conteúdo da variável inicio ( valor e endereço de memória )
      inicio = proximoValorDaFila; // Atualiza a variável inicio (contendo o endereço, o valor e o próximo endereço)
    }
    
    return valorRetirado;
  }
};

int main(int argc, char *argv[])
{
  filaPont f, filaImpar, filaPar;
  
  for( int i = 1; i <= 20; i++ )
    f.insere( i );
  
  int aux;
  for( int i = 1; i <= 20; i++ )
  {
    aux = f.retira();
    
    if( aux % 2 == 0 )
      filaPar.insere( aux );
    else
      filaImpar.insere( aux );
    
  }
   
  for( int i = 1; i <= 20; i++ )
  {
    aux = f.retira();
    
    if( aux % 2 == 0 )
      cout << filaPar.retira() << endl;
    else
      cout << filaImpar.retira() << endl;
    
  }
    
  return 0;
}
