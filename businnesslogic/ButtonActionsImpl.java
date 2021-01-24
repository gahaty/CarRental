package businnesslogic;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import database.Vehicles;
import exceptions.BadCharException;
import interfaces.ButtonActions;

public class ButtonActionsImpl implements ButtonActions {

	private static int i = 0;
	Scanner sc = new Scanner(System.in);

	@Override
	public void formatCars(List<Vehicles> vehicle) {
		System.out.print(String.format("%-8s", "\ntípus: ") + vehicle.get(i).getType() + "   " + "gyártó: "
				+ String.format("%-13s", vehicle.get(i).getManufacturer()) + String.format("%-10s", " rendszám: ")
				+ String.format("%-12s", vehicle.get(i).getPlateNumber()) + " szín: "
				+ String.format("%-10s", vehicle.get(i).getColor()) + " férõhely: "
				+ String.format("%-3s", vehicle.get(i).getSeats()) + " évjárat: "
				+ String.format("%-6s", vehicle.get(i).getVintage()) + " javításon: "
				+ vehicle.get(i).isUnderRepairTranslate());
	}

	@Override
	public void formatShips(List<Vehicles> vehicle) {
		System.out.print(String.format("%-8s", "\ntípus: ") + vehicle.get(i).getType() + "   " + "gyártó: "
				+ String.format("%-13s", vehicle.get(i).getManufacturer()) + String.format("%-10s", " rendszám: ")
				+ String.format("%-12s", vehicle.get(i).getPlateNumber()) + " szín: "
				+ String.format("%-10s", vehicle.get(i).getColor()) + " vitorlák: "
				+ String.format("%-3s", vehicle.get(i).getNumOfSail()) + " férõhely: "
				+ String.format("%-3s", vehicle.get(i).getSeats()) + " évjárat: "
				+ String.format("%-6s", vehicle.get(i).getVintage()) + " javításon: "
				+ vehicle.get(i).isUnderRepairTranslate());
	}

	@Override
	public void listAll(List<Vehicles> vehicle) {
		for (i = 0; i < vehicle.size(); i++) {
			System.out.print(String.format("%-8s", "\ntípus: ") + vehicle.get(i).getType() + "   " + "gyártó: "
					+ String.format("%-13s", vehicle.get(i).getManufacturer()) + String.format("%-10s", " rendszám: ")
					+ String.format("%-12s", vehicle.get(i).getPlateNumber()) + " szín: "
					+ String.format("%-10s", vehicle.get(i).getColor()) + " vitorlák: "
					+ String.format("%-6s", vehicle.get(i).getNumOfSail()) + " férõhely: "
					+ String.format("%-3s", vehicle.get(i).getSeats()) + " évjárat: "
					+ String.format("%-6s", vehicle.get(i).getVintage()) + " javításon: "
					+ vehicle.get(i).isUnderRepairTranslate());
		}
	}

	@Override
	public void menuMain() {
		System.out.println("\n\n#################### MENÜ #####################");
		System.out.println("1. AUTÓK");
		System.out.println("2. HAJÓK");
		System.out.println("3. Keresés");
		System.out.println("4. Javításra küld");
		System.out.println("5. Javítás alatt álló jármûvek");
		System.out.println("6. Statisztika");
		System.out.println("7. Új hozzáadása");
		System.out.println("8. Legfiatalabb/legidõsebb jármû gyártók szerint");
		System.out.println("9. Kilépés");
	}

	@Override
	public void button1(List<Vehicles> vehicle) {
		for (i = 0; i < vehicle.size(); i++) {
			boolean type = vehicle.get(i).getType().equals("auto");
			boolean underRepair = vehicle.get(i).isUnderRepair() == false;
			if (type && underRepair) {
				formatCars(vehicle);
			}
		}
	}

