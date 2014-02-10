package org.hsw.nnbl.csvparser;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class Parser {

	public static void main(String[] args) {
		try {

			CsvReader foobar = new CsvReader("f:\\Dropbox\\Brygging\\mexicanlager.csv",';');
			//Feb 05 2014 23:49:42; 12.05 ; 11.0 ; None ; 10.13 ; 1.0 ; None ; 5 ; None
			while (foobar.readRecord()) {
				String date = foobar.get(0);
				String beertemp = foobar.get(1);
				String beersetting = foobar.get(2);
				String somenote = foobar.get(3);
				String fridgetemp = foobar.get(4);
				String fridgesetting = foobar.get(5);
				String othernote =  foobar.get(6);
				String somesetting =  foobar.get(7);
				String someothersetting =  foobar.get(8);
				System.out.println(beertemp);
			}
			
			foobar.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
