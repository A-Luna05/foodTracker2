package model;

import java.util.Scanner;

public class Food {

	public String name;
	public int calories;
	public int carbs;
	public int fats;
	public int protein;

	/*
	 * basic constructor, worth considering chaining a second constructor to make
	 * brand an optional variable
	 */

	public Food(String name, int calories, int carbs, int fats, int protein) {
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.fats = fats;
		this.protein = protein;
	}

	private void updateName(Food food, String updatedName) {
		food.name = updatedName;
	}

	private void updateCalories(Food food, int updatedCalories) {
		food.calories = updatedCalories;
	}

	private void updateCarbs(Food food, int updatedCarbs) {
		food.carbs = updatedCarbs;
	}

	private void updateFats(Food food, int updatedFats) {
		food.fats = updatedFats;
	}

	private void updateProtein(Food food, int updatedProtein) {
		food.protein = updatedProtein;
	}
}