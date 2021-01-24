
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import businnesslogic.ButtonActionsImpl;
import businnesslogic.FileManipulationDatabaseImpl;
import businnesslogic.FileManipulationImpl;
import database.Vehicles;
import exceptions.BadCharException;
import interfaces.ButtonActions;
import interfaces.FileManipulation;
import interfaces.FileManipulationDatabase;

public class Main {

	private static final String VIZSGA_CSV = "./src/vizsga.csv";
	private static final String DATA_CSV = "./src/data.csv";

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File(DATA_CSV);
		boolean exist = file.exists();

		final FileManipulation fileManipulation = new FileManipulationImpl();
		final FileManipulationDatabase fileManipulationDatabase = new FileManipulationDatabaseImpl();

		final ButtonActions buttonActions = new ButtonActionsImpl();

		List<Vehicles> vehicle = null;

		try {
			if (exist) {
				vehicle = fileManipulationDatabase.csvToVehiclesListDatabase(DATA_CSV);
				System.out.println("data.csv fájl sikeresen beolvasva");
			} else {
				vehicle = fileManipulation.csvToVehiclesList(VIZSGA_CSV);
				System.out.println("vizsga.csv fájl sikeresen beolvasva");
			}
		} catch (IOException e) {
			System.err.println("Hiba a fájl beolvasása során!");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.print("------------------Üdvözöljük-------------------");
		Scanner sc = null;
		int statusMain = 0;
		int statusSub3 = -1;
		int statusSub7 = -1;

		while (statusMain != 9) {
			buttonActions.menuMain();
			sc = new Scanner(System.in);
			try {
				statusMain = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Nem jó karaktert adtál meg! (1. - 9.)");
				continue;
			}
			try {	
				switch (statusMain) {
				case 1:
					buttonActions.button1(vehicle);
					break;
				case 2:
					buttonActions.button2(vehicle);
					break;
				case 3:
					buttonActions.button3();
					while (statusSub3 != 0) {
						sc = new Scanner(System.in);
						try {
							statusSub3 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem jó karaktert adtál meg! (0. - 3.)");
							continue;
						}
						try {
							switch (statusSub3) {
							case 1:
								buttonActions.button3Sub1(vehicle);
								buttonActions.button3();
								break;
							case 2:
								buttonActions.button3Sub2(vehicle);
								buttonActions.button3();
								break;
							case 3:
								buttonActions.button3Sub3(vehicle);
								buttonActions.button3();
							case 0:
								break;
							default:
								throw new BadCharException();
							}
						} catch (Exception e) {
							System.err.println(e.getMessage());
							buttonActions.button3();
						}
					}
					statusSub3 = -1;
					break;
				case 4:
					buttonActions.button4(vehicle);
					break;
				case 5:
					buttonActions.button5(vehicle);
					break;
				case 6:
					buttonActions.button6(vehicle);
					break;
				case 7:
					buttonActions.button7();
					while (statusSub7 != 0) {
						sc = new Scanner(System.in);
						try {
							statusSub7 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem jó karaktert adtál meg! (0. - 2.)");
							continue;
						}
						try {
							switch (statusSub7) {
							case 1:
								buttonActions.button7Sub1(vehicle);
								buttonActions.button7();
								break;
							case 2:
								buttonActions.button7Sub2(vehicle);
								buttonActions.button7();
								break;
							case 0:
								break;
							default:
								throw new BadCharException();
							}
						} catch (BadCharException e) {
							System.err.println(e.getMessage());
							buttonActions.button7();
						}
					}
					statusSub7 = -1;
					break;
				case 8:
					buttonActions.button8(vehicle);
					break;
				case 9:
					buttonActions.button9SaveAll(vehicle);
					System.out.println("Viszontlátásra!");
					break;
				default:
					throw new BadCharException();
				}
			} catch (BadCharException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}