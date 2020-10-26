package com.capgemini.addressbookcsv;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
	@Test
	public void given3Contact_WhenWrittenTo_CSVFileShouldPass() {
		AddressBookCSV addressBookCSVobject = new AddressBookCSV("src/main/resources/AddressBookCSV.csv");
		int readCSVContacts = addressBookCSVobject.readAddressBookFromCSVFile();
		Assert.assertEquals(3, readCSVContacts);
	}
}