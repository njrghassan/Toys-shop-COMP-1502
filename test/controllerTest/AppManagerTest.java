package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controller.AppManager;
import model.Toys;

class AppManagerTest {
	
	AppManager app = new AppManager();
	
	@Test
	void searchBToysialNumberTest() {
		app.run();
		ArrayList<Toys> foundT = new ArrayList<Toys>();
		
		foundT = app.searchBySerialNumber("2835360879");
		
		assertEquals(1, foundT.size());
	}
	
	@Test
	void searchByToyNameTest() {
		app.run();
		ArrayList<Toys> foundT = new ArrayList<Toys>();

		foundT = app.searchByToyName("star");

		assertEquals(4, foundT.size());
	}
	
	@Test
	void searchByToyTypeTest() {
		app.run();
		ArrayList<Toys> foundT = new ArrayList<Toys>();

		foundT = app.searchByToyType("figure");

		assertEquals(49, foundT.size());
	}

}
