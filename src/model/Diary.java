package model;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;  

public class Diary {

	private List<DiaryEntry> entries;
	
	public Diary() throws IOException {
		entries = new ArrayList<DiaryEntry>();
		this.readValues();
	}
	private void readValues() throws IOException {
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader("diary.csv"))) {
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			String[] employee = line.split(",");    // use comma as separator  
			}
		}  
	}
}
