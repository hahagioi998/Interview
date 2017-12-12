package 面经.OOD.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
	//field 定义为protected了
	//field是属于这个class或者object的特性

	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	//牌照
	protected String licensePlate;
	//占用的位子个数
	protected int spotsNeeded;
	//大小
	protected VehicleSize size;
	
	public VehicleSize getSize() {
		return size;
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	//方法是针对自己的field设计的，目的在于让别的client，或者class来通过方法操作自身的field，停车，看可不可以fit，清空车位（同时需要parking spot来清）
	//类之间方法的相互调用，在于需要共同完成某项操作

	//这个park的方法是让parkingspot类里面的park来调用的
	/* Park vehicle in this spot (among others, potentially) */
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}
	//这个unpark的方法调用了parkingspot的removeVehicle方法
	/* Remove car from spot, and notify spot that it's gone */
	public void clearSpots() {
		for (int i = 0; i < parkingSpots.size(); i++) {
			parkingSpots.get(i).removeVehicle();
		}
		//arraylist还有clear方法
		parkingSpots.clear();
	}
	//会被canFitVehicle方法调用，这里是abstract的方法，让继承类去实现
	public abstract boolean canFitInSpot(ParkingSpot spot);
	public abstract void print();
}