	@Override
	public void button2(List<Vehicles> vehicle) {
		for (i = 0; i < vehicle.size(); i++) {
			boolean type = vehicle.get(i).getType().equals("hajo");
			boolean underRepair = vehicle.get(i).isUnderRepair() == false;
			if (type && underRepair) {
				formatShips(vehicle);
			}
		}
	}

	@Override
	public void button3() {
		System.out.println("\n\n################## KERESÉS ####################");
		System.out.println("1. Rendszám alapján");
		System.out.println("2. Férõhely szerint");
		System.out.println("3. Évjárat alapján");
		System.out.println("0. FÕMENÜ");
	}

	@Override
	public void button3Sub1(List<Vehicles> vehicle) {

		String plateNumber = "";
		boolean isPlateNUmber = false;
		System.out.println("Kérem a rendszámot!");
		plateNumber = sc.next();
		for (i = 0; i < vehicle.size(); i++) {
			boolean numOfPlateNumber = vehicle.get(i).getPlateNumber().equalsIgnoreCase(plateNumber);
			if (numOfPlateNumber) {
				isPlateNUmber = true;
				if (vehicle.get(i).getType().equals("auto")) {
					formatCars(vehicle);
				} else {
					formatShips(vehicle);
				}
			}
		}
		if (!isPlateNUmber) {
			System.out.println("Nincs ilyen rendszámú jármû az adatbázisban.");
		}
		sc.nextLine();
	}

	@Override
	public void button3Sub2(List<Vehicles> vehicle) {

		Integer seats = 0;
		boolean result;

		do {
			result = false;
			try {
				System.out.println("Hány személyes a jármû? (2 - 10)");
				seats = sc.nextInt();
				if (seats >= 2 && seats <= 10) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		boolean isSeats = false;
		for (i = 0; i < vehicle.size(); i++) {
			boolean numOfSeats = vehicle.get(i).getSeats().equals(seats);
			if (numOfSeats) {
				isSeats = true;
				if (vehicle.get(i).getType().equals("auto")) {
					formatCars(vehicle);
				} else {
					formatShips(vehicle);
				}
			}
		}
		if (!isSeats) {
			System.out.println("Nincs " + seats + " férõhelyes jármû az adatbázisban.");
		}
		sc.nextLine();
	}

	@Override
	public void button3Sub3(List<Vehicles> vehicle) {

		String type = "";
		Integer vintage = -1;
		boolean result;

		do {
			try {
				System.out.println("Kérem a jármû típusát! (auto, hajo)");
				type = sc.next();
				if (!type.equalsIgnoreCase("auto") && !type.equalsIgnoreCase("hajo")) {
					throw new BadCharException();
				}
				type = type.toLowerCase();
			} catch (BadCharException e) {
				System.err.println(e.getMessage());
			}
		} while (!type.equalsIgnoreCase("auto") && !type.equalsIgnoreCase("hajo"));

		do {
			result = false;
			try {
				System.out.println("Kérem az évjáratot! (1900 - 2020)");
				vintage = sc.nextInt();
				if (vintage >= 1900 && vintage <= 2020) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");

			}
		} while (result != true);

		boolean isType = false;
		for (i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).getType().equals("auto") && type.equals("auto")
					&& vehicle.get(i).getVintage() >= vintage) {
				isType = true;
				formatCars(vehicle);
			} else if (vehicle.get(i).getType().equals("hajo") && type.equals("hajo")
					&& vehicle.get(i).getVintage() >= vintage) {
				isType = true;
				formatShips(vehicle);
			}
		}
		if (!isType) {
			System.out.println("Nincs " + vintage + " évjáratú " + type + " az adatbázisban");
		}
		sc.nextLine();
	}

