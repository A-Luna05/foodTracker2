package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiaryEntry {
  	private Meal Breakfast;
	private Meal Lunch;
	private Meal Dinner;
	private Date Day;
	private Meal snack;
	public int waterQty;
	
	public Date getDay(String date) {
		return Day;
	}
	//new entry
	public DiaryEntry() {
		this.Breakfast = new Meal(0,new ArrayList<Food>());
		this.Lunch = new Meal(0,new ArrayList<Food>());
		this.Dinner = new Meal(0,new ArrayList<Food>());
		this.snack = new Meal(0,new ArrayList<Food>());
		this.Day = new java.util.Date();
	}
	

	//1 = Breakfast, 2 = Lunch, 3 = Dinner, 4 = Snack
	public void update(int meal, Food fooditem) {
		if(meal == 1){
			Breakfast.addFood(fooditem);
			}
		if(meal == 2){
			Lunch.addFood(fooditem);
			}
		if(meal == 3){
			Dinner.addFood(fooditem);
			}
		if(meal == 4){
			snack.addFood(fooditem);
			}
	}
	
	public void updateWater(int water) {
		this.waterQty += water;
	}
	
	public ArrayList<Integer> getMeal(int meal) {
		if(meal == 1){
			return Breakfast.computeTotals();
			}
		if(meal == 2){
			return Lunch.computeTotals();
			}
		if(meal == 3){
			return Dinner.computeTotals();
			}
		if(meal == 4){
			return snack.computeTotals();
			}
		//shouldn't be called
		return null;
	}
	
	public void write() throws IOException {
		File diaryFile = new File("diary.csv");
		java.io.FileWriter outfile = new FileWriter(diaryFile,true);
		List<Integer> breakfastTotals = getMeal(1);
		List<Integer> lunchTotals = getMeal(2);
		List<Integer> dinnerTotals = getMeal(3);
		List<Integer> snackTotals = getMeal(4);
		List<Integer> finalTotals = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++) {
			finalTotals.add(breakfastTotals.get(i) + lunchTotals.get(i) + dinnerTotals.get(i) + snackTotals.get(i));
		}
		System.out.print(Day + "," + finalTotals.get(0)+ ',' + finalTotals.get(1)+ ',' + finalTotals.get(2)+ ',' + finalTotals.get(3) + "\n");

		outfile.append(Day + "," + finalTotals.get(0)+ ',' + finalTotals.get(1)+ ',' + finalTotals.get(2)+ ',' + finalTotals.get(3) + "\n");
		outfile.close();
	}
	
}
