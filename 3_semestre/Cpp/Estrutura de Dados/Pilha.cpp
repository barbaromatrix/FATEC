#include<cstdlib>
#include<iostream>

using namespace std;

class Pilha{ // LIFO => Last in First out
private:
  int *VET;
  int proximaPosicaoLivre;
  int MAX;
public:
  Pilha( int quantidade)
  {
    this->MAX = quantidade;
    this->proximaPosicaoLivre = 0;
    this->VET = new int[ quantidade ];
  }
  
  void empilha( int valor )
  {
    if( this->proximaPosicaoLivre < this->MAX )
        this->VET[ proximaPosicaoLivre++ ] = valor;
  }
  
  void mostra(  )
  {
    for( int i = 0; i < this->proximaPosicaoLivre; i++ )
      cout << this->VET[ i ] << endl;
  }
  
  int desempilha(  )
  {
    if( this->proximaPosicaoLivre > 0 )
      return this->VET[ --this->proximaPosicaoLivre ];
   else
     return -1;
  }
  
};

int main()
{
  Pilha p(5);
  p.empilha(2);
  p.empilha(1);
  p.empilha(5);
  p.empilha(3);
  p.empilha(4);
  
  p.mostra();
  
  for( int i = 0; i < 5 ; i++ )
    cout << p.desempilha() << endl;
  
  return 0;
}
