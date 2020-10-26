package com.capgemini.addressbookcsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {
	private static String ADDRESSBOOK_FILE = "newbook.txt";

	public void writeContact(List<Contact> contacts) {
		StringBuffer contactBuffer = new StringBuffer();
		contacts.forEach(contact -> contactBuffer.append(contact.toString().getBytes()));
		try {
			Files.write(Paths.get(ADDRESSBOOK_FILE), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> readContactFile() {
		List<Contact> contactList = new ArrayList<>();
		try {
			Files.lines(Paths.get("addressBookFile.txt")).forEach(lines -> {
				String[] contactsArray = lines.split(",");
				String firstName = contactsArray[0];
				String lastName = contactsArray[1];
				String address = contactsArray[2];
				String city = contactsArray[3];
				String state = contactsArray[4];
				int zip = Integer.parseInt(contactsArray[5]);
				long phone = Long.parseLong(contactsArray[6]);
				String email = contactsArray[7];
				Contact contactObj = new Contact(firstName, lastName, address, city, state, zip, phone, email);
				contactList.add(contactObj);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contactList;
	}
}