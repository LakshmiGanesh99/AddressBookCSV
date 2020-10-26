package com.capg.addressbook;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV {
	public String addressBookCSVName;

	public AddressBookCSV(String addressBookCSV) {
		super();
		this.addressBookCSVName = addressBookCSVName;
	}

	public void writeContactDetailsToAFile(List<Contact> contact) {
		try (Writer filewrite = Files.newBufferedWriter(Paths.get(this.addressBookCSVName));) {
			StatefulBeanToCsv<Contact> beanToCSV = new StatefulBeanToCsvBuilder(filewrite)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			beanToCSV.write(contact);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public int readAddressBookFromCSVFile() {
		List<Contact> contactList = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(this.addressBookCSVName));) {
			CSVReader csvReader = new CSVReader(reader);
			List<String[]> contactStringsInFile = csvReader.readAll();
			contactStringsInFile.remove(0);
			contactStringsInFile.stream().forEach(contactsArray -> {
				String firstName = contactsArray[0];
				String lastName = contactsArray[1];
				String address = contactsArray[2];
				String city = contactsArray[3];
				String state = contactsArray[4];
				int zip = Integer.parseInt(contactsArray[5]);
				long phoneNumber = Long.parseLong(contactsArray[6]);
				String email = contactsArray[7];
				Contact contactObj = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				contactList.add(contactObj);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contactList.size();
	}
}