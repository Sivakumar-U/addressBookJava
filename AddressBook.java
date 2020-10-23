package com.blz.addressbook;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	public static List<ContactPerson> person = new ArrayList<ContactPerson>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hello there...Welcome to address book problem");
		AddressBook ab = new AddressBook();
		ab.addContact();
	}

	private void addContact() {
		System.out.println("Enter contact details");
		System.out.println("Enter FirstName:");
		String firstName = sc.next();
		System.out.println("Enter LastName:");
		String lastName = sc.next();
		System.out.println("Enter Address:");
		String address = sc.next();
		System.out.println("Enter City:");
		String city = sc.next();
		System.out.println("Enter State:");
		String state = sc.next();
		System.out.println("Enter Zip:");
		int zip = sc.nextInt();
		System.out.println("Enter PhoneNumber:");
		int phoneNumber = sc.nextInt();
		System.out.println("Enter Email:");
		String email = sc.next();
		ContactPerson contact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		person.add(contact);
		System.out.println("Details are uploaded successfully..");

	}
}
