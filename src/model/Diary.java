package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;  

public class Diary {
	Map<String,String[] > entries2;
	int calGoal;
	int carbGoal;
	int fatGoal;
	int proGoal;
	int waterGoal;
	
	public Diary(int calGoal, int carbGoal, int fatGoal, int proGoal, int waterGoal) throws IOException {
		
		this.calGoal = calGoal;
		this.carbGoal = carbGoal;
		this.fatGoal = fatGoal;
		this.proGoal = proGoal;
		this.waterGoal = waterGoal;
		entries2 = new TreeMap<String, String[]>();	
	}
	
	public void checkGoals(String day) {
		try {
			this.readValues();	
		 	String[] totals = entries2.get(day);
			String[] types = {"calories","carbs", "fats", "proteins", "water"};	 
		 	int goalTotals[] = {this.calGoal,this.carbGoal,this.fatGoal,this.proGoal,this.waterGoal};
			System.out.println("On " + day + " you were:");
		 	for(int i = 0; i< 5; i++) {
			 	if(Integer.parseInt(totals[i]) > goalTotals[i]) {
					 System.out.println("Above your target for " + types[i] + " | " + totals[i] + "/" +goalTotals[i] );
			 	} else if(Integer.parseInt(totals[i]) < goalTotals[i]) {
					 System.out.println("Under your target for " + types[i] + " | " + totals[i] + "/" +goalTotals[i]);
			 	}  else {
					 System.out.println("At your target for " + types[i] + " | " + totals[i] + "/" +goalTotals[i]);
			 }
		 }
		} catch(Exception e) {
			System.out.println("There is no log for that day.");
		}
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
		 
		 
		 return "calories: " + calories + "\ncarbs: " + carbs +" grams"+ "\nfats: " + fats+ " grams"
		 + "\nproteins: " + proteins +" grams"+ "\nwater: " + water + " ounces";
		 
	
		
	}
}
