package com.capgemini.addressbookcsv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AddressBookJSON {
	public AddressBookJSON() {
		super();
	}

	public void writeContactDetailsInAFile(List<Contact> contactList, String filePath) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(contactList);
			FileWriter filewriter = new FileWriter(filePath);
			filewriter.write(json);
			filewriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public int readAddressBookFromAJSONFile(String filePath) {
		AddressBookMain addressBook = new AddressBookMain();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			List<Contact> contactList = new Gson().fromJson(reader, new TypeToken<List<Contact>>() {
			}.getType());
			contactList.stream().forEach(singleContactEntry -> addressBook.addContactToList(singleContactEntry));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressBook.getcontactArray().size();
	}
}
