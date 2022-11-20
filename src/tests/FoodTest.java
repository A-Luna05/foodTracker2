package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Food;

class FoodTest {

	@Test
	public void testFoodConstructor() {
		Food uut = new Food("Stick of Gum", "Five", 5, 2, 0, 0);
		assertEquals(5, uut.calories);
		assertEquals(0, uut.fats);
		assertEquals(2, uut.carbs);
		assertEquals(0, uut.protein);
		
		
	}
	@Test
	public void testUpdateName() {
		Food uut = new Food("Chicken Breast", "Tyson", 140, 2, 2, 30);
		assertEquals("Chicken Breast", uut.name);
		uut.updateName(uut, "Chicken Thigh");
		assertEquals("Chicken Thigh", uut.name);
	}
	@Test
	public void testUpdateBrand() {
		Food uut = new Food("Chicken Breast", "Tyson", 140, 2, 2, 30);
		assertEquals("Tyson", uut.brand);
		uut.updateBrand(uut, null);
		assertEquals(null, uut.brand);
		uut.updateBrand(uut, "Charmin");
		assertEquals("Charmin", uut.brand);		
	}
	@Test
	public void testNutritionUpdates() {
		Food uut = new Food("Steak", "America's Best", 225, 1, 8, 24);
		assertEquals(225, uut.calories);
		assertEquals(1, uut.carbs);
		assertEquals(8, uut.fats);
		assertEquals(24, uut.protein);
		uut.updateCalories(uut, 250);
		assertEquals(250, uut.calories);
		uut.updateCarbs(uut, 3);
		assertEquals(3, uut.carbs);
		uut.updateFats(uut, 12);
		assertEquals(12, uut.fats);
		uut.updateProtein(uut, 25);
		assertEquals(25, uut.protein);
		
	}

}
