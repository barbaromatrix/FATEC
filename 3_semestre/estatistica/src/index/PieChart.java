package index;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public PieChart(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		// Isso irá criar o conjunto de dados
		PieDataset dataset = createDataset();

		// com base no conjunto de dados que criamos o gráfico
		JFreeChart chart = createChart(dataset, chartTitle);

		// vamos colocar o gráfico em um painel
		ChartPanel chartPanel = new ChartPanel(chart);

		// default tamanho
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		// adiciona a nossa aplicação
		setContentPane(chartPanel);

	}

	/**
	 * Cria um conjunto de dados de amostra 
	 */

	private PieDataset createDataset() {
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Linux", 10);
		result.setValue("Mac", 10);
		result.setValue("Windows", 51);
                result.setValue("Outros", 51);
		return result;

	}

	/**
	 * Cria um gráfico 
	 */

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, // título / gráfico 
				dataset, // dados 
				true, // include legenda
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE); 
		plot.setForegroundAlpha(0.5f);
		return chart;

	}

}