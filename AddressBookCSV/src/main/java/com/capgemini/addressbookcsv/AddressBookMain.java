package com.capgemini.addressbookcsv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	AddressBookIO addressBookIO=new AddressBookIO();
	static ArrayList<Contact> contactList;
	public Map<String, Contact> nameToContactMap;
	public Map<String, List<Contact>> cityToContactMap;
	public Map<String, List<Contact>> stateToContactMap;

	public AddressBookMain() {
		contactList = new ArrayList<>();
		nameToContactMap = new LinkedHashMap<String, Contact>();
	}

	public List<Contact> getcontactArray() {
		return contactList;
	}

	public Map<String, Contact> getcontactMap() {
		return nameToContactMap;
	}

	public void addContact() {
		String firstName = "";
		String lastName = "";
		while (true) {
			System.out.println("Enter First Name");
			firstName = sc.next();
			System.out.println("Enter last Name");
			lastName = sc.next();
			if (checkForDuplicate(firstName, lastName))
				continue;
			else
				break;
		}
		System.out.println("Enter the Address");
		String address = sc.next();
		System.out.println("Enter the City");
		String city = sc.next();
		System.out.println("Enter the State");
		String state = sc.next();
		System.out.println("Enter the Pincode");
		int pinCode = sc.nextInt();
		System.out.println("Enter the Number");
		long mobile = sc.nextLong();
		System.out.println("Enter the Email");
		String email = sc.next();
		Contact contact = new Contact(firstName, lastName, address, city, state, pinCode, mobile, email);
		contactList.add(contact);
		String name = firstName + " " + lastName;
		nameToContactMap.put(name, contact);
	}

	public void printContacts() {
		System.out.println(contactList);
	}

	public void editContact() {
		System.out.println("Enter The First Name of the contact to be edited");
		String firstName = sc.next();
		System.out.println("Enter The last Name of the contact to be edited");
		String lastName = sc.next();
		String name = firstName + " " + lastName;
		Contact contact = nameToContactMap.get(name);
		System.out.print("Enter address,city,state,pincode,phonenumber,email");
		String address = sc.next();
		contact.setAddress(address);
		String city = sc.next();
		contact.setCity(city);
		String state = sc.next();
		contact.setState(state);
		int pin = sc.nextInt();
		contact.setPinCode(pin);
		long mobile = sc.nextLong();
		contact.setPhoneNumber(mobile);
		String email = sc.next();
		contact.setEmailId(email);
	}

	public void deleteContact() {
		System.out.println("Enter The First Name to delete the contact details");
		String firstName = sc.next();
		System.out.println("Enter The last Name to delete the contact details");
		String lastName = sc.next();
		String name = firstName + " " + lastName;
		Contact contact = nameToContactMap.get(name);
		contactList.remove(contact);
		nameToContactMap.remove(name);
		System.out.println("Contact deleted");

	}

	public boolean checkForDuplicate(String firstname, String lastname) {
		if (contactList.stream().anyMatch(c -> c.getFirstName().equals(firstname))
				&& contactList.stream().anyMatch(c -> c.getLastName().equals(lastname))) {
			System.out.println("This contact already exists.");
			return true;
		} else
			return false;
	}

	public void sortByName() {
		List<Contact> sortedList = contactList.stream().sorted(Comparator.comparing(Contact::getFirstName))
				.collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}

	public void sortByCity() {
		List<Contact> sortedList = contactList.stream().sorted(Comparator.comparing(Contact::getCity))
				.collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}

	public void sortByState() {
		List<Contact> sortedList = contactList.stream().sorted(Comparator.comparing(Contact::getState))
				.collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}

	public void manageAddressBook() {
		boolean check = true;
		while (check == true) {
			System.out.println("Please select your choice" + "\n1. Add Contact Details" + "\n2. Edit Contact Details"
					+ "\n3. Delete Contact Details" + "\n4. Show Contact details" + "\n5. Sort details by name"
					+ "\n6. Sort details by state" + "\n7. Sort details by city" + "\n8. Exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addContact();
				break;
			case 2:
				if (contactList.size() == 0)
					System.out.println("Plese Enter contacts");
				else
					editContact();
				break;
			case 3:
				if (contactList.size() == 0)
					System.out.println("Plese Enter contacts");
				else
					deleteContact();
				break;
			case 4:
				printContacts();
				break;
			case 5:
				sortByName();
				break;
			case 6:
				sortByState();
				break;
			case 7:
				sortByCity();
				break;
			case 8:
				System.out.println("Exit");
				check = false;
				break;
			}
		}
	}
}
