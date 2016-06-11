#include <iostream>
using namespace std;

class Lista{ // LIFO => Last in First out
  private:
    int *VET;
    int proximaPosicaoLivre;
  public:
    Lista( int quantidade )
    {
      this->VET = new int[ quantidade ];
      this->proximaPosicaoLivre = 0;
    }
  
  /*
  * @params valor a ser adicionado
  * Insere na lista o valor
  */
    void insere( int valor )
    {
      int pos = this->proximaPosicaoLivre - 1;
      while( valor < this->VET[pos] && pos > -1) // valor < this->VET[ pos ] &&
      {
        this->VET[ pos + 1 ]  = this->VET[ pos ];
        cout << "Aqui " << pos << endl;
        pos--;
      }
      this->VET[ pos + 1 ] = valor;
      this->proximaPosicaoLivre++;
    }
  
    /*
    * Exibe o conteúdo da Lista
    */
    void mostra()
    {
      for( int i = 0; i < this->proximaPosicaoLivre; i++ )
        cout << this->VET[ i ] << endl;
    }
  
    /*
    * @param valor a ser buscado
    * @return índice caso o valor seja encontrado | -1 caso o valor não seja encontrado
    */
    int busca( int valor )
    {
      for( int i = 0; i < this->proximaPosicaoLivre; i++ )
        if( this->VET[ i ] == valor )  return i;
      
      return -1;
    }
  
  /*
  * Remove o último valor inserido - LIFO
  */
  void remove( int valor )
  {
    int pos = busca( valor );
    if( pos > -1 )
    {
      for( int i = pos + 1; i < this->proximaPosicaoLivre; i++ )
      {
        this->VET[ i - 1] = this->VET[ i ];
      }
      
      this->proximaPosicaoLivre--;
    }
  }
  
};

int main() {
  Lista l()6;
  l.insere(6);
  l.insere(5);
  l.insere(4);
  l.insere(3);
  l.insere(2);
  l.insere(1);
  
  cout << endl;
  l.mostra();
  
  return 0;
}
