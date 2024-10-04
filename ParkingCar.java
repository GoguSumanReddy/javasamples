package Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Car {
	private String carName;
	private String carNumber;

	Car(String carName, String carNumber) {
		this.carName = carName;
		this.carNumber = carNumber;
	}

	void parkCar(Car c, String level, HashMap<String, List> parlingLot) {
		List<Car> levelRow = parlingLot.get(level);

		Boolean isSlotFree = false;
		for (int i = 0; i < levelRow.size(); i++) {
			if (levelRow.get(i) == null) {
				System.out.println("Car is parked at " + level);
				isSlotFree = true;
				break;
			}
		}
		if (isSlotFree == false) {
			System.out.println("Car parking slot is not free at "+level);
		}
	}
}

public class ParkingCar {

	public static void main(String args[]) {

		HashMap<String, List> parlingLot = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of levels: ");
		int ln = sc.nextInt();

		System.out.print("Enter number of slots in each Level: ");
		int n = sc.nextInt();

		for (int j = 0; j < ln; j++) {

			List<Car> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(null);
			}
			parlingLot.put("Level" + j, list);

		}

		System.out.print("Enter the level from 0 to " + (ln - 1) + " where you would like to park your car ");
		int level = sc.nextInt();
		
		Car c = new Car("i10", "AP Z4743");
		c.parkCar(c, "Level" + level, parlingLot);

	}

}
