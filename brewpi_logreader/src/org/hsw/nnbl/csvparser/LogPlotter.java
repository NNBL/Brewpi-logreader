package org.hsw.nnbl.csvparser;

import java.awt.Color;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


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
        String filename = "sample.csv"; 
    	DataSetFromFilename dataset = new DataSetFromFilename(filename);
        return dataset.dataset;
        
    }
    
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "sample file",      // chart title
            "Time [s]",                      // x axis label
            "Degrees [C]",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        chart.setBackgroundPaint(Color.gray);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.gray);
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
