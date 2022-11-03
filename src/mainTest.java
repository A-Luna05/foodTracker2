import java.io.IOException;

import model.DiaryEntry;
import model.Food;

public class mainTest {
	public static void main(String[] args) throws IOException {
		DiaryEntry testEntry = new DiaryEntry();
		System.out.println("hello");
		testEntry.update(1, new Food("apple", "Dole", 95, 25, 0, 0));
		testEntry.update(2, new Food("bannana", "Dole", 100, 16, 0, 0));
		System.out.println(testEntry.getMeal(1));
		System.out.println(testEntry.getMeal(2));
		testEntry.updateWater(16);
		System.out.println(testEntry.waterQty + " ounces");
		testEntry.write();
	}
}
