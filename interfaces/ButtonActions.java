package interfaces;

import java.util.List;
import java.util.Map;

import database.Vehicles;

public interface ButtonActions {
	
	void formatCars(List<Vehicles> vehicle);
	
	void formatShips(List<Vehicles> vehicle);
	
	void listAll(List<Vehicles> vehicle);
	
	void menuMain();
	
	void button1(List<Vehicles> vehicle);
	
	void button2(List<Vehicles> vehicle);
	
	void button3();
	
	void button3Sub1 (List<Vehicles> vehicle);
	
	void button3Sub2 (List<Vehicles> vehicle);
	
	void button3Sub3 (List<Vehicles> vehicle);
	
	void button4(List<Vehicles> vehicle);
	
	void button5(List<Vehicles> vehicle);
	
	void button6(List<Vehicles> vehicle);
	
	void button7();
	
	void button7Sub1(List<Vehicles> vehicle);
	
	boolean checkPlateNumber(List<Vehicles> vehicle, String plateNumber);
	
	void button7Sub2(List<Vehicles> vehicle);
	
	void button8(List<Vehicles> vehicle);
	
	Map<String, List<Vehicles>> yearsByManufacturer(List<Vehicles> vehicle);
	
	void button9SaveAll(List<Vehicles> vehicle);

	
	
	
}
