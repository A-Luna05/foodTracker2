package model;
import java.util.Scanner;

public class Food {
	
	public String name;
	public String brand;
	public int calories;
	public int carbs;
	public int fats;
	public int protein;
	
	/*basic constructor, worth considering chaining a second constructor to make brand an optional variable*/
	
	public Food(String name, String brand, int calories, int carbs, int fats, int protein) {
		this.name = name;
		this.brand = brand;
		this.calories = calories;
		this.carbs = carbs;
		this.fats = fats;
		this.protein = protein;
	}
	
/*Option 1 for updateFood function: easiest to code but requires you to enter every value in the argument,
 *										 can't just change one at a time*/
	
/*
	private void updateFood(Food food, String name, String brand, int calories, int carbs, int fats, int protein) {
		food.name = name;
		food.brand = brand;
		food.calories = calories;
		food.carbs = carbs;
		food.fats = fats;
		food.protein = protein;
	}
*/
	
/*	Option 2: This gives flexibility for changing only one value at a time, 
 * 				instead of retyping all the values inside the argument	*/
	
/*	
	private void updateFood(Food food) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Update which category? name, brand, calories, carbs, fats, or protein");		
		String updateType = scanner.nextLine();
		
		String updateStringValue = "";
		int updateIntValue = -1;
				
		System.out.println("Enter new value: ");
		if(updateType == "name" || updateType == "brand") {
			updateStringValue = scanner.nextLine();
			
		}else {
			updateIntValue = scanner.nextInt();
		}
		
		
		if(updateType.toLowerCase() == "name") 
			{food.name = updateStringValue;}
		else if(updateType.toLowerCase() == "brand")
			{food.brand = updateStringValue;}
		else if(updateType == "calories")
			{food.calories = updateIntValue;}
		else if(updateType == "carbs")
			{food.carbs = updateIntValue;}
		else if(updateType == "fats")
			{food.fats = updateIntValue;}
		else if(updateType == "protein")
			{food.protein = updateIntValue;}
		else
			{System.out.println("Invalid category, try again.");}
		
	}
*/

/*Option 3: This requires each category to have their own function, but I think this is best when working with GUI's.
 * 				 It allows us to easily wire each function to the GUI.*/
	
	private void updateName(Food food, String updatedName) 
		{food.name = updatedName;}
	
	private void updateBrand(Food food, String updatedBrand) 
		{food.brand = updatedBrand;}
	
	private void updateCalories(Food food, int updatedCalories) 
		{food.calories = updatedCalories;}
	
	private void updateCarbs(Food food, int updatedCarbs) 
		{food.carbs = updatedCarbs;}
	
	private void updateFats(Food food, int updatedFats) 
		{food.fats = updatedFats;}
	
	private void updateProtein(Food food, int updatedProtein) 
		{food.protein = updatedProtein;}
}