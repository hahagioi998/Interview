package 面经.OOD.ParkingLot;

public class ParkingLot {
	//array of levels
	private Level[] levels;
	//没有直接固定level，而是用了另一个值去显示level
	private final int NUM_LEVELS = 5;
	
	public ParkingLot() {
		//在这个construct里，创建了level的实体，没有用任何parameter
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, 30);
		}
	}
	//遍历所有层去找可以停车的位置
	/* Park the vehicle in a spot (or multiple spots). Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
}
