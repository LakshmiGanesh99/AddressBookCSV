package com.capgemini.addressbookcsv;

import org.junit.Assert;
import org.junit.Test;
public class AddressBookTest 
{
    @Test
    public void given3Contact_WhenWrittenToJSON_ShouldPass()
    {
    		AddressBookJSON addressBookJSON=new AddressBookJSON();
    		int numberOfContacts = addressBookJSON.readAddressBookFromAJSONFile("src/main/resources/AddressBookJSON.json");
    		Assert.assertEquals(3, numberOfContacts);
    }
}