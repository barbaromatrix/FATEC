#include <iostream>

using namespace std;

int main(int argc, char** argv) 
{
	int iArrive[4], iTime[4];
	int iCurTime = 0;
	int iTotalTime = 0;
	
	for(int i = 0; i < 4; i++)
	{
		cout << "Digite o tempo de duracao: ";
		cin >> iTime[i];
		cout << "Digite o tempo de chegada: ";
		cin >> iArrive[i];
		
		iTotalTime += iTime[i];
		
		cout << endl;
	}
	
	int iIndex;
	
	while(iCurTime < iTotalTime)
	{
		iIndex = -1;
		
		for(int i = 0; i < 4; i++)
		{
			if(iTime[i] > 0 && iCurTime >= iArrive[i]  )
			{
				if(iIndex >= 0)
				{
					if(iTime[iIndex] > iTime[i])
						iIndex = i;
					else if(iTime[iIndex] == iTime[i])
						if(iIndex > i)
							i = iIndex;
				}
				else
					iIndex = i;
			}
		}
		
		if(iIndex >= 0)
		{
			iTime[iIndex]--;
			
			cout << "Executando processo: " << (iIndex + 1) << " Tempo restante: " << iTime[iIndex] << endl;
		}
		else
			cout << "Sem processo disponivel, aguardando..." << endl;
		
		iCurTime++;
	}
	
	cout << "Tempo total: " << iTotalTime << endl;
	
//	system("pause");
	
	return 0;
}
