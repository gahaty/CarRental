package businnesslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import database.Vehicles;
import interfaces.FileManipulation;

public class FileManipulationImpl implements FileManipulation {

	private static final String COMMA_DEMLIMITER = ",";
	private static final String FIRST_LINE = "tipus,gyarto,rendszam,szin,vitorlak szama,ferohelyek szama,evjarat,javitas alatt";
	
	@Override
	public List<Vehicles> csvToVehiclesList(String filePath) throws IOException{
		List<Vehicles> result = new ArrayList<>();
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while ((line = br.readLine()) != null) {
			if (!line.equalsIgnoreCase(FIRST_LINE)) {
				String[] vehiclesDetails = line.split(COMMA_DEMLIMITER);
				Vehicles vehicles = vehiclesParser(vehiclesDetails);
				result.add(vehicles);
			}
		}
		br.close();
		return result;
	}

	private Vehicles vehiclesParser(String[] line) {

		String type = line[0];
		String manufacturer = line[1];
		String plateNumber = line[2];
		String color = line[3];
		Integer numOfSail;
		String strNumOfSail = line[4];
		if (strNumOfSail.equals("null")){
			numOfSail = null;
		}
		else {
			numOfSail = Integer.parseInt(line[4]);
		}
		Integer seats = Integer.parseInt(line[5]);
		Integer vintage = Integer.parseInt(line[6]);
		boolean underRepair = Boolean.parseBoolean(line[7]);
		return new Vehicles(type, manufacturer, plateNumber, color, numOfSail, seats, vintage, underRepair);
	}		
}