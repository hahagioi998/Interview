package 面经.OOD.ParkingLot;

public class ParkingSpot {
	//spot也要知道自己这里停的是什么车
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
		level = lvl;
		row = r;
		spotNumber = n;
		spotSize = sz;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	//注意方法的input和output，return type
	
	/* Checks if the spot is big enough for the vehicle (and is available). This compares
	 * the SIZE only. It does not check if it has enough spots. */
	public boolean canFitVehicle(Vehicle vehicle) {
		//canFitInSpot也是传this
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	
	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		//调用了vehicle的parkInSpot，把this传进去，这样就可以知道是这个parking spot！！
		vehicle.parkInSpot(this);
		return true;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	public VehicleSize getSize() {
		return spotSize;
	}
	//spot要通知level
	/* Remove vehicle from spot, and notify level that a new spot is available */
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
	
	public void print() {
		if (vehicle == null) {
			if (spotSize == VehicleSize.Compact) {
				System.out.print("c");
			} else if (spotSize == VehicleSize.Large) {
				System.out.print("l");
			} else if (spotSize == VehicleSize.Motorcycle) {
				System.out.print("m");
			}
		} else {
			vehicle.print();
		}
	}
}
