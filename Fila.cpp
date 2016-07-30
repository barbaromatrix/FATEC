#include <iostream>
#include <cstdlib>

using namespace std;

class Fila { // FIFO => Primeiro elemento que entrar, é o primeiro elemento a sair
  private: 
    int *VET; // 
    int proximaPosicaoLivre;
    int MAX; //
  public:
    Fila( int quantidade )
    {
      this->MAX = quantidade;
      this->VET = new int[ quantidade ];
      this->proximaPosicaoLivre = 0;
    }
  
    /**
    *  @param Inteiro a ser adicionado
    *  Insere um elemento na Fila de elementos
    */
    void insere( int elemento )
    {
      if ( this->proximaPosicaoLivre <= this->MAX )
        this->VET[ proximaPosicaoLivre++ ] = elemento;
      else
        cout << "Não é possível inserir. Fila cheia." << endl;
    }
  
    /*
    * Exibe todos os elementos da Fila
    */
    void mostra(  )
    {
      if ( this->proximaPosicaoLivre == 0 )
        cout << "Pilha vazia.";
      else
        for( int i = 0; i < this->proximaPosicaoLivre; i++ )
          cout << this->VET[ i ] << endl;
    }
  
    /*
    * Retira um elemento da Fila
    * @return elemento retirado da fila (sucesso) | -1 (erro)
    */
    int retira(  ) // Aqui é o segredo. A Fila segue o padrão FIFO
    {
      if( this->proximaPosicaoLivre > 0 )
      {
        int valorRetirado = this->VET[ 0 ];
         for( int i = 1; i < this->proximaPosicaoLivre; i++  )
           this->VET[i - 1] = this->VET[ i ]; // Transfere para uma posição anterior todos os valores e tira o primeiro valor do vetor
        this->proximaPosicaoLivre--;
        return valorRetirado;
      }
      return -1;
    }
};

// To execute C++, please define "int main()"
int main() {
  Fila f(3);
  f.insere(1);
  cout << f.retira();
  
  return 0;
}