	@Override
	public void button4(List<Vehicles> vehicle) {

		boolean isPlateNumber = false;
		int iStatus = -1;
		String plateNumber = "";
		String cause = "";
		int whichVechicle = -1;
		boolean numOfPlateNumber = false;

		List<Integer> collect = new ArrayList<>();

		System.out.println("Kérem a rendszámot!");
		plateNumber = sc.next();
		for (i = 0; i < vehicle.size(); i++) {
			numOfPlateNumber = vehicle.get(i).getPlateNumber().equalsIgnoreCase(plateNumber);
			if (numOfPlateNumber && vehicle.get(i).isUnderRepair() == false) {
				isPlateNumber = true;
				if (vehicle.get(i).getType().equals("auto")) {
					collect.add(i);
					formatCars(vehicle);
				} else {
					collect.add(i);
					formatShips(vehicle);
				}
			}
		}

		for (int i = 0; i < collect.size(); i++) {
			iStatus = i;
		}

		if (iStatus > 0) {
			boolean result;
			do {
				result = false;
				try {
					System.out.println("\nMelyik sorban szereplõ jármûvet küldjük javításra? (1. - " + (iStatus + 1) + ".)");
					whichVechicle = sc.nextInt();
					if (whichVechicle >= 1 && whichVechicle - 1 <= iStatus) {
						vehicle.get(collect.get(whichVechicle - 1)).getPlateNumber().equals(plateNumber);
						result = true;
					} else {
						System.out.println("hibás adatbevitel!");
					}
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.err.println("Nem jó karaktert adtál meg!");
				}
			} while (result != true);
		} else if (!collect.isEmpty()) {
			whichVechicle = 0;
			vehicle.get(collect.get(0)).getPlateNumber().equals(plateNumber);
		}
		if (isPlateNumber) {
			cause = sc.nextLine();
			System.out.println("\nKérek egy leírást a hibáról!");
			cause = sc.nextLine();
			if (iStatus > 0) {
				vehicle.get(collect.get(whichVechicle - 1)).setUnderRepair(true);
				vehicle.get(collect.get(whichVechicle - 1)).setCause(cause);
			} else {
				vehicle.get(collect.get(whichVechicle)).setUnderRepair(true);
				vehicle.get(collect.get(whichVechicle)).setCause(cause);
			}
			System.out.println("Javításra elküldve.");
		} else {
			for (i = 0; i < vehicle.size(); i++) {
				if(vehicle.get(i).getPlateNumber().equals(plateNumber)) {
					numOfPlateNumber = true;
				}
			}
			if (numOfPlateNumber) {
				System.out.println("javítás alatt álló jármû!");
			} else {
				System.out.println("Nincs ilyen rendszámú jármû az adatbázisban");
			}
		}
	collect.clear();
	}

