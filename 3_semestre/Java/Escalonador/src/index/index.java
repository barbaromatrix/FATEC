package index;
import javax.swing.JOptionPane;
/**
 * @author barbaromatrix
 */
public class index {
	public static void main(String[] args) 
	{
        int iArrive[] = new int[4];
        int iTime[] = new int[4];
        int iCurTime = 0;
        int iTotalTime = 0;

        for (int i = 0; i < 4; i++) {
                // Tempo de chegada do processo
        	iArrive[i] = Integer.parseInt( JOptionPane.showInputDialog( "Digite o tempo de chegada abaixo." ) );
                
        	// Tempo de duração
        	iTime[i] = Integer.parseInt( JOptionPane.showInputDialog( "Digite o tempo de duração abaixo." ) );

        	// Acumulo o tempo para saber o tempo total de execução
        	iTotalTime += iTime[i];
        }

        int iIndex;

        while( iCurTime < iTotalTime )
        {
        	iIndex = -1;

        	for ( int i = 0; i < 4 ; i++ ) 
        	{
        		if( iTime[i] > 0 && iCurTime >= iArrive[i] )
        		{
        			if( iIndex >= 0 )
        			{
        				if( iTime[iIndex] > iTime[i] )
        				{
        					iIndex = i;
        				}else if( iTime[iIndex] == iTime[i] ){
        					if( iIndex > i )
        					{
        						i = iIndex;
        					}
        				}
        			} else{
        				iIndex = i;
        			}
        		}
        	}

        	if( iIndex >= 0 )
        	{
        		iTime[iIndex]--;

        		System.out.println( "Executando o processo: " + ( iIndex + 1 ) + "\t" + "Tempo restante: " + iTime[iIndex] );
        	}
        	else{
        		System.out.println( "Sem processo disponível, aguardando..." );
                        iTotalTime++;
        	}	
                iCurTime++;
        }
        System.out.println( "Tempo total: " + iTotalTime );
    }
}
