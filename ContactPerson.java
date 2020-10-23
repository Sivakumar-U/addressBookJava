package com.blz.addressbook;

public class ContactPerson {

	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public long zip;
	public long phoneNumber;
	public String email;

	public ContactPerson(String firstName, String lastName, String address, String city, String state, long zip,
			long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
