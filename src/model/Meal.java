package model;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private int time;
	private List<Food> foodList;
	private int mealCalories;
	private int mealFats;
	private int mealCarbs;
	private int mealProtein;

	/*
	 * It's possible to not have to pass foodList as an argument, but at this stage
	 * I'm not sure
	 */

	public Meal(int time, List<Food> foodList) {
		this.time = time;
		this.foodList = foodList;
		this.mealCalories = 0;
		this.mealFats = 0;
		this.mealCarbs = 0;
		this.mealProtein = 0;
	}

	/* This method allows us to compute all the totals in one function, but */

	public ArrayList<Integer> computeTotals() {
		ArrayList<Integer> mealTotals = new ArrayList<Integer>();
		int mealCalories = 0;
		int mealFats = 0;
		int mealCarbs = 0;
		int mealProtein = 0;

		for (Food food : this.foodList) {
			mealCalories = mealCalories + food.calories;
			mealFats = mealFats + food.fats;
			mealCarbs = mealCarbs + food.carbs;
			mealProtein = mealProtein + food.protein;
		}

		mealTotals.add(0, mealCalories);
		mealTotals.add(1, mealFats);
		mealTotals.add(2, mealCarbs);
		mealTotals.add(3, mealProtein);

		return mealTotals;
	}

	public void addFood(Food food) {
		this.foodList.add(food);
	}

	public void removeFood(Food food) {
		this.foodList.remove(food);
	}
}