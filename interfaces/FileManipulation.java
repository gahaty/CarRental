package interfaces;

import java.io.IOException;
import java.util.List;
import database.Vehicles;

public interface FileManipulation {

	List<Vehicles> csvToVehiclesList(String filePath) throws IOException;
}