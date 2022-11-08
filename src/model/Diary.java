package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;  
import java.time.format.DateTimeFormatter;
import java.time.*;

public class Diary {
	Map<String,String[] > entries2;
	
	public Diary() throws IOException {
		
		entries2 = new TreeMap<String, String[]>();
		this.readValues();
	}
	private void readValues() throws IOException {
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader("diary.csv"))) {
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			String[] values = line.split(",");    // use comma as separator
			String[] totals = Arrays.copyOfRange(values, 1, 6);
			
			this.entries2.put(values[0], totals);
			}
		}  
	}
	public String getRecord(String day) {
		 String[] totals = entries2.get(day);
		 String calories = totals[0];
		 String fats = totals[1];
		 String carbs = totals[2];
		 String proteins = totals[3];
		 String water = totals[4];
		 
		 
		 return "calories: " + calories + "\ncarbs: " + carbs +" grams"+ "\nfats: " + fats+ " grams" + "\nproteins: " + proteins +" grams"+ "\nwater: " + water + " ounces";
		 

		
	}
}