	@Override
	public void button5(List<Vehicles> vehicle) {
		for (i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).isUnderRepair()) {
				System.out.print(String.format("%-8s", "\ntípus: ") + vehicle.get(i).getType() + "   " + "gyártó: "
						+ String.format("%-13s", vehicle.get(i).getManufacturer())
						+ String.format("%-10s", " rendszám: ")
						+ String.format("%-12s", vehicle.get(i).getPlateNumber()) + "Hiba: ");
				if (vehicle.get(i).getCause() != null) {
					System.out.print(vehicle.get(i).getCause());
				} else {
					System.out.print(" ");
				}
			}
		}
	}

	@Override
	public void button6(List<Vehicles> vehicle) {

		HashMap<Integer, Set<String>> hmap = new HashMap<>();
		for (Vehicles v : vehicle) {
			Integer vintage = v.getVintage();
			Set<String> vintageInMap = hmap.get(vintage);
			if (vintageInMap == null) {
				vintageInMap = new TreeSet<>();
			}
			vintageInMap.add(v.getManufacturer());
			hmap.put(vintage, vintageInMap);
		}
		String line = "";
		StringBuilder strData = new StringBuilder();
		for (Map.Entry<Integer, Set<String>> elements : hmap.entrySet()) {
			System.out.println(line = elements.getKey() + ":");
			strData.append(line);
			strData.append("\n");
			for (String element : elements.getValue()) {
				System.out.println(line = element);
				strData.append(line);
				strData.append("\n");
			}
			System.out.println();
			strData.append("\n");
		}

		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		String date = sdf.format(new Date());

		String str = strData.toString();
		String fileName = "./src/statisztika_" + date + ".txt";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(str);
			fw.close();
		} catch (Exception e) {
			System.out.println("Hiba a fájl írása közben");
		}
	}

	@Override
	public void button7() {
		System.out.println("\n\n################ ÚJ HOZZÁADÁSA ################");
		System.out.println("1. Autó");
		System.out.println("2. Hajó");
		System.out.println("0. FÕMENÜ");
	}

	@Override
	public boolean checkPlateNumber(List<Vehicles> vehicle, String plateNumber) {
		for (int i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).getPlateNumber().equals(plateNumber)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void button7Sub1(List<Vehicles> vehicle) {

		String type = "auto";
		String manufacturer = "";
		String plateNumber = "";
		String color = "";
		Integer seats = -1;
		Integer vintage = -1;
		Integer underReapirConvert = -1;
		boolean underRepair = false;
		String cause = null;

		do {
			System.out.println("Kérem a gyártót!");
			manufacturer = sc.nextLine();
		} while (manufacturer.equals(""));

		boolean checkPlateNumber = false;
		do {
			checkPlateNumber = false;
			System.out.println("Kérem a rendszámot!");
			plateNumber = sc.next();
			sc.nextLine();
			if (checkPlateNumber(vehicle, plateNumber)) {
				System.out.println("Ezzel a rendszámmal már van jármû a rendszeben!");
				plateNumber = "";
				checkPlateNumber = true;
			}
		} while (checkPlateNumber != false);

		do {
			System.out.println("Milyen színû?");
			color = sc.nextLine();
		} while (color.equals(""));

		boolean result;
		do {
			result = false;
			try {
				System.out.println("Hány személyes a jármû? (2 - 10)");
				seats = sc.nextInt();
				if (seats >= 2 && seats <= 10) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		do {
			result = false;
			try {
				System.out.println("Kérem az évjáratot! (1900 - 2020)");
				vintage = sc.nextInt();
				if (vintage >= 1900 && vintage <= 2020) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		do {
			result = false;
			try {
				System.out.println("Szervízbe küld? (0 - nem, 1 - igen)");
				underReapirConvert = sc.nextInt();
				if (underReapirConvert.equals(0)) {
					result = true;
					underRepair = false;
					sc.nextLine();
				} else if (underReapirConvert.equals(1)) {
					result = true;
					underRepair = true;
					cause = sc.nextLine();
					System.out.println("Kérem a hiba rövid leírását!");
					cause = sc.nextLine();
				} else {
					System.out.println("Hibás adatbevitel.");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		vehicle.add(new Vehicles(type, manufacturer, plateNumber, color, seats, vintage, underRepair, cause));
		System.out.println("Adatok hozzáadva");
	}

	@Override
	public void button7Sub2(List<Vehicles> vehicle) {

		String type = "hajo";
		String manufacturer = "";
		String plateNumber = "";
		String color = "";
		Integer numOfSail = -1;
		Integer seats = -1;
		Integer vintage = -1;
		Integer underReapirConvert = -1;
		boolean underRepair = false;
		String cause = null;
		
		do {
			System.out.println("Kérem a gyártót!");
			manufacturer = sc.nextLine();
		} while (manufacturer.equals(""));

		boolean checkPlateNumber = false;
		do {
			checkPlateNumber = false;
			System.out.println("Kérem a rendszámot!");
			plateNumber = sc.next();
			sc.nextLine();
			if (checkPlateNumber(vehicle, plateNumber)) {
				System.out.println("Ezzel a rendszámmal már van jármû a rendszeben!");
				plateNumber = "";
				checkPlateNumber = true;
			}
		} while (checkPlateNumber != false);

		do {
			System.out.println("Milyen színû?");
			color = sc.nextLine();
		} while (color.equals(""));

		boolean result;
		do {
			result = false;
			try {
				System.out.println("Kérem a vitorlák számát! (0 - 10)");
				numOfSail = sc.nextInt();
				if (numOfSail >= 0 && numOfSail <= 10) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		do {
			result = false;
			try {
				System.out.println("Hány személyes a jármû (2 - 10)");
				seats = sc.nextInt();
				if (seats >= 2 && seats <= 10) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		do {
			result = false;
			try {
				System.out.println("Kérem az évjáratot! (1900 - 2020)");
				vintage = sc.nextInt();
				if (vintage >= 1900 && vintage <= 2020) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");

			}
		} while (result != true);

		do {
			result = false;
			try {
				System.out.println("Javítás alatt áll? (0 - nem, 1 - igen)");
				underReapirConvert = sc.nextInt();
				if (underReapirConvert.equals(0)) {
					result = true;
					underRepair = false;
				} else if (underReapirConvert.equals(1)) {
					result = true;
					underRepair = true;
					cause = sc.nextLine();
					System.out.println("Kérem a hiba rövid leírását!");
					cause = sc.nextLine();
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Nem jó karaktert adtál meg!");
			}
		} while (result != true);

		vehicle.add(
				new Vehicles(type, manufacturer, plateNumber, color, numOfSail, seats, vintage, underRepair, cause));
		System.out.println("Adatok hozzáadva");
	}

	public Map<String, List<Vehicles>> yearsByManufacturer(List<Vehicles> vehicle) {
		Map<String, List<Vehicles>> result = new LinkedHashMap<>();
		for (Vehicles vehicles : vehicle) {
			List<Vehicles> vehiclesList = result.getOrDefault(vehicles.getManufacturer(), new ArrayList<>());
			vehiclesList.add(vehicles);
			result.put(vehicles.getManufacturer(), vehiclesList);
		}
		return result;
	}

	@Override
	public void button8(List<Vehicles> vehicles) {
		Map<String, List<Vehicles>> yearsByManufacturer = yearsByManufacturer(vehicles);
		for (String v : yearsByManufacturer.keySet()) {
			List<Vehicles> vehicleTmp = yearsByManufacturer.get(v);
			Vehicles old = vehicleTmp.get(0);
			Vehicles young = vehicleTmp.get(0);
			for (Vehicles vehicle : vehicleTmp) {
				if (old.getVintage() < vehicle.getVintage()) {
					old = vehicle;
				}
				if (young.getVintage() > vehicle.getVintage()) {
					young = vehicle;
				}
			}
			System.out.println();
			boolean equals = young.getVintage().equals(old.getVintage());
			System.out.println(equals ? v + ":" + "\n" + young.getVintage()
					: v + ":" + "\n" + young.getVintage() + "\n" + old.getVintage());
		}
	}

	@Override
	public void button9SaveAll(List<Vehicles> vehicle) {
		String line = "tipus,gyarto,rendszam,szin,vitorlak szama,ferohelyek szama,evjarat,javitas alatt,hiba oka";
		StringBuilder strData = new StringBuilder();
		strData.append(line + "\n");

		for (i = 0; i < vehicle.size(); i++) {
			line = vehicle.get(i).getType() + "," + vehicle.get(i).getManufacturer() + ","
					+ vehicle.get(i).getPlateNumber() + "," + vehicle.get(i).getColor() + ","
					+ vehicle.get(i).getNumOfSail() + "," + vehicle.get(i).getSeats() + ","
					+ vehicle.get(i).getVintage() + "," + vehicle.get(i).isUnderRepair() + ","
					+ vehicle.get(i).getCause();
			strData.append(line + "\n");
		}

		String str = strData.toString();
		String fileName = "./src/data.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(str);
			fw.close();
			System.out.println("Adatbázis mentve: ./src/data.csv");
		} catch (Exception e) {
			System.out.println("Hiba a fájl írása közben");
		}
	}
}