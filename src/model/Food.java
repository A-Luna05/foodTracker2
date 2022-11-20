package model;

import java.util.Scanner;

public class Food {

	public String name;
	public String brand;
	public int calories;
	public int carbs;
	public int fats;
	public int protein;

	/*
	 * basic constructor, worth considering chaining a second constructor to make
	 * brand an optional variable
	 */

	public Food(String name, String brand, int calories, int carbs, int fats, int protein) {
		this.name = name;
		this.brand = brand;
		this.calories = calories;
		this.carbs = carbs;
		this.fats = fats;
		this.protein = protein;
	}

	public void updateName(Food food, String updatedName) {
		food.name = updatedName;
	}

	public void updateBrand(Food food, String updatedBrand) {
		food.brand = updatedBrand;
	}

	public void updateCalories(Food food, int updatedCalories) {
		food.calories = updatedCalories;
	}

	public void updateCarbs(Food food, int updatedCarbs) {
		food.carbs = updatedCarbs;
	}

	public void updateFats(Food food, int updatedFats) {
		food.fats = updatedFats;
	}

	public void updateProtein(Food food, int updatedProtein) {
		food.protein = updatedProtein;
	}
}