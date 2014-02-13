package org.hsw.nnbl.csvparser;

import java.io.IOException;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.csvreader.CsvReader;

public class DataSetFromFilename {
	private String filename;
	public XYSeriesCollection dataset;
	
	public DataSetFromFilename(String fname) {
        try {
			filename = fname;
        	CsvReader brewpicsvfile = new CsvReader(filename,';');

//			final XYSeries datetime = new XYSeries("Date time");
	        final XYSeries beertemp = new XYSeries("Beer temp");
	        final XYSeries beersetting = new XYSeries("Beer setting");
//	        final XYSeries beerann = new XYSeries("Beer annotation");
	        final XYSeries fridgetemp = new XYSeries("Fridge temp");
	        final XYSeries fridgesetting = new XYSeries("Fridge setting");
//	        final XYSeries fridgeann = new XYSeries("Fridge annotation");
//	        final XYSeries roomtemp = new XYSeries("Room temp");
//	        final XYSeries state = new XYSeries("State");

	        int i = 1;
			
	        while (brewpicsvfile.readRecord()) {
//	        	datetime.add(i,Float.parseFloat(brewpicsvfile.get(0)));
	        	String a = brewpicsvfile.get(1);
	        	if (!a.contains("None")){
		        	beertemp.add(i,Float.parseFloat(a));	        		
	        	} else {
		        	beertemp.add(i,Float.NaN);	        							
				}
	        	
	        	String b = brewpicsvfile.get(2);
	        	if (!b.contains("None")){
	        		beersetting.add(i,Float.parseFloat(b));	        		
	        	} else {
	        		beersetting.add(i,Float.NaN);	        		

				}
	        	
//	        	beerann.add(i,Float.parseFloat(brewpicsvfile.get(3)));
	        	String c = brewpicsvfile.get(4);
	        	if (!c.contains("None")){
		        	fridgetemp.add(i,Float.parseFloat(c));
	        	} else {
		        	fridgetemp.add(i,Float.NaN);

				}
	        	
	        	String d = brewpicsvfile.get(5);
	        	if (!d.contains("None")){
		        	fridgetemp.add(i,Float.parseFloat(d));
	        	} else {
		        	fridgetemp.add(i,Float.NaN);

				}
//	        	fridgeann.add(i,Float.parseFloat(brewpicsvfile.get(6)));
//	        	roomtemp.add(i,Float.parseFloat(brewpicsvfile.get(7)));
//	        	state.add(i,Float.parseFloat(brewpicsvfile.get(8)));

				i++;
			}
			
			brewpicsvfile.close();
	        
	        dataset = new XYSeriesCollection();
//	        dataset.addSeries(datetime);
	        dataset.addSeries(beertemp);
	        dataset.addSeries(beersetting);
//	        dataset.addSeries(beerann);
	        dataset.addSeries(fridgetemp);
	        dataset.addSeries(fridgesetting);
//	        dataset.addSeries(fridgeann);
//	        dataset.addSeries(roomtemp);
//	        dataset.addSeries(state);

        } catch (NumberFormatException | IOException e) {
			System.out.println("Could not find: " + filename);
			e.printStackTrace();
		}

	}
}
