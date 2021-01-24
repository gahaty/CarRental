package interfaces;

import java.io.IOException;
import java.util.List;
import database.Vehicles;

public interface FileManipulationDatabase {

	List<Vehicles> csvToVehiclesListDatabase(String filePath) throws IOException;
}