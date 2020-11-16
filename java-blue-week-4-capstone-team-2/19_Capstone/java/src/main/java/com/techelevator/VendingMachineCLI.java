package com.techelevator;

import com.techelevator.Data.ItemMapDao;
import com.techelevator.Entities.VendingMachineItem;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
	MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
            PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;

	private BigDecimal currentBalance = new BigDecimal("0.00");

	private Map<String, VendingMachineItem> snackMap;

	private File receipts;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			//DISPLAYS ITEMS FROM MAIN MENU
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				for (VendingMachineItem item : snackMap.values()){
					System.out.println(item);
				}

				//OPENS INTERACTIVE PURCHASE MENU OPTIONS
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					System.out.println("\nCurrent balance: $" + currentBalance);
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);


					//FEED MONEY
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						Scanner scanner = new Scanner(System.in);
						System.out.println("\nPlease insert bills");

						String dollarAmount = scanner.nextLine();
						BigDecimal moneyInserted = new BigDecimal(dollarAmount);
						currentBalance = currentBalance.add(moneyInserted);


						//PRINTER for FEED MONEY
						try (PrintWriter logPrinter = new PrintWriter(receipts)) {

							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu HH:mm:ss a");
							logPrinter.println( LocalDateTime.now().format(formatter)+ " FEED MONEY: $" + currentBalance);

						} catch (FileNotFoundException ex) {
							System.out.println("file not found");
						}


						//Display items for selection
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {

						for (VendingMachineItem item : snackMap.values()){
							System.out.println(item);
						}

						Scanner userSlotSelection = new Scanner(System.in);
						System.out.println("\nPlease select a slot number.");
						String userSlotInput = userSlotSelection.next();

						//CHECKS FOR VALID ENTRY AND SUFFICIENT FUNDS
						if(!snackMap.containsKey(userSlotInput)){
							System.out.println("\nSlot number does not exist");
						} else if(snackMap.get(userSlotInput).getQuantity() == 0) {
							System.out.println("\nThis item is sold out");
						} else if(currentBalance.compareTo(snackMap.get(userSlotInput).getPrice()) == -1) {
							System.out.println("\nInsufficient balance");

							//PROCEEDS WITH PURCHASE
						} else {
							System.out.println(snackMap.get(userSlotInput).getItemName() +
									" $" + snackMap.get(userSlotInput).getPrice());
							currentBalance = currentBalance.subtract(snackMap.get(userSlotInput).getPrice());

							//ADUSTS QUANTITY (FAILED!!)
							snackMap.get(userSlotInput).setQuantity( snackMap.get(userSlotInput).getQuantity() -1 );


							System.out.println(snackMap.get(userSlotInput).getMessage());
							System.out.println("Current Balance $" + currentBalance);


							//PRINTER for PURCHASED ITEM
							try (PrintWriter logPrinter = new PrintWriter(
									new FileOutputStream(receipts, true))) {

								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu HH:mm:ss a");
								logPrinter.println( LocalDateTime.now().format(formatter)+ " " +
										snackMap.get(userSlotInput).getItemName() + " " +
										snackMap.get(userSlotInput).getSlotNumber() + ": $" + currentBalance);

							} catch (FileNotFoundException ex) {
								System.out.println("file not found");
							}


						}
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

				//CALCULATES and RETURNS CHANGE
				int changeBalance = currentBalance.multiply(new BigDecimal("100")).intValue();

				int quarters = 0;
				int quarterValue = 25;

				int dimes = 0;
				int dimeValue = 10;

				int nickels = 0;
				int nickelValue = 5;

				while(changeBalance > 0) {

					quarters = changeBalance / quarterValue;
					changeBalance -= quarters * quarterValue;

					dimes = changeBalance / dimeValue;
					changeBalance -= dimes * dimeValue;

					nickels = changeBalance / nickelValue;
					changeBalance -= nickels * nickelValue;

					System.out.println(quarters + " quarters " + dimes + " dimes " + nickels + " nickels!");
				}

				//PRINTS CURRENT BALANCE
				BigDecimal changeProvided = new BigDecimal(0.00);
				changeProvided = currentBalance;

				currentBalance = currentBalance.subtract(currentBalance);
				System.out.println("Current balance: " + currentBalance);


				//PRINTER for CHANGE PROVIDED
				try (PrintWriter logPrinter = new PrintWriter(
						new FileOutputStream(receipts, true))) {

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu HH:mm:ss a");
					logPrinter.println( LocalDateTime.now().format(formatter)+ " GIVE CHANGE $" + changeProvided + " $" + currentBalance);

				} catch (FileNotFoundException ex) {
					System.out.println("file not found");
				}


				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		ItemMapDao dao = new ItemMapDao();
		cli.snackMap = dao.snackMap();

		cli.receipts = new File("receipts.txt");

		cli.run();

	}
}
