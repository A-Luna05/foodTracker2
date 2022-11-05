package model;

import java.util.Date;

public class entrySummary {
	private Date day;
	private int cals;
	private int carbs;
	private int fats;
	private int protein;
	private int water;
	
	public entrySummary(Date date, int calories, int carbohydrates, int fats, int protein,int water) {
		this.day = date;
		this.cals = calories;
		this.carbs = carbohydrates;
		this.fats = fats;
		this.protein = protein;
		this.water = water;
	}
	
	public String printSummary() {
		return "On" + this.day + "you have taken" + this.cals + "calories" + this.carbs + "carbohydrates"
	+ this.protein + "grams of protein" + this.fats + "grams of fat and" + this.water + "ounces of water";
	}
}


