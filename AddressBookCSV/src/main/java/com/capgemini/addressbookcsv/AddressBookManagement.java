package com.capgemini.addressbookcsv;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AddressBookManagement {
	static Scanner sc = new Scanner(System.in);
	public static Map<String, AddressBookMain> addressBookMap = new TreeMap<>();
	public static Map<String, Contact> cityContactMap = new TreeMap<>();
	public static Map<String, Contact> stateContactMap = new TreeMap<>();

	public static void addAddressBook() {
		AddressBookMain addressBook = new AddressBookMain();
		System.out.println("Enter the name of address book");
		String name = sc.next();
		addressBook.manageAddressBook();
		addressBookMap.put(name, addressBook);
	}

	public static void showContactGroupedByCity() {
		Set<String> listOfCity = cityContactMap.keySet();
		for (String city : listOfCity) {
			System.out.println("Contact Entries for CITY: " + city);
			searchPersonInBook(city);
		}
	}

	public static void showContactGroupedByState() {
		Set<String> listOfState = stateContactMap.keySet();
		for (String state : listOfState) {
			System.out.println("Contact Entries for STATE: " + state);
			searchPersonInBook(state);
		}
	}

	public static void searchPersonInBook(String searchIn) {
		Predicate<Contact> search = n -> n.getFirstName().equals(searchIn) ? true : false;
		Consumer<Contact> display = n -> System.out.println(n);
		addressBookMap.forEach((k, v) -> {
			v.getcontactArray().stream().filter(search).forEach(display);
		});
	}

	public static void countByCity() {
		Set<String> listOfCity = cityContactMap.keySet();
		for (String cityName : listOfCity) {
			Contact contactNumber = cityContactMap.get(cityName);
			System.out.println("No of contact entries for CITY " + cityName + " "
					+ ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}

	public static void countByState() {
		Set<String> listOfState = stateContactMap.keySet();
		for (String stateName : listOfState) {
			Contact contactNumber = stateContactMap.get(stateName);
			System.out.println("No of contact entries for STATE " + stateName + " "
					+ ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}

	public static void main(String args[]) {
		AddressBookManagement aBookManager = new AddressBookManagement();
		while (true) {
			System.out.println("\n Please Enter your choice" + "\n1. Add a new Address Book"
					+ "\n2. Search person across all address books" + "\n3. Show contact  by city"
					+ "\n4. Show contacts by state" + "\n5. count contacts  by city" + "\n6. count contacts by state"
					+ "\n7. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				while (true) {
					AddressBookMain m = new AddressBookMain();
					System.out.println("Enter A name for address Book");
					String name = sc.next();
					if (aBookManager.addressBookMap.containsKey(name)) {
						System.out.println("\nAddress Book already exists !!!\n");
						continue;
					} else {
						aBookManager.addressBookMap.put(name, m);
						System.out.println("\n In Address Book : " + name);
						m.manageAddressBook();
						break;
					}
				}
				break;

			case 2:
				System.out.println("Enter city or state to search a person");
				String search = sc.next();
				aBookManager.searchPersonInBook(search);
				break;
			case 3:
				showContactGroupedByCity();
				break;
			case 4:
				showContactGroupedByState();
				break;
			case 5:
				countByCity();
				break;
			case 6:
				countByState();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}
	}
}