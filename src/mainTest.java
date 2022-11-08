import java.io.IOException;

import model.Diary;
import model.DiaryEntry;
import model.Food;

public class mainTest {
	public static void main(String[] args) throws IOException {
		System.out.println("Diary Entry Test \n");

		DiaryEntry testEntry = new DiaryEntry();
		testEntry.update(1, new Food("apple", "Dole", 95, 25, 0, 0));
		testEntry.update(2, new Food("bannana", "Dole", 100, 16, 2, 0));
		System.out.println(testEntry.getMeal(1));
		System.out.println(testEntry.getMeal(2));
		testEntry.updateWater(16);
		System.out.println(testEntry.waterQty + " ounces");
		testEntry.write();
		
		System.out.println("*********************************************************");
		System.out.println("Diary Test \n");


		Diary diaryTest = new Diary(0,0,0,0,0);
		String totals = diaryTest.getRecord("11/8/2022");
		diaryTest.checkGoals("11/8/2022");
		System.out.print(totals);
	}
}