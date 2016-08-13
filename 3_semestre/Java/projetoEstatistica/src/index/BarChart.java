/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author barbaromatrix
 */
public class BarChart {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(6, "Profit", "Jane");
        
        
        JFreeChart chart = ChartFactory.createBarChart("Título", "Salesman", "Profit", dataset, PlotOrientation.VERTICAL, false, true, false);
        
            Grafico g = new Grafico();
            
            ChartPanel chartPanel = new ChartPanel(chart);

            // default tamanho
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

            // adiciona a nossa aplicação
            g.setContentPane(chartPanel);

            g.setVisible(true);
        
        
    }
}
