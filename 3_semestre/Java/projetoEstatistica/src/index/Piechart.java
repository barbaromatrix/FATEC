/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author barbaromatrix
 */
public class Piechart {

    public Piechart() {
    }
    
    
    /**
     * 
     * @param conteudo
     * @param frequencia
     * @param frequenciaTotal
     * @return Cria um conjunto de dados de amostra 
     */
    PieDataset createDataset(String[][] conteudo, double[] frequencia, double frequenciaTotal) {
	DefaultPieDataset result = new DefaultPieDataset();
        Double valor;
        for ( int i = 0; i < frequencia.length; i++ ) {
            valor = ( frequencia[i] / frequenciaTotal ) * 100;
            
            result.setValue(conteudo[i][0], valor );
        }
        
	return result;
    }
    
    /**
     * 
     * @param dataset
     * @param title
     * @return 
     */
    JFreeChart createChart(PieDataset dataset, String title) {
        // título // dados  // include legenda
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);
        
        return chart;
    }
}
