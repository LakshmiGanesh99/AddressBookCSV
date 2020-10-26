package com.capgemini.addressbookcsv;

import com.opencsv.bean.CsvBindByName;

public class Contact {
	@CsvBindByName
	public String firstName;
	@CsvBindByName
    public String lastName;
	@CsvBindByName
    public String address;
	@CsvBindByName
    public String state;
	@CsvBindByName
    public String city;
	@CsvBindByName
    public int pinCode;
	@CsvBindByName
    public long phoneNumber;
	@CsvBindByName
    public String emailId;


	public Contact(String firstName, String lastName, String address, String city, String state, int pinCode,
			long mobileNumber, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + " \nLast Name: " + lastName + "\nAddress :" + address + "\nCity: " + city
				+ "\nPincode: " + pinCode + "\nState: " + state + "\nPhoneNumber: " + phoneNumber + "\nEmail ID: "
				+ emailId;
	}
}