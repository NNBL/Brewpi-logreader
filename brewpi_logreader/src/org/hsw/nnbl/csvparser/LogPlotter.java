package org.hsw.nnbl.csvparser;

import java.awt.Color;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.csvreader.CsvReader;

public class LogPlotter extends ApplicationFrame {
    private static final long serialVersionUID = 1L;
    public LogPlotter(final String title) throws IOException {

        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    private XYDataset createDataset() throws IOException {
        
        final XYSeries series1 = new XYSeries("Beer temp");
        final XYSeries series2 = new XYSeries("Fridge temp");
        final XYSeries series3 = new XYSeries("Fridge setting");

        CsvReader foobar = new CsvReader("sample.csv",';');
		
        int i = 1;
		
        while (foobar.readRecord()) {
			String beertemp = foobar.get(1);
			String fridgetemp = foobar.get(4);
			String fridgesetting = foobar.get(5);
			series1.add(i,Float.parseFloat(beertemp));
			series2.add(i,Float.parseFloat(fridgetemp));
			series3.add(i,Float.parseFloat(fridgesetting));
			i++;
		}
		
		foobar.close();
        
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
        
    }
    
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Grande mexican lager",      // chart title
            "Time [30s]",                      // x axis label
            "Degrees [C]",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        
        return chart;
        
    }

    public static void main(final String[] args) throws IOException {

        final LogPlotter demo = new LogPlotter("Brewpi fermentation log - Grande Mexican Lager");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
