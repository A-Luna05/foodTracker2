import java.io.IOException;
import java.util.Scanner;

import model.Diary;
import model.DiaryEntry;
import model.Food;

public class runMe {
	

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Healthy Eating / Food Tracker \nWhats your name?");
        String name = in.nextLine();
		System.out.println("Hello " + name);
		System.out.println("What is your daily calorie goal");
		int calGoal = in.nextInt();
		in.nextLine();
		System.out.println("What is your daily carb goal in grams");
		int carbGoal = in.nextInt();
		in.nextLine();
		System.out.println("What is your daily fat goal in grams");
		int fatGoal = in.nextInt();
		in.nextLine();
		System.out.println("What is your daily protein goal in grams");
		int proGoal = in.nextInt();
		in.nextLine();
		System.out.println("What is your daily water goal in ounces");
		int waterGoal = in.nextInt();
		in.nextLine();
		Diary diaryTest = new Diary(calGoal,carbGoal,fatGoal,proGoal,waterGoal);
		DiaryEntry testEntry = new DiaryEntry();
		while (true){
			System.out.println("What do you want to do?\n1: Log Today's Meals\n2: Get an Overview of a Day\n3: Quit");
			int choice = in.nextInt();
			in.nextLine();
			if(choice == 1){
				logMeals(testEntry, in);
			}else if (choice == 2){
				getDayOverview(diaryTest, in);
			} else if (choice == 3){
				System.out.println("Thanks, Goodbye.");
				break;
			} else {
				System.out.println("Please provide a valid input");
			}	
		}
		
		// testEntry.update(1, new Food("apple", 95, 25, 0, 0));
		// testEntry.update(2, new Food("bannana", 100, 16, 2, 0));
		// System.out.println(testEntry.getMeal(1));
		// System.out.println(testEntry.getMeal(2));
		// testEntry.updateWater(16);
		// System.out.println(testEntry.waterQty + " ounces");
		// testEntry.write();
		
		// System.out.println("*********************************************************");
		// System.out.println("Diary Test \n");


		// //replace the dates below on lines 26, 27
		// String totals = diaryTest.getRecord("11/11/2022");
		// diaryTest.checkGoals("11/11/2022");
		// System.out.print(totals);
	 in.close();
	}
	
		private static void logMeals(DiaryEntry entry, Scanner in) throws IOException {
			String foodName;
			int foodCal;
			int foodCarb;
			int foodFat;
			int foodPro;
			int water;
			String[] mealList = {"Breakfast", "Lunch", "Dinner"};
			for(int i = 0; i < 3; i++) {
				while(true) {
					System.out.println("What did you eat for " +mealList[i] +"? (Enter the name of the item) Enter (Done) if you didn't eat anything.");
					foodName = in.nextLine();
					if(foodName.toLowerCase().equals("done")) {
						break;
					}
					System.out.println("How many calories did it have?");
					foodCal = in.nextInt();
					in.nextLine();
					System.out.println("How many carbs did it have?");
					foodCarb = in.nextInt();
					in.nextLine();
					System.out.println("How many grams of fat did it have?");
					foodFat = in.nextInt();
					in.nextLine();
					System.out.println("How many grams of protein did it have?");
					foodPro = in.nextInt();
					in.nextLine();
					entry.update(i, new Food(foodName,foodCal,foodCarb,foodFat,foodPro));
				}
			}
			System.out.println("How many ounces of water did you drink");
			water = in.nextInt();
			in.nextLine();
			entry.updateWater(water);
			entry.write();
			System.out.println("Meals logged!");
		}

		private static void getDayOverview(Diary diary, Scanner in){
			System.out.println("Which day do you want to see your totals for? Input date as MM/DD/YYYY, Ex: 11/15/2022");
			String date = in.nextLine();
			diary.checkGoals(date);
		}
}